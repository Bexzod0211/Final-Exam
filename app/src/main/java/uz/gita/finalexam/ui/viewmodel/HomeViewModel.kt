package uz.gita.finalexam.ui.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.finalexam.data.model.SpecialityData
import uz.gita.finalexam.data.model.TopDoctorsData

interface HomeViewModel {
    val specialtiesLiveData:LiveData<List<SpecialityData>>
    val doctorsLiveData:LiveData<List<TopDoctorsData>>


}