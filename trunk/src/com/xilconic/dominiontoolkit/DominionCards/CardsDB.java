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
	public static class Basic {
		public static final DominionSet Set = DominionSet.Basic;
		public static final DominionCard Copper = new DominionCardBuilder(DominionItemType.Copper, Set, 0).treasure().create();
		public static final DominionCard Silver = new DominionCardBuilder(DominionItemType.Silver, Set, 3).treasure().create();
		public static final DominionCard Gold = new DominionCardBuilder(DominionItemType.Gold, Set, 6).treasure().create();
		
		public static final DominionCard Estate = new DominionCardBuilder(DominionItemType.Estate, Set, 2).victory().create();
		public static final DominionCard Duchy = new DominionCardBuilder(DominionItemType.Duchy, Set, 5).victory().create();
		public static final DominionCard Province = new DominionCardBuilder(DominionItemType.Province, Set, 8).victory().create();
		
		public static final DominionCard Curse = new DominionCardBuilder(DominionItemType.Curse, Set, 0).curse().create();
	}
	public static ArrayList<DominionGameItem> nonKingdomCards = new ArrayList<DominionGameItem>();
	
	public static class Dominion {
		public static final DominionSet Set = DominionSet.Dominion;
		
		public static final DominionCard Cellar = new DominionCardBuilder(DominionItemType.Cellar, Set, 2).action().create();
		public static final DominionCard Chapel = new DominionCardBuilder(DominionItemType.Chapel, Set, 2).action().create();
		public static final DominionCard Moat = new DominionCardBuilder(DominionItemType.Moat, Set, 2).action().reaction().create();
		
		public static final DominionCard Chancellor = new DominionCardBuilder(DominionItemType.Chancellor, Set, 3).action().create();
		public static final DominionCard Village = new DominionCardBuilder(DominionItemType.Village, Set, 3).action().create();
		public static final DominionCard Woodcutter = new DominionCardBuilder(DominionItemType.Woodcutter, Set, 3).action().create();
		public static final DominionCard Workshop = new DominionCardBuilder(DominionItemType.Worshop, Set, 3).action().create();
		
		public static final DominionCard Bureaucrat = new DominionCardBuilder(DominionItemType.Bureaucrat, Set, 4).action().attack().create();
		public static final DominionCard Feast = new DominionCardBuilder(DominionItemType.Feast, Set, 4).action().create();
		public static final DominionCard Gardens = new DominionCardBuilder(DominionItemType.Gardens, Set, 4).victory().create();
		public static final DominionCard Militia = new DominionCardBuilder(DominionItemType.Militia, Set, 4).action().attack().create();
		public static final DominionCard Moneylender = new DominionCardBuilder(DominionItemType.Moneylender, Set, 4).action().create();
		public static final DominionCard Remodel = new DominionCardBuilder(DominionItemType.Remodel, Set, 4).action().create();
		public static final DominionCard Smithy = new DominionCardBuilder(DominionItemType.Smithy, Set, 4).action().create();
		public static final DominionCard Spy = new DominionCardBuilder(DominionItemType.Spy, Set, 4).action().attack().create();
		public static final DominionCard Thief = new DominionCardBuilder(DominionItemType.Thief, Set, 4).action().attack().create();
		public static final DominionCard ThroneRoom = new DominionCardBuilder(DominionItemType.ThroneRoom, Set, 4).action().create();
		
		public static final DominionCard CouncilRoom = new DominionCardBuilder(DominionItemType.CouncilRoom, Set, 5).action().create();
		public static final DominionCard Festival = new DominionCardBuilder(DominionItemType.Festival, Set, 5).action().create();
		public static final DominionCard Laboratory = new DominionCardBuilder(DominionItemType.Laboratory, Set, 5).action().create();
		public static final DominionCard Library = new DominionCardBuilder(DominionItemType.Library, Set, 5).action().create();
		public static final DominionCard Market = new DominionCardBuilder(DominionItemType.Market, Set, 5).action().create();
		public static final DominionCard Mine = new DominionCardBuilder(DominionItemType.Mine, Set, 5).action().create();
		public static final DominionCard Witch = new DominionCardBuilder(DominionItemType.Witch, Set, 5).action().attack().create();
		
		public static final DominionCard Adventurer = new DominionCardBuilder(DominionItemType.Adventurer, Set, 6).action().create();
	}
	public static ArrayList<DominionCard> dominionCards = new ArrayList<DominionCard>(25);
	
	public static class Intrigue {
		public static final DominionSet Set = DominionSet.Intrigue;
		
		public static final DominionCard Courtyard = new DominionCardBuilder(DominionItemType.Courtyard, Set, 2).action().create();
		public static final DominionCard Pawn = new DominionCardBuilder(DominionItemType.Pawn, Set, 2).action().create();
		public static final DominionCard SecretChamber = new DominionCardBuilder(DominionItemType.SecretChamber, Set, 2).action().reaction().create();
		
		public static final DominionCard GreatHall = new DominionCardBuilder(DominionItemType.GreatHall, Set, 3).action().victory().create();
		public static final DominionCard Masquerade = new DominionCardBuilder(DominionItemType.Masquerade, Set, 3).action().create();
		public static final DominionCard ShantyTown = new DominionCardBuilder(DominionItemType.ShantyTown, Set, 3).action().create();
		public static final DominionCard Steward = new DominionCardBuilder(DominionItemType.Steward, Set, 3).action().create();
		public static final DominionCard Swindler = new DominionCardBuilder(DominionItemType.Swindler, Set, 3).action().attack().create();
		public static final DominionCard WishingWell = new DominionCardBuilder(DominionItemType.WishingWell, Set, 3).action().create();
		
		public static final DominionCard Baron = new DominionCardBuilder(DominionItemType.Baron, Set, 4).action().create();
		public static final DominionCard Bridge = new DominionCardBuilder(DominionItemType.Bridge, Set, 4).action().create();
		public static final DominionCard Conspirator = new DominionCardBuilder(DominionItemType.Conspirator, Set, 4).action().create();
		public static final DominionCard Coppersmith = new DominionCardBuilder(DominionItemType.Coppersmith, Set, 4).action().create();
		public static final DominionCard Ironworks = new DominionCardBuilder(DominionItemType.Ironworks, Set, 4).action().create();
		public static final DominionCard MiningVillage = new DominionCardBuilder(DominionItemType.MiningVillage, Set, 4).action().create();
		public static final DominionCard Scout = new DominionCardBuilder(DominionItemType.Scout, Set, 4).action().create();
		
		public static final DominionCard Duke = new DominionCardBuilder(DominionItemType.Duke, Set, 5).victory().create();
		public static final DominionCard Minion = new DominionCardBuilder(DominionItemType.Minion, Set, 5).action().attack().create();
		public static final DominionCard Saboteur = new DominionCardBuilder(DominionItemType.Saboteur, Set, 5).action().attack().create();
		public static final DominionCard Torturer = new DominionCardBuilder(DominionItemType.Torturer, Set, 5).action().attack().create();
		public static final DominionCard TradingPost = new DominionCardBuilder(DominionItemType.TradingPost, Set, 5).action().create();
		public static final DominionCard Tribute = new DominionCardBuilder(DominionItemType.Tribute, Set, 5).action().create();
		public static final DominionCard Upgrade = new DominionCardBuilder(DominionItemType.Upgrade, Set, 5).action().create();
		
		public static final DominionCard Harem = new DominionCardBuilder(DominionItemType.Harem, Set, 6).treasure().victory().create();
		public static final DominionCard Nobles = new DominionCardBuilder(DominionItemType.Nobles, Set, 6).action().victory().create();
	}
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
		nonKingdomCards.add(Basic.Copper);
		nonKingdomCards.add(Basic.Silver);
		nonKingdomCards.add(Basic.Gold);
		
		nonKingdomCards.add(Basic.Estate);
		nonKingdomCards.add(Basic.Duchy);
		nonKingdomCards.add(Basic.Province);
		
		nonKingdomCards.add(Basic.Curse);
	}
	
	private static void createBaseDominionCards(){
		dominionCards.add(Dominion.Cellar);
		dominionCards.add(Dominion.Chapel);
		dominionCards.add(Dominion.Moat);
		
		dominionCards.add(Dominion.Chancellor);
		dominionCards.add(Dominion.Village);
		dominionCards.add(Dominion.Woodcutter);
		dominionCards.add(Dominion.Workshop);
		
		dominionCards.add(Dominion.Bureaucrat);
		dominionCards.add(Dominion.Feast);
		dominionCards.add(Dominion.Gardens);
		dominionCards.add(Dominion.Militia);
		dominionCards.add(Dominion.Moneylender);
		dominionCards.add(Dominion.Remodel);
		dominionCards.add(Dominion.Smithy);
		dominionCards.add(Dominion.Spy);
		dominionCards.add(Dominion.Thief);
		dominionCards.add(Dominion.ThroneRoom);
		
		dominionCards.add(Dominion.CouncilRoom);
		dominionCards.add(Dominion.Festival);
		dominionCards.add(Dominion.Laboratory);
		dominionCards.add(Dominion.Library);
		dominionCards.add(Dominion.Market);
		dominionCards.add(Dominion.Mine);
		dominionCards.add(Dominion.Witch);
		
		dominionCards.add(Dominion.Adventurer);
	}
	
	private static void createIntrigueCards(){
		intrigueCards.add(Intrigue.Courtyard);
		intrigueCards.add(Intrigue.Pawn);
		intrigueCards.add(Intrigue.SecretChamber);
		
		intrigueCards.add(Intrigue.GreatHall);
		intrigueCards.add(Intrigue.Masquerade);
		intrigueCards.add(Intrigue.ShantyTown);
		intrigueCards.add(Intrigue.Steward);
		intrigueCards.add(Intrigue.Swindler);
		intrigueCards.add(Intrigue.WishingWell);
		
		intrigueCards.add(Intrigue.Baron);
		intrigueCards.add(Intrigue.Bridge);
		intrigueCards.add(Intrigue.Conspirator);
		intrigueCards.add(Intrigue.Coppersmith);
		intrigueCards.add(Intrigue.Ironworks);
		intrigueCards.add(Intrigue.MiningVillage);
		intrigueCards.add(Intrigue.Scout);
		
		intrigueCards.add(Intrigue.Duke);
		intrigueCards.add(Intrigue.Minion);
		intrigueCards.add(Intrigue.Saboteur);
		intrigueCards.add(Intrigue.Torturer);
		intrigueCards.add(Intrigue.TradingPost);
		intrigueCards.add(Intrigue.Tribute);
		intrigueCards.add(Intrigue.Upgrade);
		
		intrigueCards.add(Intrigue.Harem);
		intrigueCards.add(Intrigue.Nobles);
	}
}
