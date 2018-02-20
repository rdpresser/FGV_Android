package br.com.fly01belezaestetica.retrofit

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * Created by rodrigo.presser on 20/02/2018.
 * https://futurestud.io/tutorials/retrofit-add-custom-request-header
 */
class AuthenticationInterceptor(private val authToken: String) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val builder = original.newBuilder()
                .header("Authorization", authToken)
                .header("Content-Type", "application/json")

        val request = builder.build()
        return chain.proceed(request)
    }
}