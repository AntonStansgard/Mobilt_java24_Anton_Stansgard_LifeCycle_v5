package com.example.lifecycle_anton_stansgard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var ageInput: EditText
    private lateinit var drivingLicenseCheck: CheckBox
    private lateinit var genderGroup: RadioGroup
    private lateinit var emailInput: EditText
    private lateinit var countrySpinner: Spinner
    private lateinit var submitButton: Button

    private val prefsName = "profile_prefs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Hämtar toolbar och sätter som ActionBar
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Hämtar UI-komponenter
        ageInput = findViewById(R.id.editAge)
        drivingLicenseCheck = findViewById(R.id.checkDrivingLicense)
        genderGroup = findViewById(R.id.radioGender)
        emailInput = findViewById(R.id.editEmail)
        countrySpinner = findViewById(R.id.spinnerCountry)
        submitButton = findViewById(R.id.btnSubmit)

        // Spinner med länder
        val countries = arrayOf("Sverige", "Norge", "Danmark", "Finland", "Annat")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, countries)
        countrySpinner.adapter = adapter

        // Ladda sparad data
        loadData()

        // Spara data när man klickar på submit
        submitButton.setOnClickListener {
            saveData()
            Toast.makeText(this, "Uppgifter sparade!", Toast.LENGTH_SHORT).show()
        }
    }

    // Skapar menyn
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Hanterar menyvalen
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_profile -> {
                true
            }

            //När användaren loggar ut kommer man till inloggningen, istället för att stänga appen
            R.id.menu_logout -> {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Sparar användarens input med SharedPreferences
    private fun saveData() {
        val prefs = getSharedPreferences(prefsName, Context.MODE_PRIVATE)
        val editor = prefs.edit()

        val selectedGenderId = genderGroup.checkedRadioButtonId
        val selectedGender = if (selectedGenderId != -1) {
            findViewById<RadioButton>(selectedGenderId).text.toString()
        } else ""

        editor.putString("age", ageInput.text.toString())
        editor.putBoolean("drivingLicense", drivingLicenseCheck.isChecked)
        editor.putString("gender", selectedGender)
        editor.putString("email", emailInput.text.toString())
        editor.putInt("countryPos", countrySpinner.selectedItemPosition)

        editor.apply()
    }

    // Laddar användarens sparade input
    private fun loadData() {
        val prefs = getSharedPreferences(prefsName, Context.MODE_PRIVATE)

        ageInput.setText(prefs.getString("age", ""))
        drivingLicenseCheck.isChecked = prefs.getBoolean("drivingLicense", false)
        emailInput.setText(prefs.getString("email", ""))
        countrySpinner.setSelection(prefs.getInt("countryPos", 0))

        val savedGender = prefs.getString("gender", "")
        if (savedGender!!.isNotEmpty()) {
            for (i in 0 until genderGroup.childCount) {
                val radio = genderGroup.getChildAt(i) as RadioButton
                if (radio.text == savedGender) {
                    radio.isChecked = true
                    break
                }
            }
        }
    }
}
