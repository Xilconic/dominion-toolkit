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
		
		boolean useDominionFlag = preferences.getBoolean(useDominion, false);
		Log.d("DominionToolkitPreferences", "useDominion = " + useDominionFlag);
		if (useDominionFlag){
			cardSets.add(DominionSet.Dominion);
		}
		
				boolean useIntrigueFlag = preferences.getBoolean(useIntrigue, false);
		Log.d("DominionToolkitPreferences", "useIntrigue = " + useIntrigueFlag);
		if (useIntrigueFlag){
			cardSets.add(DominionSet.Intrigue);
		}
		
		return cardSets;
	}
}