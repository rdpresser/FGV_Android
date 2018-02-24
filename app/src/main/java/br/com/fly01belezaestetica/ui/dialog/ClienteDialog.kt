package br.com.fly01belezaestetica.ui.dialog

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.fly01belezaestetica.R
import br.com.fly01belezaestetica.model.ClienteModel
import br.com.fly01belezaestetica.retrofit.client.ClienteWebClient
import br.com.fly01belezaestetica.utils.Prefs
import br.com.fly01belezaestetica.utils.prefs
import kotlinx.android.synthetic.main.form_cliente.view.*
import okhttp3.ResponseBody

/**
 * Created by rodrigo.presser on 23/02/2018.
 */
class ClienteDialog(
        private val viewGroup: ViewGroup,
        private val context: Context) {

    private val createdView = createView()
    private val idField = createdView.form_id
    private val nomeField = createdView.form_nome
    private val documentoField = createdView.form_documento
    private val telefoneField = createdView.form_telefone
    private val emailField = createdView.form_email
    var prefs: Prefs? = null

    private fun createView(): View {
        return LayoutInflater.from(context)
                .inflate(R.layout.form_cliente,
                        viewGroup,
                        false)
    }

    fun alter(cliente: ClienteModel,
              preExecute: () -> Unit = {},
              finished: () -> Unit = {},
              altered: (alteredCliente: ClienteModel) -> Unit) {

        idField.setText(cliente.id)
        nomeField.setText(cliente.nome)
        documentoField.setText(cliente.documento)
        telefoneField.setText(cliente.telefone)
        emailField.setText(cliente.email)


        var dialog = AlertDialog.Builder(context)
                .setTitle("Alterar Cliente")
                .setView(createdView)
                .setNegativeButton("Cancelar") { _, _ ->
                }
                .setPositiveButton("Salvar") { _, _ ->

                    val id = idField.text.toString()
                    val nome = nomeField.text.toString()
                    val documento = documentoField.text.toString()
                    val telefone = telefoneField.text.toString()
                    var email = emailField.text.toString()

                    var validation = true
                    if (nome.isEmpty()) {
                        Toast.makeText(context, "Nome é obrigatório", Toast.LENGTH_LONG).show()
                        validation = false
                    }

                    if (telefone.isEmpty() && validation) {
                        Toast.makeText(context, "Telefone é obrigatório", Toast.LENGTH_LONG).show()
                        validation = false
                    }

                    if (email.isEmpty() && validation) {
                        Toast.makeText(context, "Email é obrigatório", Toast.LENGTH_LONG).show()
                        validation = false
                    }

                    if (validation) {
                        val alteredCliente = cliente.copy(id = id, nome = nome, documento = documento, telefone = telefone, email = email)
                        prefs = Prefs(context)

                        ClienteWebClient(prefs!!.accessToken).alter(alteredCliente,
                                success = { altered(alteredCliente) },
                                failure = {
                                    Toast.makeText(context,
                                            "Falha ao alterar Cliente, Erro: ${it.message}",
                                            Toast.LENGTH_LONG).show()
                                },
                                preExecute = preExecute,
                                finished = finished)
                    }
                }
                .show()

    }

    fun add(preExecute: () -> Unit = {},
            finished: () -> Unit = {},
            created: (createdCliente: ClienteModel) -> Unit = {}) {
        AlertDialog.Builder(context)
                .setTitle("Adicionar Cliente")
                .setView(createdView)
                .setNegativeButton("Cancelar") { _, _ ->
                }
                .setPositiveButton("Salvar") { _, _ ->
                    val nome = nomeField.text.toString()
                    val documento = documentoField.text.toString()
                    val telefone = telefoneField.text.toString()
                    var email = emailField.text.toString()

                    var validation = true
                    if (nome.isEmpty()) {
                        Toast.makeText(context, "Nome é obrigatório", Toast.LENGTH_LONG).show()
                        validation = false
                    }

                    if (telefone.isEmpty() && validation) {
                        Toast.makeText(context, "Telefone é obrigatório", Toast.LENGTH_LONG).show()
                        validation = false
                    }

                    if (email.isEmpty() && validation) {
                        Toast.makeText(context, "Email é obrigatório", Toast.LENGTH_LONG).show()
                        validation = false
                    }

                    if (validation) {
                        val createdCliente = ClienteModel(nome = nome, documento = documento, telefone = telefone, email = email)
                        preExecute()
                        prefs = Prefs(context)
                        ClienteWebClient(prefs!!.accessToken).insert(createdCliente,
                                success = {
                                    created(it)
                                },
                                failure = {
                                    Toast.makeText(context,
                                            "Falha ao incluir Cliente, Erro: ${it.message}",
                                            Toast.LENGTH_LONG).show()
                                },
                                preExecute = preExecute,
                                finished = finished)
                    }
                }
                .show()
    }
}