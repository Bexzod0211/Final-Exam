package uz.gita.finalexam.ui.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.finalexam.data.model.SpecialityData
import uz.gita.finalexam.data.model.TopDoctorsData

interface HomeUseCase {
    fun loadSpecialtyData():Flow<List<SpecialityData>>
    fun loadTopDoctorsData():Flow<List<TopDoctorsData>>
}