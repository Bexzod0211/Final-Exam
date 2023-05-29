package uz.gita.finalexam.ui.viewmodel

import androidx.lifecycle.LiveData

interface SignInViewModel {
    val btnSubmitEnablingLiveData: LiveData<Boolean>
    val messageLiveData: LiveData<String>
    val openMainScreenLiveData: LiveData<Unit>
    val openSignUpScreenLiveData: LiveData<Unit>
    val progressBarLiveData: LiveData<Boolean>

    fun onTextChanged(email:String,password:String)
    fun btnSingInClicked(email: String, password: String)
    fun btnSignUpClicked()
}