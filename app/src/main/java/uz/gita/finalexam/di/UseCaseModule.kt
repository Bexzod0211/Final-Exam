package uz.gita.finalexam.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.finalexam.ui.usecase.HomeUseCase
import uz.gita.finalexam.ui.usecase.PagerUseCase
import uz.gita.finalexam.ui.usecase.SignInUseCase
import uz.gita.finalexam.ui.usecase.SignUpUseCase
import uz.gita.finalexam.ui.usecase.Splash2UseCase
import uz.gita.finalexam.ui.usecase.impl.HomeUseCaseImpl
import uz.gita.finalexam.ui.usecase.impl.PagerUseCaseImpl
import uz.gita.finalexam.ui.usecase.impl.SignInUseCaseImpl
import uz.gita.finalexam.ui.usecase.impl.SignUpUseCaseImpl
import uz.gita.finalexam.ui.usecase.impl.Splash2UseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindSplash2UseCase(impl:Splash2UseCaseImpl):Splash2UseCase

    @Binds
    fun bindPagerUseCase(impl:PagerUseCaseImpl):PagerUseCase

    @Binds
    fun bindHomeUseCase(impl:HomeUseCaseImpl):HomeUseCase

    @Binds
    fun bindSigUpUseCase(impl:SignUpUseCaseImpl):SignUpUseCase

    @Binds
    fun bindSignInUseCase(impl:SignInUseCaseImpl):SignInUseCase
}