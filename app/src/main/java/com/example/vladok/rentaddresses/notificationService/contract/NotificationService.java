package com.example.vladok.rentaddresses.notificationService.contract;


import android.content.Context;

import com.example.vladok.rentaddresses.domain.RentAddress;
import com.example.vladok.rentaddresses.listener.ResponseListenerManager;


public interface NotificationService extends ResponseListenerManager {
    void sendNotification(Context context, RentAddress entity);
}
