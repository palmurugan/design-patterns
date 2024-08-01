package com.pal.design.pattern.observer.manager;

import com.pal.design.pattern.observer.service.NotificationService;
import com.pal.design.pattern.observer.subject.NotificationSubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotificationManager implements NotificationSubject {

    private static final Logger log = LoggerFactory.getLogger(NotificationManager.class);
    List<NotificationService> notificationServiceList = new ArrayList<>();

    @Override
    public void addNotificationService(NotificationService notificationService) {
        notificationServiceList.add(notificationService);
    }

    @Override
    public void removeNotificationService(NotificationService notificationService) {
        notificationServiceList.remove(notificationService);
    }

    @Override
    public void notifyAllSubscribers(String message) {
        if (notificationServiceList.isEmpty()) {
            log.info("No subscribers found!");
        } else {
            notificationServiceList.forEach(
                    notificationService -> notificationService.sendNotification(message)
            );
        }
    }
}
