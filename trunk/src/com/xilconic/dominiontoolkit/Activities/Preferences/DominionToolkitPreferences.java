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

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
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
		SharedPreferences preferences = getPreferences(context);
		
		List<DominionSet> cardSets = new ArrayList<DominionSet>();
		
		addDominionSetUse(preferences, DominionSet.Dominion, cardSets);
		addDominionSetUse(preferences, DominionSet.Intrigue, cardSets);
		addDominionSetUse(preferences, DominionSet.Seaside, cardSets);
		addDominionSetUse(preferences, DominionSet.Alchemy, cardSets);
		addDominionSetUse(preferences, DominionSet.Prosperity, cardSets);
		addDominionSetUse(preferences, DominionSet.Cornucopia, cardSets);
		addDominionSetUse(preferences, DominionSet.Hinterlands, cardSets);
		addDominionSetUse(preferences, DominionSet.DarkAges, cardSets);
		addDominionSetUse(preferences, DominionSet.Guilds, cardSets);
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
        case Guilds: return DominionToolkitSettingsActivity.USE_GUILDS;
        case Promos: return DominionToolkitSettingsActivity.USE_PROMOS;
        default:
            throw new IllegalStateException();
        }
	}
	
	public static Dictionary<DominionSet, Integer> getMinimumCardCount(Context context){
	    SharedPreferences preferences = getPreferences(context);
	    
	    Dictionary<DominionSet, Integer> minimumCardCounts = new Hashtable<DominionSet, Integer>();
	    minimumCardCounts.put(DominionSet.Dominion, getMinimumCardCount(preferences, DominionSet.Dominion));
	    minimumCardCounts.put(DominionSet.Intrigue, getMinimumCardCount(preferences, DominionSet.Intrigue));
	    minimumCardCounts.put(DominionSet.Seaside, getMinimumCardCount(preferences, DominionSet.Seaside));
	    minimumCardCounts.put(DominionSet.Alchemy, getMinimumCardCount(preferences, DominionSet.Alchemy));
	    minimumCardCounts.put(DominionSet.Prosperity, getMinimumCardCount(preferences, DominionSet.Prosperity));
	    minimumCardCounts.put(DominionSet.Cornucopia, getMinimumCardCount(preferences, DominionSet.Cornucopia));
	    minimumCardCounts.put(DominionSet.Hinterlands, getMinimumCardCount(preferences, DominionSet.Hinterlands));
	    minimumCardCounts.put(DominionSet.DarkAges, getMinimumCardCount(preferences, DominionSet.DarkAges));
	    minimumCardCounts.put(DominionSet.Guilds, getMinimumCardCount(preferences, DominionSet.Guilds));
	    minimumCardCounts.put(DominionSet.Promos, getMinimumCardCount(preferences, DominionSet.Promos));
	    
	    return minimumCardCounts;
	}
	
	public static Dictionary<DominionSet, Integer> getMaximumCardCount(Context context){
        SharedPreferences preferences = getPreferences(context);
        
        Dictionary<DominionSet, Integer> maximumCardCounts = new Hashtable<DominionSet, Integer>();
        maximumCardCounts.put(DominionSet.Dominion, getMaximumCardCount(preferences, DominionSet.Dominion));
        maximumCardCounts.put(DominionSet.Intrigue, getMaximumCardCount(preferences, DominionSet.Intrigue));
        maximumCardCounts.put(DominionSet.Seaside, getMaximumCardCount(preferences, DominionSet.Seaside));
        maximumCardCounts.put(DominionSet.Alchemy, getMaximumCardCount(preferences, DominionSet.Alchemy));
        maximumCardCounts.put(DominionSet.Prosperity, getMaximumCardCount(preferences, DominionSet.Prosperity));
        maximumCardCounts.put(DominionSet.Cornucopia, getMaximumCardCount(preferences, DominionSet.Cornucopia));
        maximumCardCounts.put(DominionSet.Hinterlands, getMaximumCardCount(preferences, DominionSet.Hinterlands));
        maximumCardCounts.put(DominionSet.DarkAges, getMaximumCardCount(preferences, DominionSet.DarkAges));
        maximumCardCounts.put(DominionSet.Guilds, getMaximumCardCount(preferences, DominionSet.Guilds));
        maximumCardCounts.put(DominionSet.Promos, getMaximumCardCount(preferences, DominionSet.Promos));
        
        return maximumCardCounts;
    }
	
	private static int getMinimumCardCount(SharedPreferences preferences, DominionSet set){
	    return IntegerRangePreference.getMinValueFromSharedPreferences(preferences, getSettingsIdDominionSetRange(set));
	}
	
	private static int getMaximumCardCount(SharedPreferences preferences, DominionSet set){
        return IntegerRangePreference.getMaxValueFromSharedPreferences(preferences, getSettingsIdDominionSetRange(set));
    }
	
	private static String getSettingsIdDominionSetRange(DominionSet set){
	    switch (set) {
        case Dominion: return DominionToolkitSettingsActivity.RANGE_DOMINION;
        case Intrigue: return DominionToolkitSettingsActivity.RANGE_INTRIGUE;
        case Seaside: return DominionToolkitSettingsActivity.RANGE_SEASIDE;
        case Alchemy: return DominionToolkitSettingsActivity.RANGE_ALCHEMY;
        case Prosperity: return DominionToolkitSettingsActivity.RANGE_PROSPERITY;
        case Cornucopia: return DominionToolkitSettingsActivity.RANGE_CORNUCOPIA;
        case Hinterlands: return DominionToolkitSettingsActivity.RANGE_HINTERLANDS;
        case DarkAges: return DominionToolkitSettingsActivity.RANGE_DARKAGES;
        case Guilds: return DominionToolkitSettingsActivity.RANGE_GUILDS;
        case Promos: return DominionToolkitSettingsActivity.RANGE_PROMOS;
        default:
            throw new IllegalStateException();
        }
	}
}
