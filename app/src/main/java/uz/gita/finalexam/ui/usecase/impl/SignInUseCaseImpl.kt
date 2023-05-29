package uz.gita.finalexam.ui.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.finalexam.domain.repository.AppRepository
import uz.gita.finalexam.ui.usecase.SignInUseCase
import javax.inject.Inject

class SignInUseCaseImpl @Inject constructor(
    private val repository: AppRepository
):SignInUseCase {
    override fun signInWithEmailAndPassword(email: String, password: String): Flow<Result<String>> {
        return repository.signIntWithEmailAndPassword(email,password)
    }

}