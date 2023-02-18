package com.etraveli.scheduler;

import com.etraveli.model.UserInfo;
import com.etraveli.repository.UserInfoRepository;
import com.etraveli.service.NotificationService;
import com.etraveli.service.WeatheService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@EnableScheduling
@Component
@PropertySource("classpath:/application.properties")
public class WeatherNotificationScheduler {

    @Autowired
    @Qualifier("appNotification")
    private NotificationService applicationNotificationService;

    @Autowired
    @Qualifier("smsNotification")
    private NotificationService smsNotificationService;

    @Autowired
    @Qualifier("emailNotification")
    private NotificationService emailNotificationService;

    @Autowired
    private WeatheService weatheService;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Value("#{'${weather.api.uri}'.split(',')}")
    private List<String> uris;
    private Logger logger = Logger.getLogger(WeatherNotificationScheduler.class);

    /*
    1. for testing purpose cron expression is 1 minute,
    2. Cron expression is in application level, if we put in user level the api calls we will increase
    * */
    @Scheduled(cron = "${weather.info.cron}")
    public void weatherSchduler() {
        logger.info("\n\n ---------------  Scheduler work is going on ----------------------\n");
        List<UserInfo> usersList = userInfoRepository.getUserInfo(); // we are caching the data only one time, we have created dummy data
        List<String> cityList = usersList.stream().map(UserInfo::getCity).distinct().collect(Collectors.toList());
        Integer apiProviderCounter = 0;
        Integer sum = 0;
        Integer result = 0;
        // we will call the weather api per city, it will reduces cost for api
        for (String city : cityList) {
            apiProviderCounter = 0;
            sum = 0;
            /* we can call multiple weather api calls just we need update the uri in application.properties for weather.api.uri in list
               if any exception occured in apiProvider, we will not considered the value
             */
            for (String uri : uris) {
                try {
                    result = weatheService.sendGet(uri + city);
                    sum = sum + result;
                    if (result != 999) {
                        apiProviderCounter++;
                    }
                } catch (Exception e) {
                    logger.error("Exception : " + e.getMessage());
                }
            }

            sendNotification(usersList, apiProviderCounter, sum, city);
        }
    }

    /* Sending notification as per the configuration like city, user configured temperature,
    * it will work on asychronously
    * */
    private void sendNotification(List<UserInfo> usersList, Integer apiProviderCounter, Integer sum, String city) {
        Integer temp;
        List<UserInfo> cityUsersList = usersList.stream().filter(e -> e.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
        if (apiProviderCounter != 0) {
            temp = sum / apiProviderCounter;
            for (UserInfo cityUser : cityUsersList) {
                if (cityUser.isSmsEnabled() && cityUser.getTemperature() <= temp) {
                    smsNotificationService.sendNotification(cityUser, temp);
                }
                if (cityUser.isAppEnabled() && cityUser.getTemperature() <= temp) {
                    applicationNotificationService.sendNotification(cityUser, temp);
                }
                if (cityUser.isEmailEnabled() && cityUser.getTemperature() <= temp) {
                    emailNotificationService.sendNotification(cityUser, temp);
                }
            }
        } else {
            /* if any api provider is not working, if we want to notify the user we can do it here*/
            logger.info("Weather APIs are not working");
            // if any weather api is not will notify user based on requirement
        }
    }
}
