package com.cihatcni.ourleague

import android.util.Log
import com.cihatcni.ourleague.model.Fixture
import com.cihatcni.ourleague.model.Match
import com.cihatcni.ourleague.model.Team
import com.cihatcni.ourleague.model.Week
import java.util.*
import kotlin.collections.ArrayList

object FixtureGenerator {

    lateinit var teamList: ArrayList<Team>
    var halfWeekCount: Int = 0
    var fixture: Fixture = Fixture(ArrayList())
    const val TAG = "FixtureGenerator"

    fun createFixture(teams: ArrayList<Team>) {
        this.teamList = teams
        if (teams.size % 2 != 0) {
            teamList.add(Team("Ghost", null, null, null, null, null, null))
            Log.v(TAG, " Ghost takım eklendi. Yeni takım sayısı: " + teams.size)
        }
        halfWeekCount = teamList.size - 1
        for (i in 0 until halfWeekCount * 2)
            fixture.weeks.add(Week(ArrayList(), ArrayList()))
        createLeague()
        printWeeks()
    }

    private fun createLeague() {
        val constantTeam = teamList[0]
        teamList.removeAt(0)
        for(i in 0 until halfWeekCount) {
            fixture.weeks[i].matches.add(Match(constantTeam, teamList[0]))
            for(j in 1..teamList.size/2)
                fixture.weeks[i].matches.add(Match(teamList[j], teamList[teamList.size - j]))
            Collections.rotate(teamList,1)
        }
        for(i in 0 until halfWeekCount)
            for (match in fixture.weeks[i].matches)
                fixture.weeks[i+ halfWeekCount].matches.add(Match(match.awayTeam,match.homeTeam))
    }

    fun getMatchesAtWeek(i: Int): ArrayList<Match> {
        return fixture.weeks[i].matches
    }

    fun printWeeks() {
        var count = 0
        for (week in fixture.weeks) {
            Log.v(TAG, "Week $count -------------")
            for (match in week.matches)
                Log.v(TAG, "|| " + match.homeTeam.name + " vs " + match.awayTeam.name)
            count++
        }

    }

}