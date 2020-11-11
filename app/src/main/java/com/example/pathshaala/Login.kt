package com.example.pathshaala

import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*



class Login : AppCompatActivity() {
    private lateinit var loginId:EditText
    private lateinit var password:EditText
    var signIn: Button? = null
    var fetchedusername: String? = null
    var fetchedpassword:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginId = findViewById(R.id.text)
        password = findViewById(R.id.pass)
        signIn = findViewById<Button>(R.id.button)
        databaseinsert()
        signIn?.setOnClickListener { authentication() }

    }
    fun databaseinsert() {
        val pooja = databaseclass(this@Login)
        val db = pooja.writableDatabase
        val values = ContentValues()
        values.put("id", "1")
        values.put("muskanlogin", "admin")
        values.put("muskanpassword", "123")
        values.put("id", "2")
        values.put("muskanlogin", "sarthak")
        values.put("muskanpassword", "pooja")
        db.insert("student", null, values)
        databasefetch()
    }
    fun databasefetch() {
        val pooja :databaseclass = databaseclass(this@Login)
        val db : SQLiteDatabase = pooja.readableDatabase
        var coloumns = arrayOf("id", "muskanlogin", "muskanpassword")
        val  c: Cursor = db.query("student", coloumns, null, null, null, null, null)
        while (c.moveToNext()) {
            println(c.getString(0))
            fetchedusername = c.getString(1)
            fetchedpassword = c.getString(2)
        }
    }
    fun authentication() {
        if (loginId.getText().toString() == fetchedusername && password.text.toString() == fetchedpassword
        ) {
            val toast = Toast.makeText(this@Login, "logged in", Toast.LENGTH_LONG)
            signIn(signIn)
            toast.setGravity(Gravity.LEFT,200,200)
            toast.show()

        } else {
            val toast = Toast.makeText(this@Login, "error", Toast.LENGTH_LONG)
            toast.setGravity(Gravity.LEFT,200,200)
            toast.show()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
       finishAffinity()
    }

    fun  signIn(view: Button?) {
        button.setOnClickListener {
            val intent = Intent(this@Login, MainActivity::class.java)
            startActivity(intent)
        }
    }


}