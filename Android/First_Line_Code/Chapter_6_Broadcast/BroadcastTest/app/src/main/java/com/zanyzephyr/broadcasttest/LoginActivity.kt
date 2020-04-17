package com.zanyzephyr.broadcasttest

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.zanyzephyr.activitytest.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        prefs = getPreferences(Context.MODE_PRIVATE)

        /* 根据是否记住密码，调整UI显示 */
        val isRememberPassword = prefs.getBoolean("remember_password", false)
        if (isRememberPassword) {
            rememberPassword.isChecked = true
            val account = prefs.getString("account", "")
            val password = prefs.getString("password", "")
            accountEdit.setText(account)
            passwordEdit.setText(password)
        } else {
            rememberPassword.isChecked = false
        }

        loginButton.setOnClickListener {
            val account = accountEdit.text.toString()
            val password = passwordEdit.text.toString()

            if (account == "admin" && password == "123456") {
                handleRememberPassword()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "account or password is invalid", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun handleRememberPassword() {
        val editor = prefs.edit()
        if (rememberPassword.isChecked) {

            editor.putBoolean("remember_password", true)
            val account = accountEdit.text.toString()
            val password = passwordEdit.text.toString()
            editor.putString("account", account)
            editor.putString("password", password)
        } else {
            editor.clear()
        }
        editor.apply()
    }
}
