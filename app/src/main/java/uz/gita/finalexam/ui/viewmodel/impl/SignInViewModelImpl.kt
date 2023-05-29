package uz.gita.finalexam.ui.viewmodel.impl

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.finalexam.ui.usecase.SignInUseCase
import uz.gita.finalexam.ui.viewmodel.SignInViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModelImpl @Inject constructor(
    private val useCase:SignInUseCase
) :SignInViewModel, ViewModel() {

    override val btnSubmitEnablingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    override val messageLiveData: MutableLiveData<String> = MutableLiveData()
    override val openMainScreenLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val openSignUpScreenLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val progressBarLiveData: MutableLiveData<Boolean> = MutableLiveData()

    override fun onTextChanged(email: String, password: String) {
        btnSubmitEnablingLiveData.value = email.contains("@")&&email.trim().length>=7&&password.length>=6
    }

    override fun btnSingInClicked(email: String, password: String) {
        progressBarLiveData.value = true
        useCase.signInWithEmailAndPassword(email, password).
        onEach {result->
            result.onSuccess {
                messageLiveData.value = it
                openMainScreenLiveData.value = Unit
            }
            result.onFailure {
                messageLiveData.value = it.message
                Log.d("TTT",it.message?:"")
            }
            progressBarLiveData.value = false
        }
            .launchIn(viewModelScope)
    }

    override fun btnSignUpClicked() {
        openSignUpScreenLiveData.value = Unit
    }

}