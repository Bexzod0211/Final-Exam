package uz.gita.finalexam.ui.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.finalexam.ui.usecase.PagerUseCase
import uz.gita.finalexam.ui.viewmodel.PagerViewModel
import javax.inject.Inject

@HiltViewModel
class PagerViewModelImpl @Inject constructor(
    private val useCase:PagerUseCase
) :PagerViewModel, ViewModel() {

    override val openSignScreenLiveData: MutableLiveData<Unit> = MutableLiveData()

    override fun btnStartClicked() {
        useCase.savePagerState(true).onEach {
            openSignScreenLiveData.value = Unit
        }.launchIn(viewModelScope)
    }


}