package uz.gita.finalexam.ui.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.finalexam.R
import uz.gita.finalexam.ui.screens.pager.PageItemScreen

class PagerAdapter(fm:FragmentManager,lifecycle:Lifecycle) : FragmentStateAdapter(fm,lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        val screen = PageItemScreen()
        val bundle = Bundle()
        var image = 0
        var text = ""
        when(position){
            0->{
                image = R.drawable.img1_pager
                text = "Thousands of\ndoctors & experts to\nhelp your health!"
            }
            1->{
                image = R.drawable.img2_pager
                text = "Health checks &\n consultations easily\nanywhere anytime"
            }
            2->{
                image = R.drawable.img3_pager
                text = "Let's start living\nhealthy and well\nwith us right now!"
            }
        }

        bundle.putInt("image",image)
        bundle.putString("text",text)
        screen.arguments = bundle

        return screen
    }

}