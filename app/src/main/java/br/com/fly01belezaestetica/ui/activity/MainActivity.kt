package br.com.fly01belezaestetica.ui.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.view.Gravity
import br.com.fly01belezaestetica.R
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

                val name = editText {
                    hintResource = R.string.login_name_hint
                    hintTextColor = Color.WHITE
                    textColor = Color.WHITE
                }

                val password = editText {
                    hintResource = R.string.login_password_hint
                    hintTextColor = Color.WHITE
                    textColor = Color.WHITE
                    inputType = InputType.TYPE_NUMBER_VARIATION_PASSWORD
                }

                button(R.string.login_button) {
                    backgroundColor = Color.LTGRAY
                    onClick {
                        ui.ctx.startActivity(Intent(ui.ctx, IndexActivity::class.java))
                        toast("Hey ${name.text}! Thank you for contacting us. We will get in touch with you soon.")
                    }

                }.lparams(dip(280), sp(50))
            }
        }
    }
}
