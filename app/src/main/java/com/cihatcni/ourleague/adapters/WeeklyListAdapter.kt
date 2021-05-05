package com.cihatcni.ourleague.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cihatcni.ourleague.R
import com.cihatcni.ourleague.model.Match
import com.squareup.picasso.Picasso

class WeeklyListAdapter(private val matchList: MutableList<Match>) : RecyclerView.Adapter<WeeklyListAdapter.ModelViewHolder>() {

    class ModelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val homeTeamName: TextView = view.findViewById(R.id.homeTeamMCV)
        private val awayTeamName: TextView = view.findViewById(R.id.awayTeamMCV)
        private val homeTeamLogo: ImageView = view.findViewById(R.id.homeTeamLogoMCV)
        private val awayTeamLogo: ImageView = view.findViewById(R.id.awayTeamLogoMCV)

        fun bindItems(match: Match) {
            val homeTeam = match.homeTeam
            val awayTeam = match.awayTeam
            homeTeamName.text = homeTeam.short_code
            awayTeamName.text = awayTeam.short_code
            Picasso.get().load(homeTeam.logo).into(homeTeamLogo)
            Picasso.get().load(awayTeam.logo).into(awayTeamLogo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.match_custom_view, parent, false)
        return ModelViewHolder(view)
    }

    override fun getItemCount(): Int {
        return matchList.size
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.bindItems(matchList[position])
    }

}