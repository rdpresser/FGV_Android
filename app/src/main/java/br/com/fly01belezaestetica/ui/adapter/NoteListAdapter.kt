package br.com.fly01belezaestetica.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.fly01belezaestetica.R
import br.com.fly01belezaestetica.model.NoteModel
import br.com.fly01belezaestetica.ui.layout.NoteItemListLayout
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

/**
 * Created by rodrigo.presser on 19/02/2018.
 */

class NoteListAdapter(private val noteModels: List<NoteModel>) : RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder =
            ViewHolder(NoteItemListLayout().createView(AnkoContext.Companion.create(parent!!.context, this, false )))

    override fun getItemCount(): Int = noteModels.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.let {
            it.bindView(noteModels[position])
        }
    }

    //Classe de ViewHolder
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val txtViewTitle by lazy {
            itemView.find<TextView>(R.id.txtTitleItem)
        }
        private val txtViewDesc by lazy {
            itemView.find<TextView>(R.id.txtDescItem)
        }
        private val txtViewPrice by lazy {
            itemView.find<TextView>(R.id.txtPriceItem)
        }

        fun bindView(noteModel: NoteModel) {
            with(noteModel) {
                txtViewTitle.text = title
                txtViewDesc.text = description
                txtViewPrice.text = price
            }
        }
    }
}