package com.capisceBack.service;

import com.capisceBack.model.Notification;

import java.util.List;
import java.util.Map;

public interface NotificationService {
    public void sendNotification(Map<String, Object> data);
    public List<Notification> getNotification(Map<String, Object> data);
    public void userLocalAction(Map<String, Object> data);
    public void userGlobalAction(Map<String, Object> data);
    public void senderIgnore(Map<String, Object> data);
}
