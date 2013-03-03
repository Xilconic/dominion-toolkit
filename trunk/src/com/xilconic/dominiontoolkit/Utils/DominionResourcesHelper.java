package com.xilconic.dominiontoolkit.Utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.xilconic.dominiontoolkit.R;
import com.xilconic.dominiontoolkit.DominionCards.DominionSet;

public class DominionResourcesHelper {

	/**
	 * Returns the set icon corresponding with the given set.
	 * @param dominionSet The set.
	 * @return The icon if available, or null.
	 */
	public static Drawable GetSetIcon(Context context, DominionSet dominionSet) {
		switch (dominionSet) {
		case Basic:
			// No Icon for basic cards:
			return null;
		case Alchemy:
			return context.getResources().getDrawable(R.drawable.alchemy_icon);
		case BlackMarketPromo:
			return context.getResources().getDrawable(R.drawable.blackmarket_icon);
		case Cornucopia:
			return context.getResources().getDrawable(R.drawable.cornucopia_icon);
		case DarkAges:
			return context.getResources().getDrawable(R.drawable.darkages_icon);
		case Dominion:
			return context.getResources().getDrawable(R.drawable.dominion_icon);
		case EnvoyPromo:
			return context.getResources().getDrawable(R.drawable.envoy_icon);
		case GovernorPromo:
			return context.getResources().getDrawable(R.drawable.governor_icon);
		case Hinterlands:
			return context.getResources().getDrawable(R.drawable.hinterlands_icon);
		case Intrigue:
			return context.getResources().getDrawable(R.drawable.intrigue_icon);
		case Prosperity:
			return context.getResources().getDrawable(R.drawable.prosperity_icon);
		case Seaside:
			return context.getResources().getDrawable(R.drawable.seaside_icon);
		case StashPromo:
			return context.getResources().getDrawable(R.drawable.stash_icon);
		case WalledVillagePromo:
			return context.getResources().getDrawable(R.drawable.walledvillage_icon);
		default:
			return null;
		}
	}
}
