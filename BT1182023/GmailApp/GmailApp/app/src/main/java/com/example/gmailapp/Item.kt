package com.example.gmailapp

import java.io.Serializable

data class Item(val name: String, val info : String, val time : String, var checked : Boolean ): Serializable