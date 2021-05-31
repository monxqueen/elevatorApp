package com.monique.elevator_app

class Elevator(private var pplQuantity: Int,
               private var currentFloor: Int,
               private val limitPeople: Int,
               private val limitFloors: Int){

    fun setPplQuantity(quant: Int){
        pplQuantity += quant
    }
    fun setFloor(floor: Int){
        currentFloor = floor
    }
    fun getQuantPpl(): Int = pplQuantity
    fun getQuantFloors(): Int = limitFloors
    fun getFloor(): Int = currentFloor
    fun getLimitPeople(): Int = limitPeople
}