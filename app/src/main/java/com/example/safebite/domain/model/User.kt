package com.example.safebite.domain.model

data class User(
    var id:String="",
    var name:String="",
    var username:String="",
    var email:String="",
    var height:Int?=0,
    var weight: Int? =0,
)