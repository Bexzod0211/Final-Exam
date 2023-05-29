package uz.gita.finalexam.di

import android.content.Context
import android.content.SharedPreferences
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideSharedPref(@ApplicationContext context:Context):SharedPreferences = context.getSharedPreferences("Doctors",Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideFirebaseAuth():FirebaseAuth = Firebase.auth

}