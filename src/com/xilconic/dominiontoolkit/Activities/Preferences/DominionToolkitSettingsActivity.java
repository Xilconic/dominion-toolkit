/*
 * This file is part of Dominion Toolkit.
 *
 *  Dominion Toolkit is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Dominion Toolkit is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Dominion Toolkit.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.xilconic.dominiontoolkit.Activities.Preferences;

import com.xilconic.dominiontoolkit.R;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class DominionToolkitSettingsActivity extends PreferenceActivity {
    public static final String USE_DOMINION = "preferences_use_dominion_base";
    public static final String USE_INTRIGUE = "preferences_use_intrige";
    public static final String USE_SEASIDE = "preferences_use_seaside";
    public static final String USE_ALCHEMY = "preferences_use_alchemy";
    public static final String USE_PROSPERITY = "preferences_use_prosperity";
    public static final String USE_CORNUCOPIA = "preferences_use_cornucopia";
    public static final String USE_HINTERLANDS = "preferences_use_hinterlands";
    public static final String USE_DARKAGES = "preferences_use_dark_ages";
    public static final String USE_PROMOS = "preferences_use_promos";
    
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
