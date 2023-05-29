package uz.gita.finalexam.ui.screens.splash2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.finalexam.R
import uz.gita.finalexam.ui.viewmodel.Splash2ViewModel
import uz.gita.finalexam.ui.viewmodel.impl.Splash2ViewModelImpl

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreen2 : Fragment(R.layout.screen_splash2) {
    private val viewModel:Splash2ViewModel by viewModels<Splash2ViewModelImpl>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openPagerScreenLiveData.observe(this,openPagerScreenObserver)
        viewModel.openSignInScreenLiveData.observe(this,openSingInScreenObserver)
        viewModel.openMainScreenLiveData.observe(this,openMainScreenObserver)
    }

    val openPagerScreenObserver = Observer<Unit>{
        lifecycleScope.launch {
            delay(1000)
            findNavController().navigate(R.id.action_splashScreen2_to_pagerScreen)
        }
    }

    val openSingInScreenObserver =  Observer<Unit> {
        lifecycleScope.launch {
            delay(1000)
            findNavController().navigate(R.id.action_splashScreen2_to_enterSignScreen)
        }
    }

    private val openMainScreenObserver = Observer<Unit> {
        lifecycleScope.launch {
            delay(1000)
            findNavController().navigate(R.id.action_splashScreen2_to_mainScreen)
        }
    }
}