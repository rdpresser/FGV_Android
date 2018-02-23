package br.com.fly01belezaestetica.model

import com.google.gson.annotations.SerializedName

/**
 * Created by rodrigo.presser on 20/02/2018.
 */
data class AccessTokenModel (
        @SerializedName("access_token") val accessToken: String,
        @SerializedName("token_type") var tokenType: String,
        @SerializedName("userName") val userName: String
) {

    /*init {
        if (!Character.isUpperCase(tokenType[0])) {
            tokenType = Character
                    .toString(tokenType[0])
                    .toUpperCase() + tokenType.substring(1)
        }
    }*/
}