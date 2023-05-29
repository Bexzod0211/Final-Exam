package uz.gita.finalexam.ui.viewmodel

import androidx.lifecycle.LiveData

interface SignEnterViewModel {
    val openSignInScreenLiveData:LiveData<Unit>
    val openSignUpScreenLiveData:LiveData<Unit>

    fun btnSignUpClicked()
    fun btnSignInClicked()
}