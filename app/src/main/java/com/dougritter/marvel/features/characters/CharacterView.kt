package com.dougritter.marvel.features.characters

import android.os.Parcel
import com.dougritter.marvel.core.platform.KParcelable
import com.dougritter.marvel.core.platform.parcelableCreator
import com.dougritter.marvel.core.platform.readTypedObjectCompat
import com.dougritter.marvel.core.platform.writeTypedObjectCompat

data class CharacterView(val id: Int, val name: String, val thumbnail: Thumbnail) : KParcelable {
    companion object {
        @JvmField val CREATOR = parcelableCreator(
                ::CharacterView)
    }

    constructor(parcel: Parcel) : this(parcel.readInt(), parcel.readString(), parcel.readTypedObjectCompat(Thumbnail.CREATOR)!!)

    override fun writeToParcel(dest: Parcel, flags: Int) {
        with(dest) {
            writeInt(id)
            writeString(name)
            writeTypedObjectCompat(thumbnail, flags)
        }
    }
}