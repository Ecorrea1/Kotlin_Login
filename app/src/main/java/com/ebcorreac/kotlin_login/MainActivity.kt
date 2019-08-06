package com.ebcorreac.kotlin_login

import android.app.ListActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registrar.*

class MainActivity : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //creando una instancia de autentificacion de firebase
        auth = FirebaseAuth.getInstance()

            //llamando a la funcoion Onclick ded el textview de Crear cuenta
            // de el Login a Registrar

        tv_createcount.setOnClickListener{
            //direccionando a la actividad Registrar
            startActivity (Intent(this,Registrar::class.java))
            finish()

        }

    }
   /* public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    fun updateUI(currentUser: FirebaseUser?){



    }*/


}
