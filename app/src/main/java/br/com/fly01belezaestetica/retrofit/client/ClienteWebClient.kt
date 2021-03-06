package br.com.fly01belezaestetica.retrofit.client

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import br.com.fly01belezaestetica.model.ClienteModel
import br.com.fly01belezaestetica.model.PageResultModel
import br.com.fly01belezaestetica.retrofit.*
import br.com.fly01belezaestetica.utils.PreferenceHelper
import okhttp3.ResponseBody

/**
 * Created by rodrigo.presser on 20/02/2018.
 * https://futurestud.io/tutorials/android-basic-authentication-with-retrofit
 * https://futurestud.io/tutorials/retrofit-add-custom-request-header
 * https://futurestud.io/tutorials/oauth-2-on-android-with-retrofit
 * https://futurestud.io/tutorials/android-basic-authentication-with-retrofit
 */

//TODO: Implementar chamadas, recebendo dados para a pagina atual, $top=PageSize&$skip=CurrentPage(Range de registros para ignorar)
class ClienteWebClient(private val authToken: String) {

    fun list(preExecute: () -> Unit = {},
             finished: () -> Unit = {},
             success: (cliente: PageResultModel<ClienteModel>) -> Unit = {},
             failure: (throwable: Throwable) -> Unit = {}) {

        val call = RetrofitInitializer().clienteService(authToken).list()
        call.enqueue(
                callback(
                        response = { it.defaultResponse(success) },
                        failure = { it.defaultFailure(failure) },
                        preExecute = preExecute,
                        finished = finished))
    }

    fun alter(cliente: ClienteModel,
             preExecute: () -> Unit = {},
             finished: () -> Unit = {},
             success: (cliente: ResponseBody) -> Unit = {},
             failure: (throwable: Throwable) -> Unit = {}) {

        val call = RetrofitInitializer().clienteService(authToken).alter(cliente, cliente.id!!)
        call.enqueue(
                callback(
                        response = { it.defaultResponse(success) },
                        failure = { it.defaultFailure(failure) },
                        preExecute = preExecute,
                        finished = finished))
    }

    fun insert(cliente: ClienteModel,
               preExecute: () -> Unit = {},
               finished: () -> Unit = {},
               success: (cliente: ClienteModel) -> Unit = {},
               failure: (throwable: Throwable) -> Unit = {}) {

        val call = RetrofitInitializer().clienteService(authToken).insert(cliente)
        call.enqueue(
                callback(
                        response = { it.defaultResponse(success) },
                        failure = { it.defaultFailure(failure) },
                        preExecute = preExecute,
                        finished = finished))
    }
}