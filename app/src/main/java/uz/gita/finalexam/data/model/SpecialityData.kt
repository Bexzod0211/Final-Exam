package uz.gita.finalexam.data.model

import androidx.annotation.DrawableRes

data class SpecialityData(
    val id:Int,
    @DrawableRes
    val imgResId:Int,
    val name:String
)
