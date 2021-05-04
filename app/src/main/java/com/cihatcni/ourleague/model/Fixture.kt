package com.cihatcni.ourleague.model

import android.util.Log

data class Fixture(val weeks: ArrayList<Week>)

data class Match(val homeTeam: Team, val awayTeam: Team)

data class Week(val matches: ArrayList<Match>, val teams: ArrayList<Team>)

