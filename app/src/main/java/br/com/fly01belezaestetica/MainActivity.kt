package br.com.fly01belezaestetica

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                gravity = Gravity.CENTER
                padding = dip(20)
                setBackgroundResource(R.drawable.background_01)

                imageView(R.drawable.beleza_estetica).lparams(width = matchParent) {
                    padding = dip(20)
                    margin = dip(15)
                }

                /*textView {
                    gravity = Gravity.CENTER
                    textColor = Color.WHITE
                    textSize = 24f
                    textResource = R.string.login_text
                }.lparams(width = matchParent) {
                    margin = dip(20)
                }*/

                val name = editText {
                    hintResource = R.string.login_name_hint
                    hintTextColor = Color.WHITE
                    textColor = Color.WHITE
                }

                val password = editText {
                    hintResource = R.string.login_password_hint
                    hintTextColor = Color.WHITE
                    textColor = Color.WHITE
                }

                button(R.string.login_button) {
                    backgroundColor = Color.LTGRAY
                    onClick {
                        toast("Hey ${name.text}! Thank you for contacting us. We will get in touch with you soon.")
                    }
                }.lparams(dip(280), sp(80))
            }
        }
    }
}
