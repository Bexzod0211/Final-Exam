package uz.gita.finalexam.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.finalexam.data.model.SpecialityData
import uz.gita.finalexam.data.model.TopDoctorsData

interface AppRepository {
    fun savePagerState(state:Boolean)
    fun getPagerState():Boolean
    fun getSpecialitiesData():List<SpecialityData>
    fun getTopDoctorsData():List<TopDoctorsData>
    fun signUpWithEmailAndPassword(email:String,password:String):Flow<Result<String>>
    fun signIntWithEmailAndPassword(email: String,password: String):Flow<Result<String>>
    fun isSignedIn():Boolean

}