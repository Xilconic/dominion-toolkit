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
			return context.getResources().getString(R.string.Cards_Base_Koper);
		case Silver:
			return context.getResources().getString(R.string.Cards_Base_Zilver);
		case Gold:
			return context.getResources().getString(R.string.Cards_Base_Goud);
		case Estate:
			return context.getResources().getString(R.string.Cards_Base_Landgoed);
		case Duchy:
			return context.getResources().getString(R.string.Cards_Base_Hertogdom);
		case Province:
			return context.getResources().getString(R.string.Cards_Base_Provincie);
		case Curse:
			return context.getResources().getString(R.string.Cards_Base_Vloek);
		default:
			return "<no basic name matched>";
		}
	}
	
	private static String getBaseDominionSetName(Context context, DominionCard card) {
		switch (card.get_id()) {
		case Cellar:
			return context.getResources().getString(R.string.Cards_Dominion_Kelder);
		case Chapel:
			return context.getResources().getString(R.string.Cards_Dominion_Kapel);
		case Moat:
			return context.getResources().getString(R.string.Cards_Dominion_Slotgracht);
			
		case Chancellor:
			return context.getResources().getString(R.string.Cards_Dominion_Raadsheer);
		case Village:
			return context.getResources().getString(R.string.Cards_Dominion_Dorp);
		case Woodcutter:
			return context.getResources().getString(R.string.Cards_Dominion_Houthakker);
		case Worshop:
			return context.getResources().getString(R.string.Cards_Dominion_Werkplaats);
			
		case Bureaucrat:
			return context.getResources().getString(R.string.Cards_Dominion_Bureaucraat);
		case Feast:
			return context.getResources().getString(R.string.Cards_Dominion_Feest);
		case Gardens:
			return context.getResources().getString(R.string.Cards_Dominion_Tuinen);
		case Militia:
			return context.getResources().getString(R.string.Cards_Dominion_Militie);
		case Moneylender:
			return context.getResources().getString(R.string.Cards_Dominion_Geldschieter);
		case Remodel:
			return context.getResources().getString(R.string.Cards_Dominion_Verbouwing);
		case Smithy:
			return context.getResources().getString(R.string.Cards_Dominion_Smidse);
		case Spy:
			return context.getResources().getString(R.string.Cards_Dominion_Spion);
		case Thief:
			return context.getResources().getString(R.string.Cards_Dominion_Dief);
		case ThroneRoom:
			return context.getResources().getString(R.string.Cards_Dominion_Troonzaal);
			
		case CouncilRoom:
			return context.getResources().getString(R.string.Cards_Dominion_Raadzaal);
		case Festival:
			return context.getResources().getString(R.string.Cards_Dominion_Festival);
		case Laboratory:
			return context.getResources().getString(R.string.Cards_Dominion_Laboratorium);
		case Library:
			return context.getResources().getString(R.string.Cards_Dominion_Bibliotheek);
		case Market:
			return context.getResources().getString(R.string.Cards_Dominion_Markt);
		case Mine:
			return context.getResources().getString(R.string.Cards_Dominion_Mijn);
		case Witch:
			return context.getResources().getString(R.string.Cards_Dominion_Heks);
			
		case Adventurer:
			return context.getResources().getString(R.string.Cards_Dominion_Avonturier);
		default:
			return "<no base dominion name matched>";
		}
	}
	
	private static String getIntrigueSetName(Context context, DominionCard card) {
		switch (card.get_id()) {
		case Courtyard:
			return context.getResources().getString(R.string.Cards_Intrigue_Binneplaats);
		case Pawn:
			return context.getResources().getString(R.string.Cards_Intrigue_Pion);
		case SecretChamber:
			return context.getResources().getString(R.string.Cards_Intrigue_Geheime_Kamer);

		case GreatHall:
			return context.getResources().getString(R.string.Cards_Intrigue_Grote_Zaal);
		case Masquerade:
			return context.getResources().getString(R.string.Cards_Intrigue_Maskerade);
		case ShantyTown:
			return context.getResources().getString(R.string.Cards_Intrigue_Sloppenwijk);
		case Steward:
			return context.getResources().getString(R.string.Cards_Intrigue_Lakei);
		case Swindler:
			return context.getResources().getString(R.string.Cards_Intrigue_Oplichter);
		case WishingWell:
			return context.getResources().getString(R.string.Cards_Intrigue_Wensput);

		case Baron:
			return context.getResources().getString(R.string.Cards_Intrigue_Baron);
		case Bridge:
			return context.getResources().getString(R.string.Cards_Intrigue_Brug);
		case Conspirator:
			return context.getResources().getString(R.string.Cards_Intrigue_Samenzweerder);
		case Coppersmith:
			return context.getResources().getString(R.string.Cards_Intrigue_Kopersmid);
		case Ironworks:
			return context.getResources().getString(R.string.Cards_Intrigue_IJzergieterij);
		case MiningVillage:
			return context.getResources().getString(R.string.Cards_Intrigue_Mijndorp);
		case Scout:
			return context.getResources().getString(R.string.Cards_Intrigue_Verkenner);

		case Duke:
			return context.getResources().getString(R.string.Cards_Intrigue_Hertog);
		case Minion:
			return context.getResources().getString(R.string.Cards_Intrigue_Dienaar);
		case Saboteur:
			return context.getResources().getString(R.string.Cards_Intrigue_Saboteur);
		case Torturer:
			return context.getResources().getString(R.string.Cards_Intrigue_Folteraar);
		case TradingPost:
			return context.getResources().getString(R.string.Cards_Intrigue_Handelspost);
		case Tribute:
			return context.getResources().getString(R.string.Cards_Intrigue_Tolheffing);
		case Upgrade:
			return context.getResources().getString(R.string.Cards_Intrigue_Opwaardering);

		case Harem:
			return context.getResources().getString(R.string.Cards_Intrigue_Harem);
		case Nobles:
			return context.getResources().getString(R.string.Cards_Intrigue_Adel);
		default:
			return "<no intrigue name matched>";
		}
	}
}
