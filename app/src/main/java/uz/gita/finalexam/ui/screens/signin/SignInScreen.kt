package uz.gita.finalexam.ui.screens.signin

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.finalexam.R
import uz.gita.finalexam.databinding.SignInScreenBinding
import uz.gita.finalexam.ui.viewmodel.SignInViewModel
import uz.gita.finalexam.ui.viewmodel.impl.SignInViewModelImpl

@AndroidEntryPoint
class SignInScreen : Fragment(R.layout.sign_in_screen) {
    private val binding by viewBinding(SignInScreenBinding::bind)
    private val viewModel:SignInViewModel by viewModels<SignInViewModelImpl>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openMainScreenLiveData.observe(this,openMainScreenObserver)
        viewModel.openSignUpScreenLiveData.observe(this,openSignUpScreenObserver)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.messageLiveData.observe(viewLifecycleOwner,messageObserver)
        viewModel.btnSubmitEnablingLiveData.observe(viewLifecycleOwner,btnSubmitEnablingObserver)
        viewModel.progressBarLiveData.observe(viewLifecycleOwner,progressBarObserver)

        binding.inputEmail.doAfterTextChanged {
            viewModel.onTextChanged(it.toString(),binding.inputPassword.text.toString())
        }

        binding.inputPassword.doAfterTextChanged {
            viewModel.onTextChanged(binding.inputEmail.text.toString(),it.toString())
        }
        attachClickListeners()
    }

    private fun attachClickListeners(){
        binding.apply {
            btnSignIn.setOnClickListener {
                viewModel.btnSingInClicked(inputEmail.text.toString(),inputPassword.text.toString())
            }
            btnSignUp.setOnClickListener {
                viewModel.btnSignUpClicked()
            }
        }
    }

    private val progressBarObserver = Observer<Boolean> {
        if (it){
            binding.loadingProgressBar.show()
        }
        else binding.loadingProgressBar.hide()
    }

    private val openSignUpScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_signInScreen_to_signUpScreen)
    }

    private val openMainScreenObserver = Observer<Unit>{
        findNavController().navigate(R.id.action_signInScreen_to_mainScreen)
    }

    private val messageObserver = Observer<String> {
        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
    }

    private val btnSubmitEnablingObserver = Observer<Boolean> {
        binding.btnSignIn.isEnabled = it
    }
}