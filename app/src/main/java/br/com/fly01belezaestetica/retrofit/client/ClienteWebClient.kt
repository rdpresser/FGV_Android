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
        val authToken = "Bearer okqPYohcYdsEZR6oPgrRcNZw_svCn02v33kyTA3VGGKQvTRdTSMTi4dPQpdeYS2h3cIxb-kZT9KImtvRY0YIaXuCjnYDt1ap00PcsEAkGln6ECn4LBEwivyb7IuOGvS1u2nLG9WPCRqFUnddLXA1lp-i5Aqeq0Uq9m0D0LhczKmfPOOwex-rBG8LHKBfbiAHzv8lIPStawnMQMXdmCsZoA0ToE5oFM-jPvyi24FckfXojHeNABg5w3fgMkw5phRzvE_307GnWRSRiFVVZZBDqbsrYQnZsA-u04UQK8kNk-Z9Zf44TDQlpZBZbaPbPhhoFIkLz-fqWU-PdBwtuD-kK3FX5hEMXik96iDszJbBljS4864U1i4RgQFJ6p7x5l26IZ3DkT2HPWYFGuJKsGgbUYUW_nYfXnqz0LvbWfC6_II"
        val call = RetrofitInitializer().clienteService(authToken).list()
        call.enqueue(
                callback(
                        response = { it.defaultResponse(success) },
                        failure = { it.defaultFailure(failure) },
                        preExecute = preExecute,
                        finished = finished))
    }
}