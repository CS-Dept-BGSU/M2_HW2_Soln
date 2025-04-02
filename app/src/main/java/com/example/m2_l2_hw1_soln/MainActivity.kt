package com.example.m2_l2_hw1_soln

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var messageEditText: EditText
    private lateinit var sendToActivityButton: Button
    private lateinit var startServiceButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        messageEditText = findViewById(R.id.editTextMessage)
        sendToActivityButton = findViewById(R.id.buttonSendToActivity)
        startServiceButton = findViewById(R.id.buttonStartService)

        // Set up button click listeners
        setupButtonListeners()
    }

    private fun setupButtonListeners() {
        // Button to send message to SecondaryActivity
        sendToActivityButton.setOnClickListener {
            sendMessageToSecondaryActivity()
        }

        // Button to start the BackgroundService
        startServiceButton.setOnClickListener {
            startBackgroundService()
        }
    }

    /**
     * TODO: Implement this method to send a message to SecondaryActivity
     *
     * Expected Implementation:
     * val intent = Intent(this, SecondaryActivity::class.java)
     * intent.putExtra("message", message)
     * startActivity(intent)
     */
    private fun sendMessageToSecondaryActivity() {
        val message = messageEditText.text.toString()
        val intent = Intent(this, SecondaryActivity::class.java)
        intent.putExtra("message", message)
        startActivity(intent)
    }

    /**
     * TODO: Implement this method to start the BackgroundService
     *
     * Expected Implementation:
     * val intent = Intent(this, BackgroundService::class.java)
     * intent.putExtra("message", message)
     * startService(intent)
     */
    private fun startBackgroundService() {
        val message = messageEditText.text.toString()
        val intent = Intent(this, BackgroundService::class.java)
        intent.putExtra("message", message)
        startService(intent)
    }
}