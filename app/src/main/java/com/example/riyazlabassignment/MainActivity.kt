package com.example.riyazlabassignment



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.example.riyazlabassignment.ui.theme.*
import com.ramcosta.composedestinations.DestinationsNavHost


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabAssignmentTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    DestinationsNavHost(navGraph = NavGraphs.root)
                }
            }
        }
    }
}
