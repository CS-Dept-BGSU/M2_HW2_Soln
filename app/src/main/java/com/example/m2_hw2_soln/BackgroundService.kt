package com.example.m2_hw2_soln

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class BackgroundService : Service() {

    companion object {
        private const val TAG = "BackgroundService"
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Service created")
    }

    /**
     * TODO: Implement this method to handle the intent received from MainActivity
     * Extract the message from the intent extras with key "message"
     * Display a Toast notification with the received message
     * Return the appropriate start command result
     *
     * Toast example:
     * // Toast.makeText(applicationContext, "Your message here", Toast.LENGTH_SHORT).show()
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Check if intent is null
        if (intent == null) {
            Log.d(TAG, "Service started with null intent")
            return START_NOT_STICKY
        }

        // Extract the message from intent extras
        val message = intent.getStringExtra("message")

        // Log the received message
        Log.d(TAG, "Received message: $message")

        // Display toast notification with the message
        if (!message.isNullOrEmpty()) {
            Toast.makeText(applicationContext, "Processing: $message", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "No message received", Toast.LENGTH_SHORT).show()
        }

        // Return START_REDELIVER_INTENT to have the intent redelivered if the service restarts
        return START_REDELIVER_INTENT
    }

    override fun onBind(intent: Intent?): IBinder? {
        // This service doesn't support binding
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Service destroyed")
    }
}