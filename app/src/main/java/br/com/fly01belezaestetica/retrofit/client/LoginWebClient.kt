package br.com.fly01belezaestetica.retrofit.client

import android.content.Context
import br.com.fly01belezaestetica.model.AccessTokenModel
import br.com.fly01belezaestetica.model.ClienteModel
import br.com.fly01belezaestetica.model.LoginModel
import br.com.fly01belezaestetica.model.PageResultModel
import br.com.fly01belezaestetica.retrofit.RetrofitInitializer
import br.com.fly01belezaestetica.retrofit.callback
import br.com.fly01belezaestetica.retrofit.defaultFailure
import br.com.fly01belezaestetica.retrofit.defaultResponse

/**
 * Created by rodrigo.presser on 23/02/2018.
 */
class LoginWebClient() {

    fun getAccessToken(preExecute: () -> Unit = {},
                       finished: () -> Unit = {},
                       success: (accessToken: AccessTokenModel) -> Unit = {},
                       failure: (throwable: Throwable) -> Unit = {},
                       loginModel: LoginModel ) {

        val call = RetrofitInitializer().loginService().getAccessToken(
                grantType = "password",
                username = loginModel.userName,
                password = loginModel.password,
                numeroserie = loginModel.numeroSerie)

        call.enqueue(
                callback(
                        response = { it.defaultResponse(success) },
                        failure = { it.defaultFailure(failure) },
                        preExecute = preExecute,
                        finished = finished))

    }

    fun accountLogin() {
        //TODO: fazer a chamada do login em api/account/login
    }

}