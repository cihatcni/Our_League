package com.cihatcni.ourleague

import com.cihatcni.ourleague.model.TeamResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("api/v1/soccer/teams/")
    fun getTeams(@Query("apikey") key: String, @Query("country_id") countryID: String): Call<TeamResponse>

}