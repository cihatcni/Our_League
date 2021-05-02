package com.cihatcni.ourleague.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cihatcni.ourleague.R
import com.cihatcni.ourleague.viewmodel.TeamListViewModel

class TeamListFragment : Fragment() {

    companion object {
        fun newInstance() = TeamListFragment()
    }

    private lateinit var teamListViewModel: TeamListViewModel
    private lateinit var teamNamesText: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.team_list_fragment, container, false)
        teamNamesText = view.findViewById(R.id.teamNamesText)
        return view
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        teamListViewModel = ViewModelProvider(this).get(TeamListViewModel::class.java)

        teamListViewModel.getTeams()!!.observe(viewLifecycleOwner, {
            it.data.forEach { team ->
                teamNamesText.text = teamNamesText.text.toString() + "\n" + team.name
            }
        })
    }

}

