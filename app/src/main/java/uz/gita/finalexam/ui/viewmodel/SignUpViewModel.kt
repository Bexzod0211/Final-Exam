package uz.gita.finalexam.ui.viewmodel

import androidx.lifecycle.LiveData

interface SignUpViewModel {
    val btnSubmitEnablingLiveData:LiveData<Boolean>
    val messageLiveData:LiveData<String>
    val openMainScreenLiveData:LiveData<Unit>
    val openSignInScreenLiveData:LiveData<Unit>
    val progressBarLiveData:LiveData<Boolean>

    fun onTextChanged(email:String,password:String)
    fun btnSingUpClicked(email: String,password: String)
    fun btnSignInClicked()
}