package uz.gita.finalexam.ui.usecase.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.finalexam.domain.repository.AppRepository
import uz.gita.finalexam.ui.usecase.PagerUseCase
import javax.inject.Inject

class PagerUseCaseImpl @Inject constructor(
    private val repository: AppRepository
):PagerUseCase {
    override fun savePagerState(state: Boolean): Flow<Unit> = flow{
        repository.savePagerState(state)
        emit(Unit)
    }

}