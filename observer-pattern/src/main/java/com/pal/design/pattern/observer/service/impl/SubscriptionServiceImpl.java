package com.pal.design.pattern.observer.service.impl;

import com.pal.design.pattern.observer.manager.NotificationManager;
import com.pal.design.pattern.observer.service.NotificationService;
import com.pal.design.pattern.observer.service.SubscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private static final Logger log = LoggerFactory.getLogger(SubscriptionServiceImpl.class);

    private final NotificationManager notificationManager;

    private final NotificationService emailNotificationService;

    private final NotificationService smsNotificationService;

    @Autowired
    public SubscriptionServiceImpl(
            NotificationManager notificationManager,
            @Qualifier("emailNotificationService") NotificationService emailNotificationService,
            @Qualifier("smsNotificationService") NotificationService smsNotificationService
    ) {
        this.notificationManager = notificationManager;
        this.emailNotificationService = emailNotificationService;
        this.smsNotificationService = smsNotificationService;
    }

    @Override
    public void subscribe(String type) {
        log.info("Subscribing a new notification type {}", type);
        switch (type.toLowerCase()) {
            case "email":
                notificationManager.addNotificationService(emailNotificationService);
                break;
            case "sms":
                notificationManager.addNotificationService(smsNotificationService);
                break;
            default:
                throw new RuntimeException("Invalid Subscription!");

        }
    }

    @Override
    public void unSubscribe(String type) {
        log.info("Un subscribing a notification type {}", type);
        switch (type.toLowerCase()) {
            case "email":
                notificationManager.removeNotificationService(emailNotificationService);
                break;
            case "sms":
                notificationManager.removeNotificationService(smsNotificationService);
                break;
            default:
                throw new RuntimeException("Invalid Subscription Type!");

        }
    }
}
