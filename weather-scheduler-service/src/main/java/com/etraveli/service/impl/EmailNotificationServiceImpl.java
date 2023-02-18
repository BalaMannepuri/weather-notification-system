package com.etraveli.service.impl;

import com.etraveli.model.UserInfo;
import com.etraveli.service.NotificationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component("emailNotification")
@Configuration
@EnableAsync
public class EmailNotificationServiceImpl implements NotificationService {

    private Logger logger = Logger.getLogger(EmailNotificationServiceImpl.class);
    @Value("${weather.email.message}")
    private String message;
    @Override
    @Async  // these notification Asychronoisly work
    public boolean sendNotification(UserInfo userInfo, Integer temp) {
        logger.info(" Email Sending to this email: "+userInfo.getEmail()+" : "+String.format(message,userInfo.getName(),userInfo.getCity(),temp));
        return true;
    }
}
