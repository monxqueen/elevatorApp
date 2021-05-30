package com.monique.elevator_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

abstract class MainActivity : AppCompatActivity() {

    private lateinit var andarTxt: TextView
    private lateinit var qtdPessoasTxt: TextView
    private lateinit var andarEdt: EditText
    private lateinit var submitBtn: Button
    private lateinit var entrarBtn: Button
    private lateinit var sairBtn: Button
    private val qtdAndares = 7
    private var limitePessoas = 5
    private var qtdPessoas = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //bindViews()
        val elevator = Elevator()
        andarTxt = findViewById(R.id.floor)
        qtdPessoasTxt = findViewById(R.id.people)
        andarEdt = findViewById(R.id.floorInput)
        submitBtn = findViewById(R.id.submit)
        entrarBtn = findViewById(R.id.entry)
        sairBtn = findViewById(R.id.getoff)
        /* qtdPessoas = elevator.getQuant()
         limitePessoas = elevator.getLimitPeople()*/

        submitBtn.setOnClickListener {
            val andarInput = andarEdt.text.toString().toInt()

            if (andarInput > qtdAndares || andarInput < 0) {
                Toast.makeText(
                    this,
                    "Andar inválido, tente novamente",
                    Toast.LENGTH_LONG
                ).show()
            } else if (andarInput == 0) {
                andarTxt.text = "térreo"
                elevator.setFloor(0)
                //elevator.currentFloor = 0
            } else {
                andarTxt.text = "Andar = ${elevator.getFloor()}"
                //andarTxt.text = "${elevator.currentFloor}º \nandar"
                elevator.setFloor(andarInput)
            }
        }

        entrarBtn.setOnClickListener {

            if (qtdPessoas == limitePessoas) {
                Toast.makeText(
                    this,
                    "Elevador com capacidade máxima, espere alguém sair",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                elevator.setQuantityToAdd(1)
                //elevator.pplQuantity += 1
                qtdPessoas += 1
            }
            qtdPessoasTxt.text = "Qtd de pessoas = $qtdPessoas"
        }

        sairBtn.setOnClickListener {
            if (qtdPessoas == 0) {
                Toast.makeText(
                    this,
                    "Ninguém no elevador para sair",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                elevator.setQuantityToAdd(-1)
                //elevator.pplQuantity -= 1
                qtdPessoas -= 1
            }
            qtdPessoasTxt.text = "Qtd de pessoas = $qtdPessoas"
        }
    }
}
