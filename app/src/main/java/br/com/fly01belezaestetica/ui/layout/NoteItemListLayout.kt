package br.com.fly01belezaestetica.ui.layout

import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import br.com.fly01belezaestetica.R
import br.com.fly01belezaestetica.ui.adapter.NoteListAdapter
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

/**
 * Created by rodrigo.presser on 19/02/2018.
 */
class NoteItemListLayout : AnkoComponent<NoteListAdapter> {
    override fun createView(ui: AnkoContext<NoteListAdapter>): View = with(ui) {
        verticalLayout {
            lparams(width = matchParent, height = wrapContent)
            cardView {
                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    lparams(width = matchParent)

                    imageView(R.mipmap.ic_launcher) {
                        id = R.id.imgItem
                        scaleType = ImageView.ScaleType.CENTER_CROP
                    }.lparams(width = dip(0), height = dip(100), weight = 1f)

                    linearLayout {
                        padding = dip(5)
                        orientation = LinearLayout.VERTICAL
                        textView("Titulo") {
                            id = R.id.txtTitleItem
                            setTextAppearance(ctx, android.R.style.TextAppearance_Material_Large)
                        }
                        textView("Description") {
                            id = R.id.txtDescItem
                            setTextAppearance(ctx, android.R.style.TextAppearance_Material_Small)
                        }
                        textView("Price") {
                            id = R.id.txtPriceItem
                            setTextAppearance(ctx, android.R.style.TextAppearance_Material_Medium)
                            textColorResource = R.color.colorAccent
                        }.lparams {
                            topMargin = dip(5)
                            gravity = Gravity.END
                        }
                    }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                }
            }
        }
    }
}