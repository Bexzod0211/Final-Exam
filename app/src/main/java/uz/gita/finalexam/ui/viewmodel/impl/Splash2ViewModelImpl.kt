package uz.gita.finalexam.ui.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.finalexam.ui.usecase.Splash2UseCase
import uz.gita.finalexam.ui.viewmodel.Splash2ViewModel
import javax.inject.Inject

@HiltViewModel
class Splash2ViewModelImpl @Inject constructor(
    private val useCase: Splash2UseCase
) : ViewModel(), Splash2ViewModel {

    override val openPagerScreenLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val openSignInScreenLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val openMainScreenLiveData: MutableLiveData<Unit> = MutableLiveData()

    init {
        useCase.isSignedIn().onEach {
            if (it){
                openMainScreenLiveData.value = Unit
            }else {
                getPagerState()
            }
        }
            .launchIn(viewModelScope)
    }

    override fun getPagerState() {
        useCase.getPagerState().onEach {
            if (it){
                openSignInScreenLiveData.value = Unit
            }
            else {
                openPagerScreenLiveData.value = Unit
            }
        }.launchIn(viewModelScope)
    }


}