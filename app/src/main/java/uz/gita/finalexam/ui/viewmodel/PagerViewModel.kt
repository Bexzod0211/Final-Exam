package uz.gita.finalexam.ui.viewmodel

import androidx.lifecycle.LiveData

interface PagerViewModel {
    fun btnStartClicked()
    val openSignScreenLiveData:LiveData<Unit>
}