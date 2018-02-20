package br.com.fly01belezaestetica.retrofit

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by rodrigo.presser on 20/02/2018.
 */

fun <T> callback(preExecute: () -> Unit = {},
                 finished: () -> Unit = {},
                 response: (response: Response<T>?) -> Unit = {},
                 failure: (throwable: Throwable?) -> Unit = {}): Callback<T> {
    preExecute()
    return object : Callback<T> {
        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            response(response)
            finished()
        }

        override fun onFailure(call: Call<T>?, t: Throwable?) {
            failure(t)
            finished()
        }
    }
}

fun <T> Response<T>?.defaultResponse(success: (t: T) -> Unit) {
    this?.body()?.let { success(it) }
}

fun Throwable?.defaultFailure(failure: (throwable: Throwable) -> Unit) {
    this?.let {
        failure(it)
    }
}