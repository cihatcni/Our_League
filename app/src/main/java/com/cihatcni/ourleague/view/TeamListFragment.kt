package com.cihatcni.ourleague.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cihatcni.ourleague.R
import com.cihatcni.ourleague.TeamListAdapter
import com.cihatcni.ourleague.viewmodel.TeamListViewModel

class TeamListFragment : Fragment() {

    companion object {
        fun newInstance() = TeamListFragment()
    }

    private lateinit var teamListViewModel: TeamListViewModel
    private lateinit var teamListRecyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.team_list_fragment, container, false)
        teamListRecyclerView = view.findViewById(R.id.teamListRecyclerView)
        return view
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        teamListRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        teamListViewModel = ViewModelProvider(this).get(TeamListViewModel::class.java)

        teamListViewModel.getTeams()!!.observe(viewLifecycleOwner, {
            teamListRecyclerView.adapter = TeamListAdapter(it.data.toMutableList())
        })
    }

}

