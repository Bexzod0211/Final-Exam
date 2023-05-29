package uz.gita.finalexam.ui.screens.signup

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
import uz.gita.finalexam.databinding.SignUpScreenBinding
import uz.gita.finalexam.ui.viewmodel.SignUpViewModel
import uz.gita.finalexam.ui.viewmodel.impl.SignUpViewModelImpl

@AndroidEntryPoint
class SignUpScreen : Fragment(R.layout.sign_up_screen) {
    private val binding by viewBinding(SignUpScreenBinding::bind)
    private val viewModel:SignUpViewModel by viewModels<SignUpViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openMainScreenLiveData.observe(this,openMainScreenObserver)
        viewModel.openSignInScreenLiveData.observe(this,openSignInScreenObserver)
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
            btnSignUp.setOnClickListener {
                viewModel.btnSingUpClicked(inputEmail.text.toString(),inputPassword.text.toString())
            }
            btnSignIn.setOnClickListener {
                viewModel.btnSignInClicked()
            }
        }
    }


    private val progressBarObserver = Observer<Boolean> {
        if (it){
            binding.loadingProgressBar.show()
        }
        else binding.loadingProgressBar.hide()
    }

    private val openSignInScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_signUpScreen_to_signInScreen)
    }

    private val openMainScreenObserver = Observer<Unit>{
        findNavController().navigate(R.id.action_signUpScreen_to_mainScreen)
    }

    private val messageObserver = Observer<String> {
        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
    }

    private val btnSubmitEnablingObserver = Observer<Boolean> {
        binding.btnSignUp.isEnabled = it
    }
}