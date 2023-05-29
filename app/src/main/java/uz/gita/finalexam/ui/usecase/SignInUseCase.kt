package uz.gita.finalexam.ui.usecase

import kotlinx.coroutines.flow.Flow

interface SignInUseCase {
    fun signInWithEmailAndPassword(email:String,password:String):Flow<Result<String>>

}