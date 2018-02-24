package br.com.fly01belezaestetica.model

/**
 * Created by rodrigo.presser on 20/02/2018.
 */
data class ClienteModel (
        val id: String? = null,
        val nome: String,
        val documento: String?,
        val email: String,
        val telefone: String)