package br.com.fly01belezaestetica.model

/**
 * Created by rodrigo.presser on 20/02/2018.
 */
data class AccessTokenModel (
        val access_token: String,
        var token_type: String,
        val userName: String) {

    fun getAccessToken(): String  = access_token

    fun getTokenType(): String {
        // OAuth requires uppercase Authorization HTTP header value for token type
        if (!Character.isUpperCase(token_type[0])) {
            token_type = Character
                    .toString(token_type[0])
                    .toUpperCase() + token_type.substring(1)
        }

        return token_type
    }
}