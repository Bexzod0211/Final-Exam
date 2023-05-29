package uz.gita.finalexam.ui.usecase

import kotlinx.coroutines.flow.Flow

interface SingInUseCase {
    fun signInWithEmailAndPassword(email:String,password:String):Flow<Result<String>>

}