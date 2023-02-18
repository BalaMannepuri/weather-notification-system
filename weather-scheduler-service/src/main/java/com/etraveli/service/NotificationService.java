package com.etraveli.service;

import com.etraveli.model.UserInfo;

public interface NotificationService {

    boolean sendNotification(UserInfo userInfo, Integer temp);
}
