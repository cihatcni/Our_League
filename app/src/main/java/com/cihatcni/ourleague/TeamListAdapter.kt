package com.cihatcni.ourleague

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cihatcni.ourleague.model.Team
import com.squareup.picasso.Picasso

class TeamListAdapter(private val teamList: MutableList<Team>) : RecyclerView.Adapter<TeamListAdapter.ModelViewHolder>() {

    class ModelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val teamName: TextView = view.findViewById(R.id.teamNameTLCW)
        private val teamShortName: TextView = view.findViewById(R.id.shortNameTLCW)
        private val teamLogo: ImageView = view.findViewById(R.id.teamLogoTLCW)

        fun bindItems(team: Team) {
            teamName.text = team.name
            teamShortName.text = team.short_code
            Picasso.get().load(team.logo).into(teamLogo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.team_list_custom_view, parent, false)
        return ModelViewHolder(view)
    }

    override fun getItemCount(): Int {
        return teamList.size
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.bindItems(teamList[position])
    }
}