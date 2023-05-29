package uz.gita.finalexam.data.source.local

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MySharedPref @Inject constructor(
    private val pref:SharedPreferences
) {
    private val PAGER_STATE = "PAGER_STATE"

    var pagerState:Boolean
        get() = pref.getBoolean(PAGER_STATE,false)
        set(value) = pref.edit().putBoolean(PAGER_STATE,value).apply()

}