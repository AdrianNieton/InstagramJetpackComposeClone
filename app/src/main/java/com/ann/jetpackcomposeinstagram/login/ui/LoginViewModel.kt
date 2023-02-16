package com.ann.jetpackcomposeinstagram.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> get() = _email

    private val _isPasswordVisible = MutableLiveData<Boolean>()
    val isPasswordVisible: LiveData<Boolean> get() = _isPasswordVisible

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> get() = _password
    
    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> get() = _isLoginEnable


    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email, password)
    }

    fun onPasswordVisibilityChanged(passwordVisibility: Boolean) {
        _isPasswordVisible.value = !passwordVisibility
    }

    private fun enableLogin(email: String, password: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6
}