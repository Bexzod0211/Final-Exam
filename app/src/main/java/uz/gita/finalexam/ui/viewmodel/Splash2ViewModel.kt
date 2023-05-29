package uz.gita.finalexam.ui.viewmodel

import androidx.lifecycle.LiveData

interface Splash2ViewModel {
    fun getPagerState()
    val openPagerScreenLiveData:LiveData<Unit>
    val openSignInScreenLiveData:LiveData<Unit>
    val openMainScreenLiveData:LiveData<Unit>
}