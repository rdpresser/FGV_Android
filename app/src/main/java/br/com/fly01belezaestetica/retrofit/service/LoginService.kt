package br.com.fly01belezaestetica.retrofit.service

import br.com.fly01belezaestetica.model.AccessTokenModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.FormUrlEncoded

/**
 * Created by rodrigo.presser on 20/02/2018.
 */
interface LoginService {
    @POST("/token")
    @FormUrlEncoded
    fun getAccessToken(
            @Field("grant_type") grantType: String,
            @Field("username") username: String,
            @Field("password") password: String,
            @Field("numeroserie") numeroserie: String): Call<AccessTokenModel>
}