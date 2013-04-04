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
package com.xilconic.dominiontoolkit.Utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.xilconic.dominiontoolkit.R;
import com.xilconic.dominiontoolkit.DominionCards.DominionCard;
import com.xilconic.dominiontoolkit.DominionCards.DominionGameItem;
import com.xilconic.dominiontoolkit.DominionCards.DominionSet;

public class ResourcesHelper {

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
	
	public static String GetDominionItemName(Context context, DominionGameItem item){
		if (item instanceof DominionCard){
			return GetDominionCardName(context, (DominionCard)item);
		}
		return "<no item matched>";
	}
	
	public static String GetDominionCardName(Context context, DominionCard card){
		switch (card.get_dominionSet()) {
		case Basic:
			return getBasicSetName(context, card);
		case Dominion:
			return getBaseDominionSetName(context, card);
		case Intrigue:
			return getIntrigueSetName(context, card);
		default:
			return "<no card set matched>";
		}
	}

	private static String getBasicSetName(Context context, DominionCard card) {
		switch (card.get_id()) {
		case Copper:
			return context.getResources().getString(R.string.Cards_Base_Copper);
		case Silver:
			return context.getResources().getString(R.string.Cards_Base_Silver);
		case Gold:
			return context.getResources().getString(R.string.Cards_Base_Gold);
		case Estate:
			return context.getResources().getString(R.string.Cards_Base_Estate);
		case Duchy:
			return context.getResources().getString(R.string.Cards_Base_Duchy);
		case Province:
			return context.getResources().getString(R.string.Cards_Base_Province);
		case Curse:
			return context.getResources().getString(R.string.Cards_Base_Curse);
		default:
			return "<no basic name matched>";
		}
	}
	
	private static String getBaseDominionSetName(Context context, DominionCard card) {
		switch (card.get_id()) {
		case Cellar:
			return context.getResources().getString(R.string.Cards_Dominion_Cellar);
		case Chapel:
			return context.getResources().getString(R.string.Cards_Dominion_Chapel);
		case Moat:
			return context.getResources().getString(R.string.Cards_Dominion_Moat);
			
		case Chancellor:
			return context.getResources().getString(R.string.Cards_Dominion_Chancellor);
		case Village:
			return context.getResources().getString(R.string.Cards_Dominion_Village);
		case Woodcutter:
			return context.getResources().getString(R.string.Cards_Dominion_Woodcutter);
		case Worshop:
			return context.getResources().getString(R.string.Cards_Dominion_Workshop);
			
		case Bureaucrat:
			return context.getResources().getString(R.string.Cards_Dominion_Bureaucrat);
		case Feast:
			return context.getResources().getString(R.string.Cards_Dominion_Feast);
		case Gardens:
			return context.getResources().getString(R.string.Cards_Dominion_Gardens);
		case Militia:
			return context.getResources().getString(R.string.Cards_Dominion_Militia);
		case Moneylender:
			return context.getResources().getString(R.string.Cards_Dominion_Moneylender);
		case Remodel:
			return context.getResources().getString(R.string.Cards_Dominion_Remodel);
		case Smithy:
			return context.getResources().getString(R.string.Cards_Dominion_Smithy);
		case Spy:
			return context.getResources().getString(R.string.Cards_Dominion_Spy);
		case Thief:
			return context.getResources().getString(R.string.Cards_Dominion_Thief);
		case ThroneRoom:
			return context.getResources().getString(R.string.Cards_Dominion_ThroneRoom);
			
		case CouncilRoom:
			return context.getResources().getString(R.string.Cards_Dominion_CouncilRoom);
		case Festival:
			return context.getResources().getString(R.string.Cards_Dominion_Festival);
		case Laboratory:
			return context.getResources().getString(R.string.Cards_Dominion_Laboratory);
		case Library:
			return context.getResources().getString(R.string.Cards_Dominion_Library);
		case Market:
			return context.getResources().getString(R.string.Cards_Dominion_Market);
		case Mine:
			return context.getResources().getString(R.string.Cards_Dominion_Mine);
		case Witch:
			return context.getResources().getString(R.string.Cards_Dominion_Witch);
			
		case Adventurer:
			return context.getResources().getString(R.string.Cards_Dominion_Adventurer);
		default:
			return "<no base dominion name matched>";
		}
	}
	
	private static String getIntrigueSetName(Context context, DominionCard card) {
		switch (card.get_id()) {
		case Courtyard:
			return context.getResources().getString(R.string.Cards_Intrigue_Courtyard);
		case Pawn:
			return context.getResources().getString(R.string.Cards_Intrigue_Pawn);
		case SecretChamber:
			return context.getResources().getString(R.string.Cards_Intrigue_SecretChamber);

		case GreatHall:
			return context.getResources().getString(R.string.Cards_Intrigue_GreatHall);
		case Masquerade:
			return context.getResources().getString(R.string.Cards_Intrigue_Masquerade);
		case ShantyTown:
			return context.getResources().getString(R.string.Cards_Intrigue_ShantyTown);
		case Steward:
			return context.getResources().getString(R.string.Cards_Intrigue_Steward);
		case Swindler:
			return context.getResources().getString(R.string.Cards_Intrigue_Swindler);
		case WishingWell:
			return context.getResources().getString(R.string.Cards_Intrigue_WishingWell);

		case Baron:
			return context.getResources().getString(R.string.Cards_Intrigue_Baron);
		case Bridge:
			return context.getResources().getString(R.string.Cards_Intrigue_Bridge);
		case Conspirator:
			return context.getResources().getString(R.string.Cards_Intrigue_Conspirator);
		case Coppersmith:
			return context.getResources().getString(R.string.Cards_Intrigue_Coppersmith);
		case Ironworks:
			return context.getResources().getString(R.string.Cards_Intrigue_Ironworks);
		case MiningVillage:
			return context.getResources().getString(R.string.Cards_Intrigue_MiningVillage);
		case Scout:
			return context.getResources().getString(R.string.Cards_Intrigue_Scout);

		case Duke:
			return context.getResources().getString(R.string.Cards_Intrigue_Duke);
		case Minion:
			return context.getResources().getString(R.string.Cards_Intrigue_Minion);
		case Saboteur:
			return context.getResources().getString(R.string.Cards_Intrigue_Saboteur);
		case Torturer:
			return context.getResources().getString(R.string.Cards_Intrigue_Torturer);
		case TradingPost:
			return context.getResources().getString(R.string.Cards_Intrigue_Tradingpost);
		case Tribute:
			return context.getResources().getString(R.string.Cards_Intrigue_Tribute);
		case Upgrade:
			return context.getResources().getString(R.string.Cards_Intrigue_Upgrade);

		case Harem:
			return context.getResources().getString(R.string.Cards_Intrigue_Harem);
		case Nobles:
			return context.getResources().getString(R.string.Cards_Intrigue_Nobles);
		default:
			return "<no intrigue name matched>";
		}
	}
}
