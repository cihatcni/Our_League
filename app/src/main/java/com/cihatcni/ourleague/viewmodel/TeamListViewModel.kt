package com.cihatcni.ourleague.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cihatcni.ourleague.model.TeamResponse
import com.cihatcni.ourleague.repository.TeamsActivityRepository

class TeamListViewModel : ViewModel() {

    private var teamsLiveData: MutableLiveData<TeamResponse>? = null

    fun getTeams(): LiveData<TeamResponse>? {
        teamsLiveData = TeamsActivityRepository.getTeamsApiCall()
        return teamsLiveData
    }

}