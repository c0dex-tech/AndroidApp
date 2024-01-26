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

// Activity class for changing bathroom availability
class ChangeBathroomAvailability : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content view using the specified layout file
        setContentView(R.layout.activity_changebathroomavailability)

        // Get references to buttons for boys and girls bathrooms
        val boysView = findViewById<Button>(R.id.boysBathroomSelectionButton)
        val girlsView = findViewById<Button>(R.id.girlsBathroomSelectionButton)

        // Button click listener for girls bathroom selection
        findViewById<Button>(R.id.girlsBathroomSelectionButton)
            .setOnClickListener{
                // Change background drawable to indicate the girls bathroom is open and boys is closed
                boysView.background = ContextCompat.getDrawable(this, R.drawable.closed_textview)
                girlsView.background = ContextCompat.getDrawable(this, R.drawable.open_textview)
            }

        // Button click listener for boys bathroom selection
        findViewById<Button>(R.id.boysBathroomSelectionButton)
            .setOnClickListener{
                // Change background drawable to indicate the boys bathroom is open and girls is closed
                boysView.background = ContextCompat.getDrawable(this, R.drawable.open_textview)
                girlsView.background = ContextCompat.getDrawable(this, R.drawable.closed_textview)
            }
    }
}
