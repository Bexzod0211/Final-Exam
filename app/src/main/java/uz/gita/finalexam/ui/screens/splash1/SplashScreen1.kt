package uz.gita.finalexam.ui.screens.splash1

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.finalexam.R

@SuppressLint("CustomSplashScreen")
class SplashScreen1 : Fragment(R.layout.screen_splash) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launch {
            delay(1000)
            findNavController().navigate(R.id.action_splashScreen1_to_splashScreen2)
        }
    }
}