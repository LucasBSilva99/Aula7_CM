package com.example.acalculator

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Operation (val expression:String,  val result:Double) : Parcelable {

    override fun toString(): String {
        return "${expression}=${result}"
    }

}