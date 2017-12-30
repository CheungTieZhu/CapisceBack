package com.capisceBack.dao;

import com.capisceBack.model.Notification;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface NotificationDao {
    void  sendNotification(@Param("data")Map<String, Object> data);
    List<Notification> getNotification(@Param("data")Map<String, Object> data);
    void  userLocalAction(@Param("data")Map<String, Object> data);
    void  userGlobalAction(@Param("data")Map<String, Object> data);
    void  senderIgnore(@Param("data")Map<String, Object> data);
}
