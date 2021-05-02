package com.cihatcni.ourleague.model

data class TeamResponse(
    val data: List<Data>,
    val query: Query
)

data class Query(
    val apikey: String,
    val country_id: String
)

data class Data(
    val common_name: String,
    val country: Country,
    val logo: String,
    val name: String,
    val short_code: String,
    val team_id: Int
)

data class Country(
    val continent: String,
    val country_code: String,
    val country_id: Int,
    val name: String
)