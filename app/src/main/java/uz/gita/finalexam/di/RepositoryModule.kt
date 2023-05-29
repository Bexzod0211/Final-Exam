package uz.gita.finalexam.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.finalexam.domain.repository.AppRepository
import uz.gita.finalexam.domain.repository.AppRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindAppRepository(impl:AppRepositoryImpl):AppRepository
}