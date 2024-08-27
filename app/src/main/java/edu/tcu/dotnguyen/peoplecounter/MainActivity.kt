package edu.tcu.dotnguyen.peoplecounter

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Make sủe app can run full screen
        //
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var count = 0

        val countTextView  = findViewById<TextView>(R.id.textView);
        val button1  = findViewById<Button>(R.id.button);
        val button2  = findViewById<Button>(R.id.button2);

        // Current Toast to display
        var toastVar: Toast? = null

        // When clicking button, count increase by 1
        // toastVar?.cancel()
        button1.setOnClickListener { _ ->
            count++
            countTextView.text = count.toString()
        }

        button2.setOnClickListener { _ ->
            var previouscount = count
            count = 0
            countTextView.text = count.toString()

            // Cancel the currently showing toast if there is current any
            toastVar?.cancel()

            // Adding the toast to display to toastVar
            toastVar = Toast.makeText(this, "Previous count number is $previouscount", Toast.LENGTH_SHORT);
            // Display it
            toastVar?.show();
        }
    }
}