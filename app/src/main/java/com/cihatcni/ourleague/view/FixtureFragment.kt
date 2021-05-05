package com.cihatcni.ourleague

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.cihatcni.ourleague.adapters.WeeklyListAdapter

class FixtureFragment : Fragment() {

    private lateinit var fixtureViewPagerAdapter: FixtureViewPagerAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_fixture, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fixtureViewPagerAdapter = FixtureViewPagerAdapter(this)
        viewPager = view.findViewById(R.id.fixtureViewPager)
        viewPager.adapter = fixtureViewPagerAdapter
    }
}

private const val WEEK_COUNT = "week_count"

class FixtureViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = FixtureGenerator.fixture.weeks.size

    override fun createFragment(position: Int): Fragment {
        val fragment = FixtureObjectFragment()
        fragment.arguments = Bundle().apply { putInt(WEEK_COUNT, position) }
        return fragment
    }
}

class FixtureObjectFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_week, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(WEEK_COUNT) }?.apply {
            val weekCount = getInt(WEEK_COUNT)
            val weekRecyclerView: RecyclerView = view.findViewById(R.id.weekRecyclerView)
            val weekCountTextView: TextView = view.findViewById(R.id.weekCountText)
            val matches = FixtureGenerator.getMatchesAtWeek(weekCount)
            weekCountTextView.text = "Week ${weekCount + 1}"
            weekRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            weekRecyclerView.adapter = WeeklyListAdapter(matches)
        }
    }
}