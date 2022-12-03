package com.example.projectuts_160420077

data class Location(val id:Int, val name:String,val harga:Int)
{
    override fun toString(): String {
        return name;
    }
}
