package br.com.fly01belezaestetica.ui.activity

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.view.Gravity
import android.widget.TextView
import br.com.fly01belezaestetica.R
import br.com.fly01belezaestetica.utils.App
import br.com.fly01belezaestetica.utils.Prefs
import br.com.fly01belezaestetica.utils.prefs
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }

    class MainActivityUI() : AnkoComponent<MainActivity> {

        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            val prefs = Prefs(ui.ctx)

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
                    setText("rodrigo.presser@gmail.com", TextView.BufferType.EDITABLE)
                }

                val password = editText {
                    hintResource = R.string.login_password_hint
                    hintTextColor = Color.WHITE
                    textColor = Color.WHITE
                    inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD //TODO: Não está alterando o inputType para a máscara de pwd.
                    setText("123456", TextView.BufferType.EDITABLE)
                }

                button(R.string.login_button) {
                    backgroundColor = Color.LTGRAY
                    onClick {
                        prefs!!.userName = name.text.toString()
                        prefs!!.userPassword = password.text.toString()

                        //val prefs = ui.ctx.getSharedPreferences(PREFS_FILENAME, 0)
                        ui.ctx.startActivity(intentFor<ClienteListActivity>())
                        toast("Olá ${prefs!!.userName}! Seja Bem Vindo(a)!.")
                    }

                }.lparams(dip(280), sp(50))
            }
        }
    }
}
