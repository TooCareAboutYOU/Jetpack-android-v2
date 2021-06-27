package io.dushu.lifcycle.lifecycleservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.lifecycle.LifecycleService

class MyLocationService : LifecycleService() {

    init {
        Log.i("print_log", "MyLocationService")
        val observer = MyLocationObserver(this)
        lifecycle.addObserver(observer)
    }

}
