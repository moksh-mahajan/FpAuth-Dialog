package com.github.mokshmahajan.fpauthdialog

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.github.mokshmahajan.fpauthdialoglibrary.FpAuthCallback
import com.github.mokshmahajan.fpauthdialoglibrary.FpAuthDialog

class MainActivity : AppCompatActivity() {
    private lateinit var fpAuthDialog: FpAuthDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        fpAuthDialog = FpAuthDialog(this)
            .setTitle("Login to Mifos X Android Client")
            .setMessage("Touch the Fingerprint Sensor to proceed")
            .setCancelText("Login using password")
            .setCallback(
                object: FpAuthCallback {
                    override fun onFpAuthSuccess() {
                        Toast.makeText(this@MainActivity, "Auth Success", Toast.LENGTH_SHORT).show()
                    }

                    override fun onFpAuthFailed(errorMessage: String) {
                        Toast.makeText(this@MainActivity, "Auth Failed", Toast.LENGTH_SHORT).show()
                    }

                    override fun onCancel() {
                        Toast.makeText(this@MainActivity, "Auth Cancelled", Toast.LENGTH_SHORT).show()
                    }

                }
            )
        fpAuthDialog.show()
    }

    override fun onPause() {
        super.onPause()
        fpAuthDialog.dismiss()
    }
}
