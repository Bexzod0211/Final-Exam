package uz.gita.finalexam.ui.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.finalexam.data.model.SpecialityData
import uz.gita.finalexam.data.model.TopDoctorsData
import uz.gita.finalexam.ui.usecase.HomeUseCase
import uz.gita.finalexam.ui.viewmodel.HomeViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModelImpl @Inject constructor(
    private val useCase:HomeUseCase
):HomeViewModel, ViewModel() {
    override val specialtiesLiveData: MutableLiveData<List<SpecialityData>> = MutableLiveData()
    override val doctorsLiveData: MutableLiveData<List<TopDoctorsData>> = MutableLiveData()


    init {
        useCase.loadSpecialtyData().onEach {
            specialtiesLiveData.value = it
        }.launchIn(viewModelScope)

        useCase.loadTopDoctorsData().onEach {
            doctorsLiveData.value = it
        }.launchIn(viewModelScope)
    }



}