package uz.gita.finalexam.ui.screens.pager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.finalexam.R
import uz.gita.finalexam.databinding.ScreenPagerBinding
import uz.gita.finalexam.ui.adapter.PagerAdapter
import uz.gita.finalexam.ui.viewmodel.PagerViewModel
import uz.gita.finalexam.ui.viewmodel.impl.PagerViewModelImpl

@AndroidEntryPoint
class PagerScreen : Fragment(R.layout.screen_pager) {
    private val binding by viewBinding(ScreenPagerBinding::bind)
    private lateinit var callback:ViewPager2.OnPageChangeCallback
    private val viewModel:PagerViewModel by viewModels<PagerViewModelImpl>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            pager.adapter = PagerAdapter(parentFragmentManager,lifecycle)
            dotsIndicator.attachTo(pager)
        }

        callback = object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position){
                    0,1->{
                        binding.btnNext.text = "Next"
                    }
                    2->{
                        binding.btnNext.text = "Get Started"
                    }
                }
            }
        }

        binding.apply {
            pager.isUserInputEnabled = false
            btnNext.setOnClickListener {
                if (pager.currentItem < 2){
                    ++pager.currentItem
                }
                else{
                    viewModel.btnStartClicked()
                }
            }
        }

        binding.pager.registerOnPageChangeCallback(callback)

        viewModel.openSignScreenLiveData.observe(viewLifecycleOwner,openSignScreenObserver)
    }

    private val openSignScreenObserver = Observer<Unit>{
        findNavController().navigate(R.id.action_pagerScreen_to_enterSignScreen)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding.pager.unregisterOnPageChangeCallback(callback)
    }


}