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
        val authToken = "Bearer eJ6dE86MVbOIhZsgiWzf7Uf_sba2paISDMgpWtMwk_JtiPrvYfkwkCVi6Wmp86rKWRnIHVegoLjlaCfEr68l517iaoTdsnhFVSMbiRPbTyBnYPZtQImtztCtfGxkj0DVHmoB2NnhLMBEqtFW14O2FEwzGWx62lD_i-_dDavevb0xgE_jivPksAIMQz9gyHzicOQeaUwp3L1wV8Qz7kzlD9Bvdx7L-Lz6ZDlcL0bl3N2v6YB93_AmzK_HLj05lF-bYtYic4qfC3Xcy5901BJsf8sqo6-A9C-NDO-5t-RxSuLCfzCk-SWM4etRVcWpvR_7u3UIdICIfhhQoZ2yzWiqOna-BZGa471L8tsz8_3Cbx6x37_i9Hcd0JyynWHD3ITvxa4kWtMbtFr5j9PBNWKzQpYO1lRxYFxQBPo-0nkcR6c"
        val call = RetrofitInitializer().clienteService(authToken).list()
        call.enqueue(
                callback(
                        response = { it.defaultResponse(success) },
                        failure = { it.defaultFailure(failure) },
                        preExecute = preExecute,
                        finished = finished))
    }
}