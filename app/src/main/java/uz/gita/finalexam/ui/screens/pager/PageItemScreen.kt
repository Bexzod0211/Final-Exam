package uz.gita.finalexam.ui.screens.pager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.finalexam.R
import uz.gita.finalexam.databinding.ItemPageBinding

class PageItemScreen : Fragment(R.layout.item_page) {
    private val binding by viewBinding(ItemPageBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val image = arguments?.getInt("image")!!
        val text = arguments?.getString("text")

        binding.image.setImageResource(image)
        binding.text.text = text
    }
}