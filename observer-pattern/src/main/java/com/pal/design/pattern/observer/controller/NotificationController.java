package com.pal.design.pattern.observer.controller;

import com.pal.design.pattern.observer.manager.NotificationManager;
import com.pal.design.pattern.observer.request.NotificationRequest;
import com.pal.design.pattern.observer.service.SubscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private static final Logger log = LoggerFactory.getLogger(NotificationController.class);

    private final NotificationManager notificationManager;

    private final SubscriptionService subscriptionService;

    public NotificationController(NotificationManager notificationManager,
                                  SubscriptionService subscriptionService) {
        this.notificationManager = notificationManager;
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/subscribe/{type}")
    public ResponseEntity<Void> subscribe(@PathVariable String type) {
        log.info("Request to subscribe a type {}", type);
        subscriptionService.subscribe(type);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/unsubscribe/{type}")
    public ResponseEntity<Void> unSubscribe(@PathVariable String type) {
        log.info("Request to un subscribe a type {}", type);
        subscriptionService.unSubscribe(type);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/send")
    public ResponseEntity<Void> send(@RequestBody NotificationRequest notificationRequest) {
        log.info("Request to send notification to all subscribers");
        notificationManager.notifyAllSubscribers(notificationRequest.message());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
