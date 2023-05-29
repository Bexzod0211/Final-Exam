package uz.gita.finalexam.ui.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.finalexam.domain.repository.AppRepository
import uz.gita.finalexam.ui.usecase.SignUpUseCase
import javax.inject.Inject

class SignUpUseCaseImpl @Inject constructor(
    private val repository: AppRepository
):SignUpUseCase {
    override fun signUpWithEmailAndPassword(email: String, password: String): Flow<Result<String>> {
        return repository.signUpWithEmailAndPassword(email, password)
    }

}