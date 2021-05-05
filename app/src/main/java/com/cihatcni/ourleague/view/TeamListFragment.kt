package com.cihatcni.ourleague.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cihatcni.ourleague.activities.FixtureActivity
import com.cihatcni.ourleague.FixtureGenerator
import com.cihatcni.ourleague.R
import com.cihatcni.ourleague.adapters.TeamListAdapter
import com.cihatcni.ourleague.model.Team
import com.cihatcni.ourleague.viewmodel.TeamListViewModel

class TeamListFragment : Fragment() {

    private lateinit var teamListViewModel: TeamListViewModel
    private lateinit var teamListRecyclerView: RecyclerView
    private lateinit var drawFixtureButton: Button
    private lateinit var teams: ArrayList<Team>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.team_list_fragment, container, false)
        teamListRecyclerView = view.findViewById(R.id.teamListRecyclerView)
        drawFixtureButton = view.findViewById(R.id.drawFixtureButton)
        drawFixtureButton.setOnClickListener { drawFixture() }
        return view
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        teamListRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        teamListViewModel = ViewModelProvider(this).get(TeamListViewModel::class.java)

        teamListViewModel.getTeams()!!.observe(viewLifecycleOwner, {
            teamListRecyclerView.adapter = TeamListAdapter(it.data.toMutableList())
            teams = it.data
        })
    }

    private fun drawFixture() {
        val deletedTeams = ArrayList<Team>()
        teams.forEach {team -> if(team.name == "Besiktas JK U19" || team.name == "Besiktas (W)") deletedTeams.add(team)}
        deletedTeams.forEach{teams.remove(it)}
        FixtureGenerator.createFixture(teams)
        val intent = Intent(context, FixtureActivity::class.java)
        startActivity(intent)
    }


}

