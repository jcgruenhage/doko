/*
 * Copyright (c) 2017. Jan Christian Grünhage
 *
 *     This file is part of doko.
 *
 *     doko is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     doko is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with doko.  If not, see <http://www.gnu.org/licenses/>.
 */

package re.jcg.doko

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import re.jcg.doko.fragments.GraphFragment
import re.jcg.doko.fragments.HomeFragment
import re.jcg.doko.fragments.ScoreFragment
import re.jcg.util.SectionsPagerAdapter
import java.util.*

class MainActivity : AppCompatActivity() {
    val fragments = LinkedList<Fragment>()
    val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager, fragments)

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                view_pager.setCurrentItem(0)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_graph -> {
                view_pager.setCurrentItem(1)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_scoreboard -> {
                view_pager.setCurrentItem(2)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragments.add(HomeFragment())
        fragments.add(GraphFragment())
        fragments.add(ScoreFragment())
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        view_pager.adapter = sectionsPagerAdapter
        view_pager.addOnPageChangeListener(AdapterChangeListener(navigation))

    }

    class AdapterChangeListener(val navigation: BottomNavigationView) : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(position: Int) {
            when (position) {
                0 -> navigation.selectedItemId = R.id.navigation_home
                1 -> navigation.selectedItemId = R.id.navigation_graph
                2 -> navigation.selectedItemId = R.id.navigation_scoreboard
            }
        }
    }
}
