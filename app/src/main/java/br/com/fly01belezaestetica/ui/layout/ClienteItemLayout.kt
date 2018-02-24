package br.com.fly01belezaestetica.ui.layout

import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import br.com.fly01belezaestetica.R
import br.com.fly01belezaestetica.ui.adapter.ClienteListAdapter
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

/**
 * Created by rodri on 21/02/2018.
 */
class ClienteItemLayout : AnkoComponent<ClienteListAdapter> {
    override fun createView(ui: AnkoContext<ClienteListAdapter>): View = with(ui) {
        verticalLayout {
            lparams(width = matchParent, height = wrapContent)
            cardView {
                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    lparams(width = matchParent)

                    imageView(R.drawable.system_user) {
                        id = R.id.imgClienteItem
                        scaleType = ImageView.ScaleType.FIT_START
                        adjustViewBounds = true
                        //https://robots.thoughtbot.com/android-imageview-scaletype-a-visual-guide
                    }.lparams(width = dip(0), height = dip(80), weight = 1f)

                    linearLayout {
                        padding = dip(5)
                        orientation = LinearLayout.VERTICAL
                        textView("Nome") {
                            id = R.id.txtNomeItem
                            textAppearance = android.R.style.TextAppearance_Material_Large
                        }
                        textView("Documento") {
                            id = R.id.txtDocumentoItem
                            textAppearance = android.R.style.TextAppearance_Material_Small
                            //setTextAppearance(ctx, android.R.style.TextAppearance_Material_Small)
                        }
                        textView("Email") {
                            id = R.id.txtEmailItem
                            textAppearance = android.R.style.TextAppearance_Material_Medium
                            textColorResource = R.color.colorPrimaryDark
                        }.lparams {
                            topMargin = dip(5)
                            //gravity = Gravity.END
                        }
                    }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                }
            }
        }
    }
}