package com.monique.elevator_app

class Elevator(private var pplQuantity: Int = 0,
               private var currentFloor: Int = 0,
               private val limitPeople: Int = 5){

    fun setQuantityToAdd(quant: Int): Int = (pplQuantity+quant)
    fun setFloor(floor: Int): Int {
        currentFloor = floor
        return currentFloor
    }
    fun getQuant(): Int = pplQuantity
    fun getFloor(): Int = currentFloor
    fun getLimitPeople(): Int = limitPeople
}