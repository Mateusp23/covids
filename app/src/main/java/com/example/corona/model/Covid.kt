package com.example.corona.model

import android.os.Parcel
import android.os.Parcelable

class Covid(
    var suspects: Int=0,
    var confirmed: Int=0,
    var discarded: Int=0,
    var monitoring: Int=0,
    var cured: Int=0,
    var domicile: Int=0,
    var suspectHospital: Int=0,
    var confirmedHospital: Int=0,
    var deads: Int=0,
    var date: String?,
    var hour: String?
) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(suspects)
        parcel.writeInt(confirmed)
        parcel.writeInt(discarded)
        parcel.writeInt(monitoring)
        parcel.writeInt(cured)
        parcel.writeInt(domicile)
        parcel.writeInt(suspectHospital)
        parcel.writeInt(confirmedHospital)
        parcel.writeInt(deads)
        parcel.writeString(date)
        parcel.writeString(hour)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Covid> {
        override fun createFromParcel(parcel: Parcel): Covid {
            return Covid(parcel)
        }

        override fun newArray(size: Int): Array<Covid?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return super.toString()
    }
}