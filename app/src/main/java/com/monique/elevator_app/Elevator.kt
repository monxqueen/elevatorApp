package com.monique.elevator_app

import android.widget.TextView

class Elevator(private var pplQuantity: Int,
               private var currentFloor: Int,
               private val limitPeople: Int,
               private val limitFloors: Int){

    fun setPplQuantity(quant: Int){
        pplQuantity += quant
    }
    fun getQuantPpl(): Int = pplQuantity
    fun getQuantFloors(): Int = limitFloors
    fun getLimitPeople(): Int = limitPeople

    fun entrar(): Boolean{
        if(pplQuantity == limitPeople){
            return false
        }else{
            return true
        }
    }
    fun sair(): Boolean{
        if(pplQuantity == 0) {
            return false
        }else{
            return true
        }
    }

    fun subirOuDescer(andarInput: Int, andarTxt: TextView): Boolean{
        if(andarInput > 0 && andarInput <= limitFloors){
            currentFloor = andarInput
            andarTxt.text = "${currentFloor}º\nandar"
            return true
        }else if(andarInput == 0){
            currentFloor == 0
            andarTxt.text = "térreo"
            return true
        }else{
            return false
        }
    }
}