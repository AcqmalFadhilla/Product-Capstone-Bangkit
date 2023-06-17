package com.reev.telokkaapps.utility.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class NotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val planTitle = intent.getStringExtra("planTitle") ?: ""
        val planDate = intent.getStringExtra("planDate") ?: ""
        val notificationId = intent.getIntExtra("notificationId", 0)

        NotificationUtils.showNotification(context, planTitle, planDate, notificationId)
    }
}
