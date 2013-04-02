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
package com.xilconic.dominiontoolkit.DominionCards;

import java.util.ArrayList;
import java.util.List;

public class CardsDB {
	public static ArrayList<DominionGameItem> nonKingdomCards = new ArrayList<DominionGameItem>();
	public static ArrayList<DominionCard> dominionCards = new ArrayList<DominionCard>(25);
	public static ArrayList<DominionCard> intrigueCards = new ArrayList<DominionCard>(25);
	
	public static ArrayList<DominionCard> getAllCardsFromSets(List<DominionSet> sets){
		ArrayList<DominionCard> allCards = new ArrayList<DominionCard>();
		for (DominionSet set : sets) {
			switch(set){
			case Dominion:
				allCards.addAll(dominionCards);
				break;
			case Intrigue:
				allCards.addAll(intrigueCards);
				break;
			}
		}
		return allCards;
	}

	static {
		createBasicCards();
		createBaseDominionCards();
		createIntrigueCards();
	}
	
	private static void createBasicCards(){
		nonKingdomCards.add(new DominionCardBuilder(DominionItemType.Copper, DominionSet.Basic, 0).treasure().create());
		nonKingdomCards.add(new DominionCardBuilder(DominionItemType.Silver, DominionSet.Basic, 3).treasure().create());
		nonKingdomCards.add(new DominionCardBuilder(DominionItemType.Gold, DominionSet.Basic, 6).treasure().create());
		
		nonKingdomCards.add(new DominionCardBuilder(DominionItemType.Estate, DominionSet.Basic, 0).victory().create());
		nonKingdomCards.add(new DominionCardBuilder(DominionItemType.Duchy, DominionSet.Basic, 0).victory().create());
		nonKingdomCards.add(new DominionCardBuilder(DominionItemType.Province, DominionSet.Basic, 0).victory().create());
		
		nonKingdomCards.add(new DominionCardBuilder(DominionItemType.Curse, DominionSet.Basic, 0).curse().create());
	}
	
	private static void createBaseDominionCards(){
		dominionCards.add(new DominionCardBuilder(DominionItemType.Cellar, DominionSet.Dominion, 2).action().create());
		dominionCards.add(new DominionCardBuilder(DominionItemType.Chapel, DominionSet.Dominion, 2).action().create());
		dominionCards.add(new DominionCardBuilder(DominionItemType.Moat, DominionSet.Dominion, 2).action().reaction().create());
		
		dominionCards.add(new DominionCardBuilder(DominionItemType.Chancellor, DominionSet.Dominion, 3).action().create());
		dominionCards.add(new DominionCardBuilder(DominionItemType.Village, DominionSet.Dominion, 3).action().create());
		dominionCards.add(new DominionCardBuilder(DominionItemType.Woodcutter, DominionSet.Dominion, 3).action().create());
		dominionCards.add(new DominionCardBuilder(DominionItemType.Worshop, DominionSet.Dominion, 3).action().create());
		
		dominionCards.add(new DominionCardBuilder(DominionItemType.Bureaucrat, DominionSet.Dominion, 4).action().attack().create());
		dominionCards.add(new DominionCardBuilder(DominionItemType.Feast, DominionSet.Dominion, 4).action().create());
		dominionCards.add(new DominionCardBuilder(DominionItemType.Gardens, DominionSet.Dominion, 4).victory().create());
		dominionCards.add(new DominionCardBuilder(DominionItemType.Militia, DominionSet.Dominion, 4).action().attack().create());
		dominionCards.add(new DominionCardBuilder(DominionItemType.Moneylender, DominionSet.Dominion, 4).action().create());
		dominionCards.add(new DominionCardBuilder(DominionItemType.Remodel, DominionSet.Dominion, 4).action().create());
		dominionCards.add(new DominionCardBuilder(DominionItemType.Smithy, DominionSet.Dominion, 4).action().create());
		dominionCards.add(new DominionCardBuilder(DominionItemType.Spy, DominionSet.Dominion, 4).action().attack().create());
		dominionCards.add(new DominionCardBuilder(DominionItemType.Thief, DominionSet.Dominion, 4).action().attack().create());
		dominionCards.add(new DominionCardBuilder(DominionItemType.ThroneRoom, DominionSet.Dominion, 4).action().create());
		
		dominionCards.add(new DominionCardBuilder(DominionItemType.CouncilRoom, DominionSet.Dominion, 5).action().create());
		dominionCards.add(new DominionCardBuilder(DominionItemType.Festival, DominionSet.Dominion, 5).action().create());
		dominionCards.add(new DominionCardBuilder(DominionItemType.Laboratory, DominionSet.Dominion, 5).action().create());
		dominionCards.add(new DominionCardBuilder(DominionItemType.Library, DominionSet.Dominion, 5).action().create());
		dominionCards.add(new DominionCardBuilder(DominionItemType.Market, DominionSet.Dominion, 5).action().create());
		dominionCards.add(new DominionCardBuilder(DominionItemType.Mine, DominionSet.Dominion, 5).action().create());
		dominionCards.add(new DominionCardBuilder(DominionItemType.Witch, DominionSet.Dominion, 5).action().attack().create());
		
		dominionCards.add(new DominionCardBuilder(DominionItemType.Adventurer, DominionSet.Dominion, 6).action().create());
	}
	
