package com.app.schoolappv2

import android.os.Bundle
import android.widget.Button
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

class ChangeBathroomAvailability : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_changebathroomavailability)

        val boysView = findViewById<Button>(R.id.boysBathroomSelectionButton)
        val girlsView = findViewById<Button>(R.id.girlsBathroomSelectionButton)

        findViewById<Button>(R.id.girlsBathroomSelectionButton)
            .setOnClickListener{
                boysView.background = ContextCompat.getDrawable(this, R.drawable.closed_textview)
                girlsView.background = ContextCompat.getDrawable(this, R.drawable.open_textview)
            }

        findViewById<Button>(R.id.boysBathroomSelectionButton)
            .setOnClickListener{
                boysView.background = ContextCompat.getDrawable(this, R.drawable.open_textview)
                girlsView.background = ContextCompat.getDrawable(this, R.drawable.closed_textview)

            }
    }
}
