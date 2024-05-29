package com.fransbudikashira.chefies.ui.signIn

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.fransbudikashira.chefies.R
import com.fransbudikashira.chefies.databinding.ActivitySignInBinding
import com.fransbudikashira.chefies.ui.main.MainActivity
import com.fransbudikashira.chefies.ui.signUp.SignUpActivity
import com.fransbudikashira.chefies.ui.signUp.SignUpViewModel
import com.fransbudikashira.chefies.util.isValidEmail

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    private lateinit var email: String
    private lateinit var password: String
    private var checkEmail:Boolean = false
    private var checkPassword:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val viewModel = SignInViewModel()

        // Set the status bar and navigation bar colors
        window.statusBarColor = getColor(R.color.primary)
        window.navigationBarColor = getColor(R.color.white)

        with(binding) {
            moveToSignIn.setOnClickListener{
                val intent = Intent(this@SignInActivity, SignUpActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                startActivity(intent)
            }
            button.setOnClickListener{
                val intent = Intent(this@SignInActivity, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                startActivity(intent)
            }
        }
        // Handle Enabled Button
        viewModel.isEnableButton.observe(this) {
            it.getContentIfNotHandled()?.let { isEnabled ->
                binding.button.isEnabled = isEnabled
            }
        }

        setupEditText(viewModel)
    }

    private fun enableEdgeToEdge() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).apply {
            isAppearanceLightStatusBars = false  // Change to false if you want light content (white icons) on the status bar
            isAppearanceLightNavigationBars = false  // Change to false if you want light content (white icons) on the navigation bar
        }
    }

    private fun setupEditText(viewModel: SignInViewModel) {
        // Email
        binding.edtEmail.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!isValidEmail(s.toString())) {
                    binding.edtEmailLayout.error = getString(R.string.invalid_email)

                    checkEmail = false
                    isEnabledButton(viewModel)
                } else {
                    binding.edtEmailLayout.error = null
                    binding.edtEmailLayout.isErrorEnabled = false

                    email = s.toString()
                    checkEmail = true
                    isEnabledButton(viewModel)
                }
            }
            override fun afterTextChanged(s: Editable?) {}
        })
        // Password
        binding.edtPassword.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().length < 8) {
                    binding.edtPasswordLayout.error = getString(R.string.invalid_password)

                    checkPassword = false
                    isEnabledButton(viewModel)
                } else {
                    binding.edtPasswordLayout.error = null
                    binding.edtPasswordLayout.isErrorEnabled = false

                    password = s.toString()
                    checkPassword = true
                    isEnabledButton(viewModel)
                }
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun isEnabledButton(viewModel: SignInViewModel) {
        if (checkEmail && checkPassword)
            viewModel.setEnabledButton(true)
        else
            viewModel.setEnabledButton(false)
    }
}