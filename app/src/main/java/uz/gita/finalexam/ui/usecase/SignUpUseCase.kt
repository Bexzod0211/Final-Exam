package uz.gita.finalexam.ui.usecase

import kotlinx.coroutines.flow.Flow

interface SignUpUseCase {
    fun signUpWithEmailAndPassword(email:String,password:String):Flow<Result<String>>
}