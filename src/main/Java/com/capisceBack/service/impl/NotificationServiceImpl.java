package com.capisceBack.service.impl;

import com.capisceBack.dao.NotificationDao;
import com.capisceBack.model.Notification;
import com.capisceBack.service.NotificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("notificationService")
public class NotificationServiceImpl implements NotificationService {
    @Resource
    private NotificationDao notificationDao;
    @Override
    public void sendNotification(Map<String, Object> data) {
        Date now = new Date();
        data.put("requestDate",now);
        this.notificationDao.sendNotification(data);
    }

    @Override
    public List<Notification> getNotification(Map<String, Object> data) {
        return this.notificationDao.getNotification(data);
    }

    @Override
    public void userLocalAction(Map<String, Object> data) {
        this.notificationDao.userLocalAction(data);
    }

    @Override
    public void userGlobalAction(Map<String, Object> data) {
        this.notificationDao.userGlobalAction(data);
    }

    @Override
    public void senderIgnore(Map<String, Object> data) {
        this.notificationDao.senderIgnore(data);
    }
}
