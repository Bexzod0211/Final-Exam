package uz.gita.finalexam.ui.usecase

import kotlinx.coroutines.flow.Flow

interface PagerUseCase {
    fun savePagerState(state:Boolean):Flow<Unit>
}