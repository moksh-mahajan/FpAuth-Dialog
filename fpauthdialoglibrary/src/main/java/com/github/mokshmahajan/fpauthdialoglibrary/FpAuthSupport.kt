package com.github.mokshmahajan.fpauthdialoglibrary

import android.content.Context
import android.os.Build
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat

object FpAuthSupport {

    @JvmStatic
    fun checkAvailability(context: Context): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                FingerprintManagerCompat.from(context).isHardwareDetected
    }

    @JvmStatic
    fun isFingerprintRegistered(context: Context): Boolean {
        return FingerprintManagerCompat.from(context).hasEnrolledFingerprints()
    }

    @JvmStatic
    fun checkAvailabiltyAndIfFingerprintRegistered(context: Context): Boolean {
        val fingerprintManagerCompat = FingerprintManagerCompat.from(context)
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                fingerprintManagerCompat.isHardwareDetected &&
                fingerprintManagerCompat.hasEnrolledFingerprints()
    }
}