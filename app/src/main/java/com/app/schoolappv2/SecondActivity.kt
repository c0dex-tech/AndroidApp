package com.app.schoolappv2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.app.schoolappv2.ui.theme.SchoolAppV2Theme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_second)

        val switch = findViewById<Switch>(R.id.switch1)
        val text = findViewById<TextView>(R.id.openClosedTextView)

       switch.setOnCheckedChangeListener { buttonView, isChecked ->
           if(isChecked){
               text.background = ContextCompat.getDrawable(this, R.drawable.open_textview)
               text.setTextColor(ContextCompat.getColor(this, R.color.openTextViewColour))
               text.setText("Open")
           }else{
               text.background = ContextCompat.getDrawable(this, R.drawable.closed_textview)
               text.setTextColor(ContextCompat.getColor(this, R.color.closedTextViewColour))
               text.setText("Closed")
           }
       }

        findViewById<Button>(R.id.changeBathroomAvailability)
            .setOnClickListener {
                val intent = Intent(this, ChangeBathroomAvailability::class.java)
                startActivity(intent)
            }
    }
}
