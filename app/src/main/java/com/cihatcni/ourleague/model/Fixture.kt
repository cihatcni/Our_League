package com.cihatcni.ourleague.model

data class Fixture(val weeks: ArrayList<Week>)

data class Match(val homeTeam: Team, val awayTeam: Team)

data class Week(val matches: ArrayList<Match>)

