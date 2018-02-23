package br.com.fly01belezaestetica.utils

import android.app.Application

/**
 * Created by rodri on 22/02/2018.
 */
val prefs: Prefs by lazy {
    App.prefs!!
}

class App : Application() {
    companion object {
        var prefs: Prefs? = null
    }

    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()
    }
}
