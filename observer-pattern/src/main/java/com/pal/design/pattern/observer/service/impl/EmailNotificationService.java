package com.pal.design.pattern.observer.service.impl;

import com.pal.design.pattern.observer.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("emailNotificationService")
public class EmailNotificationService implements NotificationService {

    private static final Logger log = LoggerFactory.getLogger(EmailNotificationService.class);

    @Override
    public void sendNotification(String message) {
        log.info("[Notification] - Sending email notification with the message {}", message);
    }
}
