package io.plesskih.rotator

import android.app.Activity
import android.app.Application
import android.content.res.Configuration
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.Surface

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Settings.System.putInt(
            contentResolver,
            Settings.System.ACCELEROMETER_ROTATION,
            0
        )
        val r = resources.configuration.orientation
        Log.d("###", r.toString())
        Settings.System.putInt(
            contentResolver,
            Settings.System.USER_ROTATION,
            if (r == Configuration.ORIENTATION_PORTRAIT) Surface.ROTATION_90 else Surface.ROTATION_0
        )
        finishAndRemoveTask()
    }
}

class App : Application() {
    override fun onCreate() {
        super.onCreate()
//        Settings.System.putInt(
//            contentResolver,
//            Settings.System.ACCELEROMETER_ROTATION,
//            0
//        )
//        val r = resources.configuration.orientation
//        Log.d("###", r.toString())
//        Settings.System.putInt(
//            contentResolver,
//            Settings.System.USER_ROTATION,
//            if (r == Configuration.ORIENTATION_PORTRAIT) Surface.ROTATION_90 else Surface.ROTATION_0
//        )
//        android.os.Process.killProcess(android.os.Process.myPid())
    }
}