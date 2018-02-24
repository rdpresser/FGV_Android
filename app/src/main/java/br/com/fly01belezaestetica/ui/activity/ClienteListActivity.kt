package br.com.fly01belezaestetica.ui.activity

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import br.com.fly01belezaestetica.R
import br.com.fly01belezaestetica.R.id.progressBar
import br.com.fly01belezaestetica.model.ClienteModel
import br.com.fly01belezaestetica.retrofit.client.ClienteWebClient
import br.com.fly01belezaestetica.ui.adapter.ClienteListAdapter
import br.com.fly01belezaestetica.ui.dialog.ClienteDialog
import br.com.fly01belezaestetica.utils.Prefs
import kotlinx.android.synthetic.main.activity_cliente_list.*
import org.jetbrains.anko.*
import org.jetbrains.anko.design.floatingActionButton
import org.jetbrains.anko.recyclerview.v7.recyclerView

class ClienteListActivity : AppCompatActivity() {

    private val data: MutableList<ClienteModel> = mutableListOf()
    private var prefs: Prefs? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente_list)

        prefs = Prefs(this.baseContext)

        ClienteWebClient(prefs!!.accessToken).list(
                preExecute = {
                    list_progress.visibility = ProgressBar.VISIBLE
                },
                success = {
                    data.addAll(it.value)
                    configureList()
                },
                failure = {
                    longToast("Falha ao buscar os clientes: ${it.message}")
                },
                finished = {
                    list_progress.visibility = ProgressBar.GONE
                })

        fab_add.setOnClickListener {
            ClienteDialog(window.decorView as ViewGroup, this)
                    .add(
                            preExecute = {
                                list_progress.visibility = ProgressBar.VISIBLE
                            },
                            created = {
                                data.add(it)
                                configureList()
                            },
                            finished = {
                                list_progress.visibility = ProgressBar.GONE
                            })
        }
    }

    private fun configureList() {
        list_recyclerview.adapter = ClienteListAdapter(data,
                { cliente, position ->
                    ClienteDialog(window.decorView as ViewGroup, this).alter(cliente,
                            preExecute = {
                                list_progress.visibility = ProgressBar.VISIBLE
                            },
                            finished = {
                                list_progress.visibility = ProgressBar.GONE
                            }
                    ) {
                        data[position] = it
                        configureList()
                    }
                    longToast("Posição clicada $cliente")
                })
        list_recyclerview.layoutManager = LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false)
    }
}