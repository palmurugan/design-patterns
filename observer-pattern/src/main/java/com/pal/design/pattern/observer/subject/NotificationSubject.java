package com.pal.design.pattern.observer.subject;

import com.pal.design.pattern.observer.service.NotificationService;

public interface NotificationSubject {

    void addNotificationService(NotificationService notificationService);

    void removeNotificationService(NotificationService notificationService);

    void notifyAllSubscribers(String message);
}
