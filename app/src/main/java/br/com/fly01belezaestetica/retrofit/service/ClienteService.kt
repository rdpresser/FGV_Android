package br.com.fly01belezaestetica.retrofit.service

import br.com.fly01belezaestetica.model.ClienteModel
import br.com.fly01belezaestetica.model.PageResultModel
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by rodrigo.presser on 20/02/2018.
 */
interface ClienteService {
    @GET("api/cliente?\$select=id,nome,documento,email&\$count=true&\$filter=documento ne null and email ne null")
    fun list(): Call<PageResultModel<ClienteModel>>

    @POST("api/cliente")
    fun insert(@Body cliente: ClienteModel): Call<ClienteModel>

    @PUT("api/cliente({id})")
    fun alter(@Body cliente: ClienteModel, @Path("id") id: String): Call<ClienteModel>
}