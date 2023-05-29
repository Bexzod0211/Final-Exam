package uz.gita.finalexam.ui.usecase

import kotlinx.coroutines.flow.Flow

interface Splash2UseCase {
    fun getPagerState():Flow<Boolean>

    fun isSignedIn():Flow<Boolean>
}