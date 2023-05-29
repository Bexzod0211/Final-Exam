package uz.gita.finalexam.utils

import androidx.fragment.app.Fragment
import uz.gita.finalexam.R

fun Fragment.addScreen(fm:Fragment){
    parentFragmentManager.beginTransaction()
        .add(R.id.container_main,fm)
        .commit()
}

fun Fragment.replaceScreen(fm:Fragment){
    parentFragmentManager.beginTransaction()
        .replace(R.id.container_main,fm)
        .commit()
}