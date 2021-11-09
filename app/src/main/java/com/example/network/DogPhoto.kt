package com.example.network
import com.squareup.moshi.Json

/**
* This data class defines a Mars photo which includes an ID, and the image URL.
* The property names of this data class are used by Moshi to match the names of values in JSON.
*/
data class DogPhoto(
    //val id: String,
    // used to map img_src from the JSON to imgSrcUrl in our class
    //Moshi parses this JSON data and converts it into Kotlin objects. To do this, Moshi needs to have a Kotlin data class to store the parsed results

    @Json(name ="message") val message: String?
    //val status: String = "success"
)
