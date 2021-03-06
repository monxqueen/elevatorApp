package com.monique.elevator_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var andarTxt: TextView
    private lateinit var qtdPessoasTxt: TextView
    private lateinit var andarEdt: TextInputLayout
    private lateinit var submitBtn: Button
    private lateinit var entrarBtn: Button
    private lateinit var sairBtn: Button
    private val elevator = Elevator(0, 0, 5, 7)
    private val limitePessoas = elevator.getLimitPeople()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
    }

    private fun bindViews(){
        andarTxt = findViewById(R.id.floor)
        qtdPessoasTxt = findViewById(R.id.people)
        andarEdt = findViewById(R.id.floorInput)
        submitBtn = findViewById(R.id.submit)
        entrarBtn = findViewById(R.id.entry)
        sairBtn = findViewById(R.id.getoff)

        submitBtn.setOnClickListener{
            val andarInput = andarEdt.editText?.text.toString().toInt()
            val sobeOuDesce: Boolean = elevator.subirOuDescer(andarInput, andarTxt)

            if(sobeOuDesce == false){
                Toast.makeText(this,
                    "Andar inválido, tente novamente",
                    Toast.LENGTH_LONG).show()
            }
        }

        entrarBtn.setOnClickListener{
            val podeEntrar: Boolean = elevator.entrar()
            if(podeEntrar){
                elevator.setPplQuantity(1)
            }else{
                Toast.makeText(this,
                    "Elevador com capacidade máxima, espere alguém sair",
                    Toast.LENGTH_LONG).show()
            }
            qtdPessoasTxt.text = "${elevator.getQuantPpl()}/$limitePessoas"
        }

        sairBtn.setOnClickListener{
            val podeSair: Boolean = elevator.sair()
            if(podeSair){
                elevator.setPplQuantity(-1)
            }else{
                Toast.makeText(this,
                    "Ninguém no elevador para sair",
                    Toast.LENGTH_LONG).show()
            }
            qtdPessoasTxt.text = "${elevator.getQuantPpl()}/$limitePessoas"
        }

    }
}