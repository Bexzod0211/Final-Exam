package uz.gita.finalexam.ui.usecase.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.finalexam.domain.repository.AppRepository
import uz.gita.finalexam.ui.usecase.Splash2UseCase
import javax.inject.Inject

class Splash2UseCaseImpl @Inject constructor(
    private val repository:AppRepository
) : Splash2UseCase {
    override fun getPagerState(): Flow<Boolean>  = flow{
        emit(repository.getPagerState())
    }

    override fun isSignedIn(): Flow<Boolean> = flow{
        emit(repository.isSignedIn())
    }
}