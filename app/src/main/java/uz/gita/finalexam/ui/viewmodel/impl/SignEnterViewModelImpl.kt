package uz.gita.finalexam.ui.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.finalexam.ui.viewmodel.SignEnterViewModel
import javax.inject.Inject


@HiltViewModel
class SignEnterViewModelImpl @Inject constructor() : SignEnterViewModel, ViewModel(){
    override val openSignInScreenLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val openSignUpScreenLiveData: MutableLiveData<Unit> = MutableLiveData()

    override fun btnSignUpClicked() {
        openSignUpScreenLiveData.value = Unit
    }

    override fun btnSignInClicked() {
        openSignInScreenLiveData.value = Unit
    }

}