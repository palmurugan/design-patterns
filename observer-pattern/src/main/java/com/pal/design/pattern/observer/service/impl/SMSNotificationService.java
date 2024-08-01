package com.pal.design.pattern.observer.service.impl;

import com.pal.design.pattern.observer.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("smsNotificationService")
public class SMSNotificationService implements NotificationService {

    private static final Logger log = LoggerFactory.getLogger(SMSNotificationService.class);

    @Override
    public void sendNotification(String message) {
        log.info("[Notification] - Sending SMS notification with the message {}", message);
    }
}
