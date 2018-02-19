package br.com.fly01belezaestetica.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.fly01belezaestetica.ui.adapter.NoteListAdapter
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView


class ClienteListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        IndexActivityUI().setContentView(this)
    }

    class ClienteListActivityUI(val listAdapter: NoteListAdapter) : AnkoComponent<ClienteListActivity> {

        override fun createView(ui: AnkoContext<ClienteListActivity>) = with(ui) {
            linearLayout {
                lparams(matchParent, matchParent)

                val note_list_recyclerview = recyclerView {
                    lparams(matchParent, matchParent)

                }
            }
        }
    }
}