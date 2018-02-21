package br.com.fly01belezaestetica.model

import com.google.gson.annotations.SerializedName

/**
 * Created by rodrigo.presser on 20/02/2018.
 */

//Classe de pageResult para retorno OData
class PageResultModel<out T> (
        @SerializedName("@odata.context") val context: String,
        @SerializedName("@odata.count") val count: String,
        @SerializedName("value") val value: List<T>,
        @SerializedName("@odata.nextLink") val nextLink: String
)