	private static void createIntrigueCards(){
		intrigueCards.add(new DominionCardBuilder(DominionItemType.Courtyard, DominionSet.Intrigue, 2).action().create());
		intrigueCards.add(new DominionCardBuilder(DominionItemType.Pawn, DominionSet.Intrigue, 2).action().create());
		intrigueCards.add(new DominionCardBuilder(DominionItemType.SecretChamber, DominionSet.Intrigue, 2).action().reaction().create());
		
		intrigueCards.add(new DominionCardBuilder(DominionItemType.GreatHall, DominionSet.Intrigue, 3).action().victory().create());
		intrigueCards.add(new DominionCardBuilder(DominionItemType.Masquerade, DominionSet.Intrigue, 3).action().create());
		intrigueCards.add(new DominionCardBuilder(DominionItemType.ShantyTown, DominionSet.Intrigue, 3).action().create());
		intrigueCards.add(new DominionCardBuilder(DominionItemType.Steward, DominionSet.Intrigue, 3).action().create());
		intrigueCards.add(new DominionCardBuilder(DominionItemType.Swindler, DominionSet.Intrigue, 3).action().attack().create());
		intrigueCards.add(new DominionCardBuilder(DominionItemType.WishingWell, DominionSet.Intrigue, 3).action().create());
		
		intrigueCards.add(new DominionCardBuilder(DominionItemType.Baron, DominionSet.Intrigue, 4).action().create());
		intrigueCards.add(new DominionCardBuilder(DominionItemType.Bridge, DominionSet.Intrigue, 4).action().create());
		intrigueCards.add(new DominionCardBuilder(DominionItemType.Conspirator, DominionSet.Intrigue, 4).action().create());
		intrigueCards.add(new DominionCardBuilder(DominionItemType.Coppersmith, DominionSet.Intrigue, 4).action().create());
		intrigueCards.add(new DominionCardBuilder(DominionItemType.Ironworks, DominionSet.Intrigue, 4).action().create());
		intrigueCards.add(new DominionCardBuilder(DominionItemType.MiningVillage, DominionSet.Intrigue, 4).action().create());
		intrigueCards.add(new DominionCardBuilder(DominionItemType.Scout, DominionSet.Intrigue, 4).action().create());
		
		intrigueCards.add(new DominionCardBuilder(DominionItemType.Duke, DominionSet.Intrigue, 5).victory().create());
		intrigueCards.add(new DominionCardBuilder(DominionItemType.Minion, DominionSet.Intrigue, 5).action().attack().create());
		intrigueCards.add(new DominionCardBuilder(DominionItemType.Saboteur, DominionSet.Intrigue, 5).action().attack().create());
		intrigueCards.add(new DominionCardBuilder(DominionItemType.Torturer, DominionSet.Intrigue, 5).action().attack().create());
		intrigueCards.add(new DominionCardBuilder(DominionItemType.TradingPost, DominionSet.Intrigue, 5).action().create());
		intrigueCards.add(new DominionCardBuilder(DominionItemType.Tribute, DominionSet.Intrigue, 5).action().create());
		intrigueCards.add(new DominionCardBuilder(DominionItemType.Upgrade, DominionSet.Intrigue, 5).action().create());
		
		intrigueCards.add(new DominionCardBuilder(DominionItemType.Harem, DominionSet.Intrigue, 6).treasure().victory().create());
		intrigueCards.add(new DominionCardBuilder(DominionItemType.Nobles, DominionSet.Intrigue, 6).action().victory().create());
	}
}
