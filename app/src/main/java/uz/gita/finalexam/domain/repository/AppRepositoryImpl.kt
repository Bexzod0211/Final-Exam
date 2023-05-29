package uz.gita.finalexam.domain.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import uz.gita.finalexam.R
import uz.gita.finalexam.data.model.SpecialityData
import uz.gita.finalexam.data.model.TopDoctorsData
import uz.gita.finalexam.data.source.local.MySharedPref
import java.lang.Exception
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val sharedPref: MySharedPref,
    private val auth: FirebaseAuth = Firebase.auth
) : AppRepository {

    override fun savePagerState(state: Boolean) {
        sharedPref.pagerState = state
    }

    override fun getPagerState(): Boolean {
        return sharedPref.pagerState
    }

    override fun getSpecialitiesData(): List<SpecialityData> {
        return listOf(
            SpecialityData(1, R.drawable.img_general, "General"),
            SpecialityData(2, R.drawable.img_dentist, "Dentist"),
            SpecialityData(3, R.drawable.img_opthal, "Opthal"),
            SpecialityData(4, R.drawable.img_nutrition, "Nutrition"),
            SpecialityData(5, R.drawable.img_neurolog, "Neurolog"),
            SpecialityData(6, R.drawable.img_pediatric, "Pediatric"),
            SpecialityData(7, R.drawable.img_radiolog, "Radiolog"),
            SpecialityData(8, R.drawable.img_more, "More")
        )
    }

    override fun getTopDoctorsData(): List<TopDoctorsData> {
        return listOf(
            TopDoctorsData(1,"All"),
            TopDoctorsData(2,"General"),
            TopDoctorsData(3,"Dentist"),
            TopDoctorsData(4,"Nutritionist"),
            TopDoctorsData(5,"Pediatric"),
            TopDoctorsData(6,"Radiolog"),
        )
    }

    override fun signUpWithEmailAndPassword(email: String, password: String): Flow<Result<String>> = callbackFlow {
        auth.createUserWithEmailAndPassword(email, password).
                addOnSuccessListener {
                    trySend(Result.success("Successfully registered"))
                }
            .addOnFailureListener {
                trySend(Result.failure(it))
            }
        awaitClose()
    }

    override fun signIntWithEmailAndPassword(email: String, password: String): Flow<Result<String>>  = callbackFlow{
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                trySend(Result.success("Successfully signed in"))
            }
            .addOnFailureListener {
                trySend(Result.failure(it))
            }
        awaitClose()
    }

    override fun isSignedIn(): Boolean {
        return auth.currentUser != null
    }

}