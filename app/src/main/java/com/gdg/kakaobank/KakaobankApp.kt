package com.gdg.kakaobank

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KakaobankApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }

}