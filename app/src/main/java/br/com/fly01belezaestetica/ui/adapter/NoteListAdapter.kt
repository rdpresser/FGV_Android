package br.com.fly01belezaestetica.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.fly01belezaestetica.R
import br.com.fly01belezaestetica.model.NoteModel

/**
 * Created by rodrigo.presser on 19/02/2018.
 */

class NoteListAdapter(private val noteModels: List<NoteModel>,
                      private val context: Context) : RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.note_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return noteModels.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.let {
            it.bindView(noteModels[position])
        }
    }

    //Classe de ViewHolder
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(noteModel: NoteModel) {
            val title = itemView.note_item_title
            val description = itemView.note_item_description

            title.text = noteModel.title
            description.text = noteModel.description
        }
    }
}