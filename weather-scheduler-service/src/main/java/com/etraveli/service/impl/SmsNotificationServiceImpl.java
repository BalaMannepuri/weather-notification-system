package com.etraveli.service.impl;

import com.etraveli.model.UserInfo;
import com.etraveli.service.NotificationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;


@Component("smsNotification")
@Configuration
@EnableAsync
public class SmsNotificationServiceImpl implements NotificationService {

    private Logger logger = Logger.getLogger(SmsNotificationServiceImpl.class);
    @Value("${weather.sms.message}") // message template will pick from application.properties
    private String message;
    @Override
    @Async  // these notification Asychronoisly work
    public boolean sendNotification(UserInfo userInfo, Integer temp) {
        logger.info(" Sending to this message mobile: "+userInfo.getPhone() +" :"+String.format(message,userInfo.getName(),userInfo.getCity(),temp));
        return true;
    }
}
