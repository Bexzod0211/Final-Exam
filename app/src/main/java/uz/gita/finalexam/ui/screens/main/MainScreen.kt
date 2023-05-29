package uz.gita.finalexam.ui.screens.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.finalexam.R
import uz.gita.finalexam.databinding.ScreenMainBinding
import uz.gita.finalexam.ui.screens.main.appointment.AppointmentScreen
import uz.gita.finalexam.ui.screens.main.articles.ArticlesScreen
import uz.gita.finalexam.ui.screens.main.history.HistoryScreen
import uz.gita.finalexam.ui.screens.main.home.HomeScreen
import uz.gita.finalexam.ui.screens.main.profile.ProfileScreen
import uz.gita.finalexam.utils.addScreen
import uz.gita.finalexam.utils.replaceScreen

class MainScreen : Fragment(R.layout.screen_main) {
    private val binding by viewBinding(ScreenMainBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        addScreen(HomeScreen())

        binding.bottomNavView.setOnItemSelectedListener {menu->
            when(menu.itemId){
                R.id.menu_home -> {
                    replaceScreen(HomeScreen())
                }
                R.id.menu_appointment ->{
                    replaceScreen(AppointmentScreen())
                }
                R.id.menu_articles->{
                    replaceScreen(ArticlesScreen())
                }
                R.id.menu_history ->{
                    replaceScreen(HistoryScreen())
                }
                R.id.menu_profile ->{
                    replaceScreen(ProfileScreen())
                }
            }
            true
        }
    }
}