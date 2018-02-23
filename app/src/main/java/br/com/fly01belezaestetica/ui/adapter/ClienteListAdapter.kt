package br.com.fly01belezaestetica.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.fly01belezaestetica.R
import br.com.fly01belezaestetica.model.ClienteModel
import br.com.fly01belezaestetica.ui.layout.ClienteItemLayout
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

/**
 * Created by rodri on 21/02/2018.
 */

class ClienteListAdapter(private val clienteList: List<ClienteModel>,
                         private var onItemClickListener: (cliente: ClienteModel, position: Int) -> Unit)
    : RecyclerView.Adapter<ClienteListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder =
            ViewHolder(ClienteItemLayout().createView(AnkoContext.Companion.create(parent!!.context, this, false)))

    override fun getItemCount(): Int = clienteList.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.let {
            it.bindView(clienteList[position])
            it.itemView.setOnClickListener {
                onItemClickListener(clienteList[position], position)
            }
        }
    }

    //Classe de ViewHolder
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val txtViewNome by lazy {
            itemView.find<TextView>(R.id.txtNomeItem)
        }
        private val txtViewDocumento by lazy {
            itemView.find<TextView>(R.id.txtDocumentoItem)
        }
        private val txtViewEmail by lazy {
            itemView.find<TextView>(R.id.txtEmailItem)
        }

        fun bindView(clienteModel: ClienteModel) {
            with(clienteModel) {
                txtViewNome.text = nome
                txtViewDocumento.text = documento
                txtViewEmail.text = email
            }
        }
    }
}