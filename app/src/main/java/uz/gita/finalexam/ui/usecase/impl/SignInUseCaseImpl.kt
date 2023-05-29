package uz.gita.finalexam.ui.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.finalexam.domain.repository.AppRepository
import uz.gita.finalexam.ui.usecase.SingInUseCase
import javax.inject.Inject

class SignInUseCaseImpl @Inject constructor(
    private val repository: AppRepository
):SingInUseCase {
    override fun signInWithEmailAndPassword(email: String, password: String): Flow<Result<String>> {
        return repository.signIntWithEmailAndPassword(email,password)
    }

}