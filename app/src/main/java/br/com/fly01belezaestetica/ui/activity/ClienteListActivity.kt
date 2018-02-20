package br.com.fly01belezaestetica.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import br.com.fly01belezaestetica.model.NoteModel
import br.com.fly01belezaestetica.ui.adapter.NoteListAdapter
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView


class ClienteListActivity : AppCompatActivity() {

    private val data: MutableList<NoteModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        data.add(NoteModel ("Title", "description", "234"))
        data.add(NoteModel ("Title", "description", "234"))
        data.add(NoteModel ("Title", "description", "234"))
        data.add(NoteModel ("Title", "description", "234"))
        data.add(NoteModel ("Title", "description", "234"))
        data.add(NoteModel ("Title", "description", "234"))
        data.add(NoteModel ("Title", "description", "234"))
        data.add(NoteModel ("Title", "description", "234"))
        data.add(NoteModel ("Title", "description", "234"))
        data.add(NoteModel ("Title", "description", "234"))
        data.add(NoteModel ("Title", "description", "234"))
        data.add(NoteModel ("Title", "description", "234"))
        data.add(NoteModel ("Title", "description", "234"))
        data.add(NoteModel ("Title", "description", "234"))
        data.add(NoteModel ("Title", "description", "234"))
        data.add(NoteModel ("Title", "description", "234"))
        data.add(NoteModel ("Title", "description", "234"))
        data.add(NoteModel ("Title", "description", "234"))
        data.add(NoteModel ("Title", "description", "234"))

        ClienteListActivityUI(NoteListAdapter(data)).setContentView(this)
    }

    class ClienteListActivityUI(private val listAdapter: NoteListAdapter) : AnkoComponent<ClienteListActivity> {

        override fun createView(ui: AnkoContext<ClienteListActivity>): View = with(ui) {
            linearLayout {
                lparams(matchParent, matchParent)

                val note_list_recyclerview = recyclerView {
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