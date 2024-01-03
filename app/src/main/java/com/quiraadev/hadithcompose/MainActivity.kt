package com.quiraadev.hadithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.chibatching.kotpref.Kotpref
import com.example.compose.AppTheme
import com.quiraadev.hadithcompose.core.viewmodel.HomeViewModel
import com.quiraadev.hadithcompose.ui.navigations.AppRouter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Kotpref.init(this@MainActivity)
        setContent {
            val homeViewModel: HomeViewModel = hiltViewModel()
            AppTheme(useDarkTheme = homeViewModel.isDarkMode.value) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppRouter().RouterDelegate(
                        homeViewModel = hiltViewModel(),
                        hadithViewModel = hiltViewModel(),
                        detailViewModel = hiltViewModel()
                    )
                }
            }
        }
    }
}