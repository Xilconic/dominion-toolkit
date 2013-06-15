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
package com.xilconic.dominiontoolkit.Activities;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.xilconic.dominiontoolkit.DominionCards.DominionSet;

/**
 * Class used to manage the setting-preferences of the User 
 * @author Bas des Bouvrie
 *
 */
public class DominionToolkitPreferences {
	public static SharedPreferences getPreferences(Context context){
	    return PreferenceManager.getDefaultSharedPreferences(context);
	}
	
	public static List<DominionSet> getActiveDominionSets(Context context){
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		
		List<DominionSet> cardSets = new ArrayList<DominionSet>();
		
		addDominionSetUse(preferences, DominionSet.Dominion, cardSets);
		addDominionSetUse(preferences, DominionSet.Intrigue, cardSets);
		addDominionSetUse(preferences, DominionSet.Seaside, cardSets);
		addDominionSetUse(preferences, DominionSet.Alchemy, cardSets);
		addDominionSetUse(preferences, DominionSet.Prosperity, cardSets);
		addDominionSetUse(preferences, DominionSet.Cornucopia, cardSets);
		addDominionSetUse(preferences, DominionSet.Hinterlands, cardSets);
		addDominionSetUse(preferences, DominionSet.DarkAges, cardSets);
		addDominionSetUse(preferences, DominionSet.Promos, cardSets);
		return cardSets;
	}
	
	private static void addDominionSetUse(SharedPreferences preferences, DominionSet set, List<DominionSet> cardSets){
	    boolean useSet = preferences.getBoolean(getSettingsIdForDominionSet(set), false);
	    if (useSet){
	        cardSets.add(set);
	    }
	}
	
	private static String getSettingsIdForDominionSet(DominionSet set){
	    switch (set) {
        case Dominion: return DominionToolkitSettingsActivity.USE_DOMINION;
        case Intrigue: return DominionToolkitSettingsActivity.USE_INTRIGUE;
        case Seaside: return DominionToolkitSettingsActivity.USE_SEASIDE;
        case Alchemy: return DominionToolkitSettingsActivity.USE_ALCHEMY;
        case Prosperity: return DominionToolkitSettingsActivity.USE_PROSPERITY;
        case Cornucopia: return DominionToolkitSettingsActivity.USE_CORNUCOPIA;
        case Hinterlands: return DominionToolkitSettingsActivity.USE_HINTERLANDS;
        case DarkAges: return DominionToolkitSettingsActivity.USE_DARKAGES;
        case Promos: return DominionToolkitSettingsActivity.USE_PROMOS;
        default:
            throw new IllegalStateException();
        }
	}
}
