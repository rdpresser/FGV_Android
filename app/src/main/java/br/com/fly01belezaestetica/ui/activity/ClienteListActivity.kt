package br.com.fly01belezaestetica.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.ProgressBar
import br.com.fly01belezaestetica.R
import br.com.fly01belezaestetica.model.ClienteModel
import br.com.fly01belezaestetica.retrofit.client.ClienteWebClient
import br.com.fly01belezaestetica.ui.adapter.ClienteListAdapter
import br.com.fly01belezaestetica.utils.Prefs
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class ClienteListActivity : AppCompatActivity() {

    private val data: MutableList<ClienteModel> = mutableListOf()
    var prefs: Prefs? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        prefs = Prefs(this.baseContext)

        ClienteWebClient(prefs!!.accessToken).list(
                preExecute = {
                    /*val progressBar = this.find<ProgressBar>(R.id.progressBar)
                    progressBar.visibility = ProgressBar.VISIBLE
                    longToast("preExecute")*/
                },
                success = {
                    data.addAll(it.value)
                    ClienteListActivityUI(ClienteListAdapter(data)).setContentView(this)
                },
                failure = {
                    longToast("Falha ao buscar os clientes: ${it.message}")
                },
                finished = {
                    /*val progressBar = find<ProgressBar>(R.id.progressBar)
                    progressBar.visibility = ProgressBar.GONE*/
                    //longToast("finished")
                })
    }

    class ClienteListActivityUI(private val listAdapter: ClienteListAdapter) : AnkoComponent<ClienteListActivity> {

        override fun createView(ui: AnkoContext<ClienteListActivity>): View = with(ui) {
            linearLayout {
                lparams(matchParent, matchParent)

                progressBar {
                    visibility = ProgressBar.GONE
                    id = R.id.progressBar
                }.lparams (width = matchParent, height = wrapContent)

                recyclerView {
                    lparams(matchParent, matchParent)
                    val orientation = LinearLayoutManager.VERTICAL
                    layoutManager = LinearLayoutManager(ctx, orientation, false)
                    overScrollMode = View.OVER_SCROLL_NEVER
                    adapter = listAdapter
                    scrollToPosition(0)
                }
            }
        }
    }
}