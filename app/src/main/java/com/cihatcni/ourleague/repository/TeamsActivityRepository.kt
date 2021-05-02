package com.cihatcni.ourleague.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.cihatcni.ourleague.model.TeamResponse
import com.cihatcni.ourleague.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object TeamsActivityRepository {

    private const val TAG = "TeamsActivityRepository"
    private const val API_KEY = "7d3444b0-aa82-11eb-b487-adf0f05b28ae"
    private const val TURKEY_CODE = "120"

    private val teamData = MutableLiveData<TeamResponse>()

    fun getTeamsApiCall(): MutableLiveData<TeamResponse> {

        val call = RetrofitClient.apiInterface.getTeams(API_KEY, TURKEY_CODE)

        call.enqueue(object : Callback<TeamResponse> {
            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
                Log.v(TAG, "ERROR: " + t.message.toString())
            }

            override fun onResponse(call: Call<TeamResponse>, response: Response<TeamResponse>) {
                //Log.v(TAG, "BODY: " + response.body().toString())
                teamData.value = response.body()
            }
        })

        return teamData
    }

}