package com.cihatcni.ourleague.model

import android.graphics.Bitmap

data class TeamResponse(
    val data: ArrayList<Team>,
    val query: Query
)

data class Query(
    val apikey: String,
    val country_id: String
)

data class Team(
    val common_name: String?,
    val country: Country?,
    val logo: String?,
    val name: String,
    val short_code: String?,
    val team_id: Int?,
    var logoDrawable: Bitmap?
)

data class Country(
    val continent: String,
    val country_code: String,
    val country_id: Int,
    val name: String
)