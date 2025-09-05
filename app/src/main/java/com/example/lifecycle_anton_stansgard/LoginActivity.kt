package com.example.lifecycle_anton_stansgard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameInput = findViewById<EditText>(R.id.editUsername)
        val passwordInput = findViewById<EditText>(R.id.editPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)

        loginButton.setOnClickListener {
            val username = usernameInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            //Uppmaning till användaren ifall de försöker logga in med tomma input fält
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Fyll i både användarnamn och lösenord", Toast.LENGTH_SHORT).show()
            } else if (username == "admin" && password == "1234") {
                // Går vidare till nästa sida efter användaren loggar in med rätt uppgifter
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)

                // Hindrar användaren från att gå tillbaka till login med back-knappen
                finish()
            } else {
                Toast.makeText(this, "Fel inloggning", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
