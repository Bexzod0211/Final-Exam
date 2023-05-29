package uz.gita.finalexam.ui.screens.entersign

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.finalexam.R
import uz.gita.finalexam.databinding.SignInEnterBinding
import uz.gita.finalexam.ui.viewmodel.SignEnterViewModel
import uz.gita.finalexam.ui.viewmodel.impl.SignEnterViewModelImpl

@AndroidEntryPoint
class EnterSignScreen : Fragment(R.layout.sign_in_enter) {
    private val binding by viewBinding(SignInEnterBinding::bind)
    private val viewModel:SignEnterViewModel by viewModels<SignEnterViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openSignInScreenLiveData.observe(this,openSignInScreenObserver)
        viewModel.openSignUpScreenLiveData.observe(this,openSignUpScreenObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.apply {
            btnSignUp.setOnClickListener {
                viewModel.btnSignUpClicked()
            }

            btnSignIn.setOnClickListener {
                viewModel.btnSignInClicked()
            }
        }

    }

    private val openSignInScreenObserver = Observer<Unit>{
        findNavController().navigate(R.id.action_enterSignScreen_to_signInScreen)
    }

    private val openSignUpScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_enterSignScreen_to_signUpScreen)
    }
}