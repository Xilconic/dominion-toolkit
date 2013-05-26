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
import android.util.Log;

import com.xilconic.dominiontoolkit.DominionCards.DominionSet;

/**
 * Class used to manage the setting-preferences of the User 
 * @author Bas des Bouvrie
 *
 */
public class DominionToolkitPreferences {
	private static String TOOLKIT_PREFERENCES = "DominionToolkitPreferences";
	/**
	 * Preferences setting if the "Dominion" card set should be used.
	 */
	public static final String useDominion = "useDominion";
	/**
	 * Preferences setting if the "Dominion: Intrigue" card set should be used.
	 */
	public static final String useIntrigue = "useIntrigue";
	/**
	 * Preferences setting if the "Dominion: Seaside" card set should be used.
	 */
	public static final String useSeaside = "useSeaside";
	/**
	 * Preferences setting if the "Dominion: Alchemy" card set should be used.
	 */
	public static final String useAlchemy = "useAlchemy";
	/**
	 * Preferences setting if the "Dominion: Prosperity" card set should be used.
	 */
	public static final String useProsperity = "useProsperity";
	/**
	 * Preferences setting if the "Dominion: Cornucopia" card set should be used.
	 */
	public static final String useCornucopia = "useCornucopia";
	/**
	 * Preferences setting if the "Dominion: Hinterlands" card set should be used.
	 */
	public static final String useHinterlands = "useHinterlands";
	/**
	 * Preferences setting if the "Dominion: Dark Ages" card set should be used.
	 */
	public static final String useDarkAges = "useDarkAges";
	/**
	 * Preferences setting if promotional cards set should be used.
	 */
	public static final String usePromos = "usePromos";
	
	public static SharedPreferences getPreferences(Context context){
		return context.getSharedPreferences(TOOLKIT_PREFERENCES, Context.MODE_PRIVATE);
	}
	
	public static List<DominionSet> getActiveDominionSets(Context context){
		Log.d("DominionToolkitPreferences", "getActiveDominionSets()...");
		SharedPreferences preferences = context.getSharedPreferences(TOOLKIT_PREFERENCES, Context.MODE_PRIVATE);
		
		List<DominionSet> cardSets = new ArrayList<DominionSet>();
		
		boolean useCornucopiaFlag = preferences.getBoolean(useCornucopia, false);
        if (useCornucopiaFlag){
            cardSets.add(DominionSet.Cornucopia);
        }
		
		boolean useDominionFlag = preferences.getBoolean(useDominion, false);
		if (useDominionFlag){
			cardSets.add(DominionSet.Dominion);
		}
		
		boolean useIntrigueFlag = preferences.getBoolean(useIntrigue, false);
		if (useIntrigueFlag){
			cardSets.add(DominionSet.Intrigue);
		}
		
		boolean useProsperityFlag = preferences.getBoolean(useProsperity, false);
		if (useProsperityFlag){
			cardSets.add(DominionSet.Prosperity);
		}
		
		boolean useHinterlandsFlag = preferences.getBoolean(useHinterlands, false);
		if (useHinterlandsFlag){
			cardSets.add(DominionSet.Hinterlands);
		}
		
		boolean useSeasideFlag = preferences.getBoolean(useSeaside, false);
        if (useSeasideFlag){
            cardSets.add(DominionSet.Seaside);
        }
        
        boolean useDarkAgesFlag = preferences.getBoolean(useDarkAges, false);
        if (useDarkAgesFlag){
            cardSets.add(DominionSet.DarkAges);
        }
		
		return cardSets;
	}
}
