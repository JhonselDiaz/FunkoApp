package com.funkoapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.funkoapp.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

//
class MainActivity : AppCompatActivity() {
    //variable para acceder a la autenticacion
    private lateinit var auth: FirebaseAuth
    //variable para acceder a los elementos de la pantalla activity_main.xhml
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        //Se define el metodo para registrar
        binding.btRegister.setOnClickListener{haceRegristro()}
        //Se define el metodo para el login
        binding.btLogin.setOnClickListener { haceLogin() }
    }
    private fun haceLogin() {
        val email = binding.etEmail.text.toString()
        val clave = binding.etPassword.text.toString()

        //Se usa la función para crear un usuario por medio de correo y contraseña
        auth.signInWithEmailAndPassword(email,clave)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    actualiza(user)
                } else {
                    Toast.makeText(baseContext,
                        getString(R.string.msg_fallo_login),
                        Toast.LENGTH_SHORT).show()
                    actualiza(null)
                }
            }
    }

    private fun haceRegristro() {
        val email = binding.etEmail.text.toString()
        val clave = binding.etPassword.text.toString()

        //Se usa la función para crear un usuario por medio de correo y contraseña
        auth.createUserWithEmailAndPassword(email,clave)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    actualiza(user)
                } else {
                    Toast.makeText(baseContext,
                        getString(R.string.msg_fallo_registro),
                        Toast.LENGTH_SHORT).show()
                    actualiza(null)
                }
            }
    }
    private fun actualiza(user: FirebaseUser?) {
        if (user!=null) {
            // paso a la pantalla principal
            val intent = Intent(this, Principal::class.java)
            startActivity(intent)
        }
    }
    //mantener session
    public override fun onStart(){
        super.onStart()
        val usuario = auth.currentUser
        actualiza(usuario)
    }
}