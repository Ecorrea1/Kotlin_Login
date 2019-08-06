package com.ebcorreac.kotlin_login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registrar.*


class Registrar : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        auth = FirebaseAuth.getInstance()

        tv_createcount.setOnClickListener {}
        singUpUsers()



    }


   private fun singUpUsers(){

        if (txt_email.text.toString().isEmpty()){
            txt_email.error = "Please enter email"
            txt_email.requestFocus()
            return
        }

        if (Patterns.EMAIL_ADDRESS.matcher(txt_email.text.toString()).matches()){
            txt_email.error ="Please enter Valid Email"
            txt_email.requestFocus()
            return
        }

        if (txt_password.text.toString().isEmpty()){
            txt_password.error = "Please enter password"
            txt_password.requestFocus()
            return
        }

       auth.createUserWithEmailAndPassword(txt_c_email.text.toString(), txt_c_password.text.toString())
           .addOnCompleteListener(this) { task ->
               if (task.isSuccessful) {

                   startActivity(Intent(this,MainActivity::class.java))
                   finish()

               } else {

                   Toast.makeText(baseContext, "Authentication failed.",
                      Toast.LENGTH_SHORT).show()

               }

           }

   }
}
