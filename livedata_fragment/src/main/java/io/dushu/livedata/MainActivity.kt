package io.dushu.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickMap(view: android.view.View) {}
    fun clickEvent(view: android.view.View) {}
    fun clickLiveDataTransformations(view: android.view.View) {}
    fun clickMediatorLiveData(view: android.view.View) {}
}
