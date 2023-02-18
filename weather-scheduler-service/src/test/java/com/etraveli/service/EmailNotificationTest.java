package com.etraveli.service;

import com.etraveli.model.UserInfo;
import com.etraveli.service.impl.EmailNotificationServiceImpl;
import com.etraveli.service.impl.SmsNotificationServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmailNotificationTest {

    @Mock
    private NotificationService emailNotificationService = new EmailNotificationServiceImpl();
   @Test
    public void sendNotificationTest() {
       Mockito.when(emailNotificationService.sendNotification(new UserInfo(1L, "Prasanna", "abc@gmail.com", "pune", "1234567890", 20, true, true, true), 25))
               .thenReturn(true);
      boolean result=emailNotificationService.sendNotification(new UserInfo(1L, "Prasanna", "abc@gmail.com", "pune", "1234567890", 20, true, true, true), 25);
       Assertions.assertTrue(result);
    }
}
