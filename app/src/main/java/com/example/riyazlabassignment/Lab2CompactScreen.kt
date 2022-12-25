package com.example.riyazlabassignment

import android.Manifest
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.riyazlabassignment.destinations.HomeScreenDestination
import com.example.riyazlabassignment.ui.theme.*
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Composable
fun Lab2CompactScreen(navigator: DestinationsNavigator){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(DeepBlue)){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
        ) {
            TitleSection()
            Spacer(modifier = Modifier.height(20.dp))
            Activity()
            MultipleScreenSize()
            PermissionStatus()

        }
        Box(
            contentAlignment = Center,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(horizontal = 20.dp, vertical = 45.dp)
                .clip(RoundedCornerShape(40.dp))
                .clickable {
                    navigator.navigate(HomeScreenDestination)
                }
                .background(ButtonBlue)
        ) {
            Text(
                text = "  Home  ",
                color = TextWhite,
                modifier = Modifier.padding(15.dp),
                style = Typography.h2
            )
        }
    }


}

@Composable
fun TitleSection(){
    Text(text = "Lab 2 Screen", style = Typography.h1, color = TextWhite)
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionStatus(){
    Column(
        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Permissions", style = Typography.h2, color = TextWhite, textAlign = TextAlign.Center)
        val permissionsState = rememberMultiplePermissionsState(
            permissions = listOf
                (
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        )

        val lifecycleOwner = LocalLifecycleOwner.current
        DisposableEffect(
            key1 = lifecycleOwner,
            effect = {
                val observer = LifecycleEventObserver{ _, event ->
                    if (event == Lifecycle.Event.ON_START){
                        permissionsState.launchMultiplePermissionRequest()
                    }
                }
                lifecycleOwner.lifecycle.addObserver(observer)

                onDispose {
                    lifecycleOwner.lifecycle.removeObserver(observer)
                }
            }
        )
        permissionsState.permissions.forEach { perm ->
            when(perm.permission){
                Manifest.permission.CAMERA ->{
                    when {
                        perm.hasPermission ->{
                            Box(modifier = Modifier
                                .padding(15.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(20.dp))
                                .background(LightGreen1), contentAlignment = Center
                            ){
                                Text(
                                    text = "CAMERA Permission is granted",
                                    style = Typography.h2,
                                    modifier = Modifier.padding(15.dp)
                                )
                            }
                        }
                        perm.shouldShowRationale ->{
                            Box(modifier = Modifier
                                .padding(15.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(20.dp))
                                .background(LightRed), contentAlignment = Center
                            ) {
                                Text(
                                    text = "CAMERA Permission is required to take photos",
                                    style = Typography.h2,
                                    modifier = Modifier.padding(15.dp), textAlign = TextAlign.Justify

                                )
                            }
                        }
                        perm.isPermanentlyDenied() ->{
                            Box(modifier = Modifier
                                .padding(15.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(20.dp))
                                .background(LightRed), contentAlignment = Center
                            ) {
                                Text(
                                    text = "CAMERA Permission is Disabled, you can got to app settings to enable it back.",
                                    style = Typography.h2,
                                    modifier = Modifier.padding(15.dp), textAlign = TextAlign.Justify
                                )
                            }
                        }
                    }

                }

                Manifest.permission.ACCESS_COARSE_LOCATION ->{
                    when {
                        perm.hasPermission ->{
                            Box(modifier = Modifier
                                .padding(15.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(20.dp))
                                .background(LightGreen1), contentAlignment = Center
                            ) {
                                Text(
                                    text = "LOCATION Permission is granted",
                                    style = Typography.h2,
                                    modifier = Modifier.padding(15.dp)
                                )
                            }
                        }
                        perm.shouldShowRationale ->{
                            Box(modifier = Modifier
                                .padding(15.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(20.dp))
                                .background(LightRed), contentAlignment = Center
                            ) {
                                Text(
                                    text = "LOCATION Permission is required to take photos",
                                    style = Typography.h2,
                                    modifier = Modifier.padding(15.dp), textAlign = TextAlign.Justify
                                )
                            }
                        }
                        perm.isPermanentlyDenied() ->{
                            Box(modifier = Modifier
                                .padding(15.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(20.dp))
                                .background(LightRed), contentAlignment = Center
                            ) {
                                Text(
                                    text = "LOCATION Permission is Disabled, you can got to app settings to enable it back.",
                                    style = Typography.h2,
                                    modifier = Modifier.padding(15.dp), textAlign = TextAlign.Justify
                                )
                            }
                        }
                    }

                }

            }
        }
    }
}

@Composable
fun Activity(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "More than one Activity", style = Typography.h2, color = TextWhite, textAlign = TextAlign.Center)
        Box(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(LightGreen1), contentAlignment = Center
        ) {
            Text(
                text = "This page is Activity 2, Click on HOME button to go to the Activity 1",
                style = Typography.h2,
                modifier = Modifier.padding(15.dp), textAlign = TextAlign.Justify
            )
        }
    }
}

@Composable
fun MultipleScreenSize(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Multiple Screen Size", style = Typography.h2, color = TextWhite, textAlign = TextAlign.Center)
        Box(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(LightGreen1), contentAlignment = Center
        ) {
            Text(
                text = "Rotate your phone to landscape to view the App contents in Tablet or Landscape mode",
                style = Typography.h2,
                modifier = Modifier.padding(15.dp), textAlign = TextAlign.Justify
            )
        }
    }
}