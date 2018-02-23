package br.com.fly01belezaestetica.model

/**
 * Created by rodrigo.presser on 23/02/2018.
 */
data class LoginModel (
        val userName: String,
        val password: String,
        val numeroSerie: String = "7982306941") {

    //TODO: numeroSerie por enquanto está sendo enviado como default, pois no processo de login é feito em duas etapas
    //Etapa 1: POST -> é feito requisição na api/account/userlogin enviando usuario e senha, se OK, é retornado os Tenant's (empresas) que o usuário pode acessar
    //Etapa 2: POST -> é feito nova requisição de api/token para gerar o token para a api trafegar no header
}