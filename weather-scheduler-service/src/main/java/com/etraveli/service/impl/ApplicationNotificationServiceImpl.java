package com.etraveli.service.impl;

import com.etraveli.model.UserInfo;
import com.etraveli.service.NotificationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component("appNotification")
@Configuration
@EnableAsync
public class ApplicationNotificationServiceImpl implements NotificationService {

    private Logger logger = Logger.getLogger(ApplicationNotificationServiceImpl.class);
    @Value("${weather.app.message}")
    private String message;
//    @Autowired
//    private MessageSource messageSource;

    @Override
    @Async // these notification Asychronoisly work
    public boolean sendNotification(UserInfo userInfo, Integer temp) {
        /* based on language we can send the message*/
      //  String message = messageSource.getMessage("weather.app.message",null, new Locale("hi", "IN"));
        logger.info(" publishing Notification to Application : "+ String.format(message,userInfo.getName(),userInfo.getCity(),temp));
        return true;
    }
}
