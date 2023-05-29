package uz.gita.finalexam.ui.screens.main.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.finalexam.R
import uz.gita.finalexam.data.model.SpecialityData
import uz.gita.finalexam.data.model.TopDoctorsData
import uz.gita.finalexam.databinding.ScreenHomeBinding
import uz.gita.finalexam.ui.adapter.SpecialityAdapter
import uz.gita.finalexam.ui.adapter.TopDoctorsAdapter
import uz.gita.finalexam.ui.viewmodel.HomeViewModel
import uz.gita.finalexam.ui.viewmodel.impl.HomeViewModelImpl

@AndroidEntryPoint
class HomeScreen : Fragment(R.layout.screen_home) {
    private val binding by viewBinding(ScreenHomeBinding::bind)
    private val viewModel:HomeViewModel by viewModels<HomeViewModelImpl>()
    private val adapterSpecialities by lazy { SpecialityAdapter() }
    private lateinit var adapterTopDoctors:TopDoctorsAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.doctorsLiveData.observe(viewLifecycleOwner,doctorsObserver)
        viewModel.specialtiesLiveData.observe(viewLifecycleOwner,specialitiesObserver)

        binding.apply {
            recycler1Home.adapter = adapterSpecialities
            recycler1Home.layoutManager = GridLayoutManager(requireContext(),4)


        }
    }

    private val specialitiesObserver = Observer<List<SpecialityData>>{
        adapterSpecialities.submitList(it)
    }

    private val doctorsObserver = Observer<List<TopDoctorsData>> {
        adapterTopDoctors = TopDoctorsAdapter(it)

        binding.apply {
            recycler2Home.adapter = adapterTopDoctors
            recycler2Home.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }
    }
}