package com.zanyzephyr.androidtricktest

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class Person(val name: String, val age: Int): Parcelable {

}