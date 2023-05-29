package uz.gita.finalexam.ui.usecase.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.finalexam.data.model.SpecialityData
import uz.gita.finalexam.data.model.TopDoctorsData
import uz.gita.finalexam.domain.repository.AppRepository
import uz.gita.finalexam.ui.usecase.HomeUseCase
import javax.inject.Inject

class HomeUseCaseImpl @Inject constructor(
    private val repository: AppRepository
) : HomeUseCase {
    override fun loadSpecialtyData(): Flow<List<SpecialityData>> = flow{
        emit(repository.getSpecialitiesData())
    }

    override fun loadTopDoctorsData(): Flow<List<TopDoctorsData>>  = flow{
        emit(repository.getTopDoctorsData())
    }


}