package com.reev.telokkaapps.utility.notification

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.reev.telokkaapps.R
import com.reev.telokkaapps.ui.dashboard.MainActivity
import java.text.SimpleDateFormat
import java.util.*

object NotificationUtils {
    private const val CHANNEL_ID = "reminder_channel"
    private const val CHANNEL_NAME = "Reminder Channel"

    fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                lightColor = Color.BLUE
                enableLights(true)
            }

            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun scheduleNotification(
        context: Context,
        planTitle: String,
        planDate: String,
        notificationId: Int
    ) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val notificationIntent = Intent(context, NotificationReceiver::class.java).apply {
            putExtra("planTitle", planTitle)
            putExtra("planDate", planDate)
            putExtra("notificationId", notificationId)
        }
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            notificationId,
            notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val planDateTime = dateFormat.parse(planDate)!!

        val calendar = Calendar.getInstance().apply {
            time = planDateTime
            add(Calendar.DAY_OF_YEAR, -1) // Set the notification one day before the planDate
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC,
                calendar.timeInMillis,
                pendingIntent
            )
        } else {
            alarmManager.setExact(
                AlarmManager.RTC,
                calendar.timeInMillis,
                pendingIntent
            )
        }
    }

    fun showNotification(
        context: Context,
        planTitle: String,
        planDate: String,
        notificationId: Int
    ) {
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            context,
            notificationId,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val notificationBuilder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setColor(ContextCompat.getColor(context, R.color.blue_500))
            .setContentTitle(planTitle)
            .setContentText("Plan Date: $planDate")
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationBuilder.setChannelId(CHANNEL_ID)
        }

        val notification = notificationBuilder.build()
        notificationManager.notify(notificationId, notification)
    }
}
