package br.com.fly01belezaestetica.utils

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color

/**
 * Created by rodri on 22/02/2018.
 */
class Prefs(context: Context) {
    private val PREFS_FILENAME = "br.com.fly01belezaestetica.ui.prefs"
    private val USER_NAME = "user_name"
    private val USER_PWD = "user_pwd"
    private var prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)

    var userName: String
        get() = prefs.getString(USER_NAME, "")
        set(value) = prefs.edit().putString(USER_NAME, value).apply()

    var userPassword: String
        get() = prefs.getString(USER_PWD, "")
        set(value) = prefs.edit().putString(USER_PWD, value).apply()
}