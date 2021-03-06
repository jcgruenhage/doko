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

package re.jcg.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class SectionsPagerAdapter(fm: FragmentManager, var fragments: List<Fragment>) : FragmentPagerAdapter(fm) {

    override fun getItem(pPosition: Int): Fragment {
        return fragments[pPosition]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}
