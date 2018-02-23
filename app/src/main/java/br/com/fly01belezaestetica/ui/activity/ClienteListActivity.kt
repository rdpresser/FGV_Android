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
import br.com.fly01belezaestetica.model.ClienteModel
import br.com.fly01belezaestetica.retrofit.client.ClienteWebClient
import br.com.fly01belezaestetica.ui.adapter.ClienteListAdapter
import br.com.fly01belezaestetica.ui.dialog.ClienteDialog
import br.com.fly01belezaestetica.utils.Prefs
import org.jetbrains.anko.*
import org.jetbrains.anko.design.floatingActionButton
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
                    ClienteListActivityUI(ClienteListAdapter(data,
                            { cliente, position ->
                                ClienteDialog(window.decorView as ViewGroup, this).alter(cliente) {
                                    data[position] = it
                                    ClienteListActivityUI(ClienteListAdapter(data, {_,_ -> Unit})).updateRecycler()
                                }
                                longToast("Posição clicada $cliente")
                            })
                    ).setContentView(this)
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

        companion object {
            private var rcCliente: RecyclerView? = null
        }

        fun updateRecycler(){
            rcCliente!!.adapter = listAdapter
        }

        override fun createView(ui: AnkoContext<ClienteListActivity>): View = with(ui) {
            linearLayout {

                //TODO: utilizar relativeLayout para ajustar o floating button
                floatingActionButton {
                    /*onClick {
                        longToast("Rodrigo Teste")
                    }*/
                    id = R.id.fabAddCliente
                    imageResource = R.drawable.add
                    visibility = FloatingActionButton.VISIBLE

                }.lparams {
                    width = wrapContent
                    height = wrapContent
                    gravity = Gravity.RIGHT
                    //margin = dip(15)
                }

                lparams(matchParent, matchParent)

                progressBar {
                    visibility = ProgressBar.GONE
                    id = R.id.progressBar
                }.lparams(width = matchParent, height = wrapContent)

                rcCliente = recyclerView {
                    lparams(matchParent, matchParent)
                    val orientation = LinearLayoutManager.VERTICAL
                    layoutManager = LinearLayoutManager(ctx, orientation, false)
                    overScrollMode = View.OVER_SCROLL_NEVER
                    adapter = listAdapter
                    scrollToPosition(0)
                }

                /*<android.support.design.widget.FloatingActionButton
            --android:id="@+id/fab_add_note"
            --android:layout_width="wrap_content"
            --android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:layout_alignParentRight="true"
            --android:layout_margin="15dp"
            --android:src="@drawable/add" />*/



                /*floatingActionButton {
                    onClick { doSomething() }
                    imageResource = R.drawable.ic_add_white_24dp // the plus sign
                }.lparams {
                    gravity = Gravity.BOTTOM or Gravity.END
                    margin = dip(16)
                }*/
            }
        }
    }
}