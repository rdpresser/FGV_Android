package br.com.fly01belezaestetica.retrofit.client

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import br.com.fly01belezaestetica.model.ClienteModel
import br.com.fly01belezaestetica.model.PageResultModel
import br.com.fly01belezaestetica.retrofit.*
import br.com.fly01belezaestetica.utils.PreferenceHelper

/**
 * Created by rodrigo.presser on 20/02/2018.
 * https://futurestud.io/tutorials/android-basic-authentication-with-retrofit
 * https://futurestud.io/tutorials/retrofit-add-custom-request-header
 * https://futurestud.io/tutorials/oauth-2-on-android-with-retrofit
 * https://futurestud.io/tutorials/android-basic-authentication-with-retrofit
 */
class ClienteWebClient(private val context: Context) {
    fun list(preExecute: () -> Unit = {},
             finished: () -> Unit = {},
             success: (cliente: PageResultModel<ClienteModel>) -> Unit = {},
             failure: (throwable: Throwable) -> Unit = {}) {

        //val authToken = PreferenceHelper.customPrefs(context, "auth_token").toString()
        val authToken = "Bearer IIUZ3FJ1cqFekoUVAvmxgM21cjyp8hRUb8ZHNT6gWX-SP_uwttbq4_7s0fKES-3GrrNBFX5G3JDkeI_KAcCcMvT9THifhL8W0md7ZtXYrq3r5IXEaWxodFQELn9DQkJCSagt-lhel7bSZMoXwPkzH8kAworPpIP0EB1FEPW7hYkAGMwDx9_aN_J_94YfoGWmbwxGoVz4XuRXQ4m1MKCzTRC-u6yxOUi3z2JKEox9GLOBXr65QiKPK3K-5n2goVlcVkIlPVEfKf3rhCLd-Gf3lQkEQhIe-C1obtJ4jfihtzCx_-kdfj_MneUZAIwKo2WGtBGsqlUoxJpSNWE3K5NFo-Q01JUWuTGxBpbskbvmMX3CiHxyUQuUyNIemp9fVb-VBsPStSsNRGF3NsxyXXXFZ3oAvXR45ikxj3DYeCAi4oE"
        val call = RetrofitInitializer().clienteService(authToken).list()
        call.enqueue(
                callback(
                        response = { it.defaultResponse(success) },
                        failure = { it.defaultFailure(failure) },
                        preExecute = preExecute,
                        finished = finished))
    }
}