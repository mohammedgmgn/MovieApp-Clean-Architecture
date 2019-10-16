package com.mahmoud.mohammed.movieapp.data.remote.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "movies")
data class MovieData(

        @SerializedName("id")
        @PrimaryKey
        var id: Int = -1,

        @SerializedName("vote_count")
        var voteCount: Int = 0,

        @SerializedName("vote_average")
        var voteAverage: Double = 0.0,

        @SerializedName("adult")
        var adult: Boolean = false,

        @SerializedName("popularity")
        var popularity: Double = 0.0,

        @SerializedName("title")
        var title: String,

        @SerializedName("poster_path")
        var posterPath: String? = null,

        @SerializedName("original_language")
        var originalLanguage: String,

        @SerializedName("original_title")
        var originalTitle: String,

        @SerializedName("backdrop_path")
        var backdropPath: String? = null,

        @SerializedName("release_date")
        var releaseDate: String,

        @SerializedName("overview")
        var overview: String? = null
) : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readInt(),
                parcel.readInt(),
                parcel.readDouble(),
                parcel.readByte() != 0.toByte(),
                parcel.readDouble(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeInt(id)
                parcel.writeInt(voteCount)
                parcel.writeDouble(voteAverage)
                parcel.writeByte(if (adult) 1 else 0)
                parcel.writeDouble(popularity)
                parcel.writeString(title)
                parcel.writeString(posterPath)
                parcel.writeString(originalLanguage)
                parcel.writeString(originalTitle)
                parcel.writeString(backdropPath)
                parcel.writeString(releaseDate)
                parcel.writeString(overview)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<MovieData> {
                override fun createFromParcel(parcel: Parcel): MovieData {
                        return MovieData(parcel)
                }

                override fun newArray(size: Int): Array<MovieData?> {
                        return arrayOfNulls(size)
                }
        }
}

/*data class MovieData : Serializable {
        @SerializedName("id")
        @PrimaryKey
        var id: Int = -1

        @SerializedName("vote_count")
        var voteCount: Int = 0

        @SerializedName("vote_average")
        var voteAverage: Double = 0.0

        @SerializedName("adult")
        var adult: Boolean = false

        @SerializedName("popularity")
        var popularity: Double = 0.0

        @SerializedName("title")
        lateinit var title: String

        @SerializedName("poster_path")
        var posterPath: String? = null

        @SerializedName("original_language")
        lateinit var originalLanguage: String

        @SerializedName("original_title")
        lateinit var originalTitle: String

        @SerializedName("backdrop_path")
        var backdropPath: String? = null

        @SerializedName("release_date")
        lateinit var releaseDate: String

        @SerializedName("overview")
        var overview: String? = null
}*/
