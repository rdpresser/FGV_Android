package br.com.fly01belezaestetica.activities.cliente

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.fly01belezaestetica.R
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView


class IndexActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        IndexActivity.IndexActivityUI().setContentView(this)
    }

    class IndexActivityUI(val listAdapter: Adapter) : AnkoComponent<IndexActivity> {

        override fun createView(ui: AnkoContext<IndexActivity>) = with(ui) {
            linearLayout {
                lparams(matchParent, matchParent)

                val note_list_recyclerview = recyclerView {
                    lparams(matchParent, matchParent)

                }
            }
        }
    }
}

class NoteListAdapter(private val notes: List<Note>,
                      private val context: Context) : Adapter<NoteListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.note_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.let {
            it.bindView(notes[position])
        }
    }

    //Classe de ViewHolder
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(note: Note) {
            val title = itemView.note_item_title
            val description = itemView.note_item_description

            title.text = note.title
            description.text = note.description
        }
    }
}

class Note(val title: String, val description: String)