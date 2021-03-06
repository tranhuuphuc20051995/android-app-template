package dev.alejandrorosas.featuretemplate.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import dev.alejandrorosas.core.ui.AppTheme

@Composable
fun FeatureTemplate(navController: NavController) {
    // Temporary until hilt-navigation-compose is released
    // https://android-review.googlesource.com/c/platform/frameworks/support/+/1551264
    val viewModel = ViewModelProvider(
        LocalViewModelStoreOwner.current,
        HiltViewModelFactory(LocalContext.current, LocalViewModelStoreOwner.current as NavBackStackEntry),
    ).get(FeatureTemplateViewModel::class.java)
    Screen(viewModel) { navController.popBackStack() }
}

@Composable
fun Screen(featureTemplateViewModel: FeatureTemplateViewModel, onNavigateBack: () -> Unit) {
    val counter: Int by featureTemplateViewModel.counter.observeAsState(0)
    AppTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Feature Template")
                    },
                    navigationIcon = {
                        IconButton(onClick = { onNavigateBack() }) {
                            Icon(Icons.Filled.ArrowBack, contentDescription = null)
                        }
                    },
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { }) {
                    IconButton(onClick = { featureTemplateViewModel.onCounterClick() }) {
                        Icon(Icons.Filled.Add, contentDescription = null)
                    }
                }
            },
        ) {
            ScreenContent(counter)
        }
    }
}

@Composable
fun ScreenContent(count: Int) {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Text(
            text = "FAB has been clicked $count times",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxWidth(),
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
//    Screen { }
}
