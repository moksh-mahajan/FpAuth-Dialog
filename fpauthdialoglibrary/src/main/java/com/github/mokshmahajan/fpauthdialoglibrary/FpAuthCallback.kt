package com.github.mokshmahajan.fpauthdialoglibrary

interface FpAuthCallback {
    fun onFpAuthSuccess()
    fun onFpAuthFailed(errorMessage: String)
    fun onCancel()
}