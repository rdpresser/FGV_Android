package br.com.fly01belezaestetica.retrofit

import android.content.Context
import android.content.SharedPreferences
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.text.TextUtils
import br.com.fly01belezaestetica.retrofit.service.ClienteService
import br.com.fly01belezaestetica.utils.PreferenceHelper
import okhttp3.OkHttpClient



/**
 * Created by rodrigo.presser on 20/02/2018.
 */
class RetrofitInitializer {

    private val API_BASE_URL = "http://fly01belezaesteticaapihomolog.azurewebsites.net/"

    private val httpClient = OkHttpClient.Builder()

    private val builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

    private var retrofit = builder.build()

    fun <S> createService(serviceClass: Class<S>): S {
        return createService(serviceClass, null)
    }

    fun <S> createService(serviceClass: Class<S>, authToken: String?): S {
        if (!TextUtils.isEmpty(authToken)) {
            val interceptor = AuthenticationInterceptor(authToken!!)

            if (!httpClient.interceptors().contains(interceptor)) {
                httpClient.addInterceptor(interceptor)

                builder.client(httpClient.build())
                retrofit = builder.build()
            }
        }

        return retrofit.create(serviceClass)
    }

    fun clienteService(authToken: String) = createService(ClienteService::class.java, authToken)
}