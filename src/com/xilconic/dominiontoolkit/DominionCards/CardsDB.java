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
	
	public static class Cornucopia{
	    public static final DominionSet Set = DominionSet.Cornucopia;
	    
	    public static final DominionCard Hamlet = new DominionCardBuilder(DominionItemType.Hamlet, Set, 2).action().create();
	    
	    public static final DominionCard FortuneTeller = new DominionCardBuilder(DominionItemType.FortuneTeller, Set, 3).action().attack().create();
	    public static final DominionCard Menagerie = new DominionCardBuilder(DominionItemType.Menagerie, Set, 3).action().create();
	    
	    public static final DominionCard FarmingVillage = new DominionCardBuilder(DominionItemType.FarmingVillage, Set, 4).action().create();
	    public static final DominionCard HorseTraders = new DominionCardBuilder(DominionItemType.HorseTraders, Set, 4).action().reaction().create();
	    public static final DominionCard Remake = new DominionCardBuilder(DominionItemType.Remake, Set, 4).action().create();
	    public static final DominionCard Tournament = new DominionCardBuilder(DominionItemType.Tournament, Set, 4).action().create();
	    public static final DominionCard YoungWitch = new DominionCardBuilder(DominionItemType.YoungWitch, Set, 4).action().attack().create();
	    
	    public static final DominionCard Harvest = new DominionCardBuilder(DominionItemType.Harvest, Set, 5).action().create();
	    public static final DominionCard HornOfPlenty = new DominionCardBuilder(DominionItemType.HornOfPlenty, Set, 5).treasure().create();
	    public static final DominionCard HuntingParty = new DominionCardBuilder(DominionItemType.HuntingParty, Set, 5).action().create();
	    public static final DominionCard Jester = new DominionCardBuilder(DominionItemType.Jester, Set, 5).action().attack().create();
	    
	    public static final DominionCard Fairgrounds = new DominionCardBuilder(DominionItemType.Fairgrounds, Set, 6).victory().create();
	    
	    // Prizes:
	    /**
	     * Retrieves all prize cards to be used with {@link Tournament}.
	     * @return A new list with all prizecards.
	     */
	    public static ArrayList<DominionCard> getPrizeCards(){
	        ArrayList<DominionCard> prizes = new ArrayList<DominionCard>();
	        prizes.add(BagOfGold);
	        prizes.add(Diadem);
	        prizes.add(Followers);
	        prizes.add(Princess);
	        prizes.add(TrustySteed);
	        return prizes;
	    }
	    public static final DominionCard BagOfGold = new DominionCardBuilder(DominionItemType.BagOfGold, Set, 0).action().create();
	    public static final DominionCard Diadem = new DominionCardBuilder(DominionItemType.Diadem, Set, 0).treasure().create();
	    public static final DominionCard Followers = new DominionCardBuilder(DominionItemType.Followers, Set, 0).action().attack().create();
	    public static final DominionCard Princess = new DominionCardBuilder(DominionItemType.Princess, Set, 0).action().create();
	    public static final DominionCard TrustySteed = new DominionCardBuilder(DominionItemType.TrustySteed, Set, 0).action().create();
	}
	public static ArrayList<DominionCard> cornucopiaCards = new ArrayList<DominionCard>(13);
	
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
	
	public static class Prosperity{
		public static final DominionSet Set = DominionSet.Prosperity;
		
		public static final DominionCard Colony = new DominionCardBuilder(DominionItemType.Colony, Set, 11).victory().create();
		public static final DominionCard Platinum = new DominionCardBuilder(DominionItemType.Platinum, Set, 9).treasure().create();
		
		public static final DominionCard Loan = new DominionCardBuilder(DominionItemType.Loan, Set, 3).action().create();
		public static final DominionCard TradeRoute = new DominionCardBuilder(DominionItemType.TradeRoute, Set, 3).action().create();
		public static final DominionCard Watchtower = new DominionCardBuilder(DominionItemType.Watchtower, Set, 3).action().reaction().create();
		
		public static final DominionCard Bishop = new DominionCardBuilder(DominionItemType.Bishop, Set, 4).action().create();
		public static final DominionCard Monument = new DominionCardBuilder(DominionItemType.Monument, Set, 4).action().create();
		public static final DominionCard Quarry = new DominionCardBuilder(DominionItemType.Quarry, Set, 4).treasure().create();
		public static final DominionCard Talisman = new DominionCardBuilder(DominionItemType.Talisman, Set, 4).treasure().create();
		public static final DominionCard WorkersVillage = new DominionCardBuilder(DominionItemType.WorkersVillage, Set, 4).action().create();
		
		public static final DominionCard City = new DominionCardBuilder(DominionItemType.City, Set, 5).action().create();
		public static final DominionCard Contraband = new DominionCardBuilder(DominionItemType.Contraband, Set, 5).treasure().create();
		public static final DominionCard CountingHouse = new DominionCardBuilder(DominionItemType.CountingHouse, Set, 5).action().create();
		public static final DominionCard Mint = new DominionCardBuilder(DominionItemType.Mint, Set, 5).action().create();
		public static final DominionCard Mountebank = new DominionCardBuilder(DominionItemType.Mountebank, Set, 5).action().attack().create();
		public static final DominionCard Rabble = new DominionCardBuilder(DominionItemType.Rabble, Set, 5).action().attack().create();
		public static final DominionCard RoyalSeal = new DominionCardBuilder(DominionItemType.RoyalSeal, Set, 5).treasure().create();
		public static final DominionCard Vault = new DominionCardBuilder(DominionItemType.Vault, Set, 5).action().create();
		public static final DominionCard Venture = new DominionCardBuilder(DominionItemType.Venture, Set, 5).treasure().create();
		
		public static final DominionCard Goons = new DominionCardBuilder(DominionItemType.Goons, Set, 6).action().attack().create();
		public static final DominionCard GrandMarket = new DominionCardBuilder(DominionItemType.GrandMarket, Set, 6).action().create();
		public static final DominionCard Hoard = new DominionCardBuilder(DominionItemType.Hoard, Set, 6).treasure().create();
		
		public static final DominionCard Bank = new DominionCardBuilder(DominionItemType.Bank, Set, 7).treasure().create();
		public static final DominionCard Expand = new DominionCardBuilder(DominionItemType.Expand, Set, 7).action().create();
		public static final DominionCard Forge = new DominionCardBuilder(DominionItemType.Forge, Set, 7).action().create();
		public static final DominionCard KingsCourt = new DominionCardBuilder(DominionItemType.KingsCourt, Set, 7).action().create();
		
		public static final DominionCard Peddler = new DominionCardBuilder(DominionItemType.Peddler, Set, 8).action().create();
		
		// Non-cards:
		public static final DominionGameItem TradeRouteMat = new DominionGameItem(DominionItemType.TradeRouteMat, null, Set);
        public static final DominionGameItem TradeRouteCoin = new DominionGameItem(DominionItemType.TradeRouteCoin, null, Set);
        public static final DominionGameItem VictoryTokenMat = new DominionGameItem(DominionItemType.VictoryTokenMat, null, Set);
        public static final DominionGameItem OneVictoryPointToken = new DominionGameItem(DominionItemType.OneVictoryPointToken, null, Set);
        public static final DominionGameItem FiveVictoryPointToken = new DominionGameItem(DominionItemType.FiveVictoryPointToken, null, Set);
	}
	public static ArrayList<DominionCard> prosperityCards = new ArrayList<DominionCard>(25);
	
	public static class Hinterlands{
		public static final DominionSet Set = DominionSet.Hinterlands;
		
		public static final DominionCard Crossroads = new DominionCardBuilder(DominionItemType.Crossroads, Set, 2).action().create();
		public static final DominionCard Duchess = new DominionCardBuilder(DominionItemType.Duchess, Set, 2).action().create();
		public static final DominionCard FoolsGold = new DominionCardBuilder(DominionItemType.FoolsGold, Set, 2).treasure().reaction().create();
		
		public static final DominionCard Develop = new DominionCardBuilder(DominionItemType.Develop, Set, 3).action().create();
		public static final DominionCard Oasis = new DominionCardBuilder(DominionItemType.Oasis, Set, 3).action().create();
		public static final DominionCard Oracle = new DominionCardBuilder(DominionItemType.Oracle, Set, 3).action().attack().create();
		public static final DominionCard Scheme = new DominionCardBuilder(DominionItemType.Scheme, Set, 3).action().create();
		public static final DominionCard Tunnel = new DominionCardBuilder(DominionItemType.Tunnel, Set, 3).victory().reaction().create();
		
		public static final DominionCard JackOfAllTrades = new DominionCardBuilder(DominionItemType.JackOfAllTrades, Set, 4).action().create();
		public static final DominionCard NobleBrigand = new DominionCardBuilder(DominionItemType.NobleBrigand, Set, 4).action().attack().create();
		public static final DominionCard NomadCamp = new DominionCardBuilder(DominionItemType.NomadCamp, Set, 4).action().create();
		public static final DominionCard SilkRoad = new DominionCardBuilder(DominionItemType.SilkRoad, Set, 4).victory().create();
		public static final DominionCard SpiceMerchant = new DominionCardBuilder(DominionItemType.SpiceMerchant, Set, 4).action().create();
		public static final DominionCard Trader = new DominionCardBuilder(DominionItemType.Trader, Set, 4).action().reaction().create();
		
		public static final DominionCard Cache = new DominionCardBuilder(DominionItemType.Cache, Set, 5).treasure().create();
		public static final DominionCard Cartographer = new DominionCardBuilder(DominionItemType.Cartographer, Set, 5).action().create();
		public static final DominionCard Embassy = new DominionCardBuilder(DominionItemType.Embassy, Set, 5).action().create();
		public static final DominionCard Haggler = new DominionCardBuilder(DominionItemType.Haggler, Set, 5).action().create();
		public static final DominionCard Highway = new DominionCardBuilder(DominionItemType.Highway, Set, 5).action().create();
		public static final DominionCard IllGottenGains = new DominionCardBuilder(DominionItemType.IllGottenGains, Set, 5).treasure().create();
		public static final DominionCard Inn = new DominionCardBuilder(DominionItemType.Inn, Set, 5).action().create();
		public static final DominionCard Mandarin = new DominionCardBuilder(DominionItemType.Mandarin, Set, 5).action().create();
		public static final DominionCard Margrave = new DominionCardBuilder(DominionItemType.Margrave, Set, 5).action().attack().create();
		public static final DominionCard Stables = new DominionCardBuilder(DominionItemType.Stables, Set, 5).action().create();
		
		public static final DominionCard BorderVillage = new DominionCardBuilder(DominionItemType.BorderVillage, Set, 6).action().create();
		public static final DominionCard Farmland = new DominionCardBuilder(DominionItemType.Farmland, Set, 6).victory().create();
	}
	public static ArrayList<DominionCard> hinterlandsCards = new ArrayList<DominionCard>(26);
	
	public static class Seaside{
	    public static final DominionSet Set = DominionSet.Seaside;
	    
	    public static final DominionCard Embargo = new DominionCardBuilder(DominionItemType.Embargo, Set, 2).action().create();
	    public static final DominionCard Haven = new DominionCardBuilder(DominionItemType.Haven, Set, 2).action().duration().create();
	    public static final DominionCard Lighthouse = new DominionCardBuilder(DominionItemType.Lighthouse, Set, 2).action().duration().create();
	    public static final DominionCard NativeVillage = new DominionCardBuilder(DominionItemType.NativeVillage, Set, 2).action().create();
	    public static final DominionCard PearlDiver = new DominionCardBuilder(DominionItemType.PearlDiver, Set, 2).action().create();
	    
	    public static final DominionCard Ambassador = new DominionCardBuilder(DominionItemType.Ambassador, Set, 3).action().attack().create();
	    public static final DominionCard FishingVillage = new DominionCardBuilder(DominionItemType.FishingVillage, Set, 3).action().duration().create();
	    public static final DominionCard Lookout = new DominionCardBuilder(DominionItemType.Lookout, Set, 3).action().create();
	    public static final DominionCard Smugglers = new DominionCardBuilder(DominionItemType.Smugglers, Set, 3).action().create();
	    public static final DominionCard Warehouse = new DominionCardBuilder(DominionItemType.Warehouse, Set, 3).action().create();
	    
	    public static final DominionCard Caravan = new DominionCardBuilder(DominionItemType.Caravan, Set, 4).action().duration().create();
	    public static final DominionCard Cutpurse = new DominionCardBuilder(DominionItemType.Cutpurse, Set, 4).action().attack().create();
	    public static final DominionCard Island = new DominionCardBuilder(DominionItemType.Island, Set, 4).action().victory().create();
	    public static final DominionCard Navigator = new DominionCardBuilder(DominionItemType.Navigator, Set, 4).action().create();
	    public static final DominionCard PirateShip = new DominionCardBuilder(DominionItemType.PirateShip, Set, 4).action().attack().create();
	    public static final DominionCard Salvager = new DominionCardBuilder(DominionItemType.Salvager, Set, 4).action().create();
	    public static final DominionCard SeaHag = new DominionCardBuilder(DominionItemType.SeaHag, Set, 4).action().attack().create();
	    public static final DominionCard TreasureMap = new DominionCardBuilder(DominionItemType.TreasureMap, Set, 4).action().create();
	    
	    public static final DominionCard Bazaar = new DominionCardBuilder(DominionItemType.Bazaar, Set, 5).action().create();
	    public static final DominionCard Explorer = new DominionCardBuilder(DominionItemType.Explorer, Set, 5).action().create();
	    public static final DominionCard GhostShip = new DominionCardBuilder(DominionItemType.GhostShip, Set, 5).action().attack().create();
	    public static final DominionCard MerchantShip = new DominionCardBuilder(DominionItemType.MerchantShip, Set, 5).action().duration().create();
	    public static final DominionCard Outpost = new DominionCardBuilder(DominionItemType.Outpost, Set, 5).action().duration().create();
	    public static final DominionCard Tactician = new DominionCardBuilder(DominionItemType.Tactician, Set, 5).action().duration().create();
	    public static final DominionCard Treasury = new DominionCardBuilder(DominionItemType.Treasury, Set, 5).action().create();
	    public static final DominionCard Wharf = new DominionCardBuilder(DominionItemType.Wharf, Set, 5).action().duration().create();
	    
	    // Non-cards:
	    public static final DominionGameItem IslandMat = new DominionGameItem(DominionItemType.IslandMat, "", Set);
	    public static final DominionGameItem NativeVillageMat = new DominionGameItem(DominionItemType.NativeVillageMat, "", Set);
	    public static final DominionGameItem PirateShipMat = new DominionGameItem(DominionItemType.PirateShipMat, "", Set);
	    public static final DominionGameItem PirateShipCoinToken = new DominionGameItem(DominionItemType.PirateShipCoinToken, "", Set);
	    public static final DominionGameItem EmbargoToken = new DominionGameItem(DominionItemType.EmbargoToken, "", Set);
	}
	public static ArrayList<DominionCard> seasideCards = new ArrayList<DominionCard>(26);
	
	public static class DarkAges{
	    public static final DominionSet Set = DominionSet.DarkAges;
	    
	    // Ruins:
	    public static final DominionCard Ruin = new DominionCardBuilder(DominionItemType.Ruin, Set, 0).action().ruins().create();
	    public static final DominionCard AbandonedMine = new DominionCardBuilder(DominionItemType.AbandonedMine, Set, 0).action().ruins().create();
	    public static final DominionCard RuinedLibrary = new DominionCardBuilder(DominionItemType.RuinedLibrary, Set, 0).action().ruins().create();
	    public static final DominionCard RuinedMarket = new DominionCardBuilder(DominionItemType.RuinedMarket, Set, 0).action().ruins().create();
	    public static final DominionCard RuinedVillage = new DominionCardBuilder(DominionItemType.RuinedVillage, Set, 0).action().ruins().create();
	    public static final DominionCard Survivors = new DominionCardBuilder(DominionItemType.Survivors, Set, 0).action().ruins().create();
	    
	    // Shelters:
	    public static final DominionCard Hovel = new DominionCardBuilder(DominionItemType.Hovel, Set, 1).reaction().shelter().create();
	    public static final DominionCard Necropolis = new DominionCardBuilder(DominionItemType.Necropolis, Set, 1).action().shelter().create();
	    public static final DominionCard OvergrownEstate = new DominionCardBuilder(DominionItemType.OvergrownEstate, Set, 1).victory().shelter().create();
	    
	    // Knights:
	    public static final DominionCard DameAnna = new DominionCardBuilder(DominionItemType.DameAnna, Set, 5).action().attack().knight().create();
	    public static final DominionCard DameJosephine = new DominionCardBuilder(DominionItemType.DameJosephine, Set, 5).action().attack().victory().knight().create();
	    public static final DominionCard DameMolly = new DominionCardBuilder(DominionItemType.DameMolly, Set, 5).action().attack().knight().create();
	    public static final DominionCard DameNatalie = new DominionCardBuilder(DominionItemType.DameNatalie, Set, 5).action().attack().knight().create();
	    public static final DominionCard DameSylvia = new DominionCardBuilder(DominionItemType.DameSylvia, Set, 5).action().attack().knight().create();
	    public static final DominionCard SirBailey = new DominionCardBuilder(DominionItemType.SirBailey, Set, 5).action().attack().knight().create();
	    public static final DominionCard SirDestry = new DominionCardBuilder(DominionItemType.SirDestry, Set, 5).action().attack().knight().create();
	    public static final DominionCard SirMartin = new DominionCardBuilder(DominionItemType.SirMartin, Set, 4).action().attack().knight().create();
	    public static final DominionCard SirMichael = new DominionCardBuilder(DominionItemType.SirMichael, Set, 5).action().attack().knight().create();
	    public static final DominionCard SirVander = new DominionCardBuilder(DominionItemType.SirVander, Set, 5).action().attack().knight().create();
	    
	    // Other:
	    public static final DominionCard Spoils = new DominionCardBuilder(DominionItemType.Spoils, Set, 0).action().treasure().create();
	    public static final DominionCard Mercenary = new DominionCardBuilder(DominionItemType.Mercenary, Set, 0).action().attack().create();
	    public static final DominionCard Madman = new DominionCardBuilder(DominionItemType.Madman, Set, 0).action().create();
	    
	    public static final DominionCard PoorHouse = new DominionCardBuilder(DominionItemType.PoorHouse, Set, 1).action().create();
	    
	    public static final DominionCard Beggar = new DominionCardBuilder(DominionItemType.Beggar, Set, 2).action().reaction().create();
	    public static final DominionCard Squire = new DominionCardBuilder(DominionItemType.Squire, Set, 2).action().create();
	    public static final DominionCard Vagrant = new DominionCardBuilder(DominionItemType.Vagrant, Set, 2).action().create();
	    
	    public static final DominionCard Forager = new DominionCardBuilder(DominionItemType.Forager, Set, 3).action().create();
	    public static final DominionCard Hermit = new DominionCardBuilder(DominionItemType.Hermit, Set, 3).action().create();
	    public static final DominionCard MarketSquare = new DominionCardBuilder(DominionItemType.MarketSquare, Set, 3).action().reaction().create();
	    public static final DominionCard Sage = new DominionCardBuilder(DominionItemType.Sage, Set, 3).action().create();
	    public static final DominionCard Storeroom = new DominionCardBuilder(DominionItemType.Storeroom, Set, 3).action().create();
	    public static final DominionCard Urchin = new DominionCardBuilder(DominionItemType.Urchin, Set, 3).action().attack().create();
	    
	    public static final DominionCard Armory = new DominionCardBuilder(DominionItemType.Armory, Set, 4).action().create();
	    public static final DominionCard DeathCart = new DominionCardBuilder(DominionItemType.DeathCart, Set, 4).action().looter().create();
	    public static final DominionCard Feodum = new DominionCardBuilder(DominionItemType.Feodum, Set, 4).victory().create();
	    public static final DominionCard Fortress = new DominionCardBuilder(DominionItemType.Fortress, Set, 4).action().create();
	    public static final DominionCard Ironmonger = new DominionCardBuilder(DominionItemType.Ironmonger, Set, 4).action().create();
	    public static final DominionCard Marauder = new DominionCardBuilder(DominionItemType.Marauder, Set, 4).action().attack().looter().create();
	    public static final DominionCard Procession = new DominionCardBuilder(DominionItemType.Procession, Set, 4).action().create();
	    public static final DominionCard Rats = new DominionCardBuilder(DominionItemType.Rats, Set, 4).action().create();
	    public static final DominionCard Scavenger = new DominionCardBuilder(DominionItemType.Scavenger, Set, 4).action().create();
	    public static final DominionCard WanderingMinstrel = new DominionCardBuilder(DominionItemType.WanderingMinstrel, Set, 4).action().create();
	    
	    public static final DominionCard BandOfMisfits = new DominionCardBuilder(DominionItemType.BandOfMisfits, Set, 5).action().create();
	    public static final DominionCard BanditCamp = new DominionCardBuilder(DominionItemType.BanditCamp, Set, 5).action().create();
	    public static final DominionCard Catacombs = new DominionCardBuilder(DominionItemType.Catacombs, Set, 5).action().create();
	    public static final DominionCard Count = new DominionCardBuilder(DominionItemType.Count, Set, 5).action().create();
	    public static final DominionCard Counterfeit = new DominionCardBuilder(DominionItemType.Counterfeit, Set, 5).treasure().create();
	    public static final DominionCard Cultist = new DominionCardBuilder(DominionItemType.Cultist, Set, 5).action().attack().looter().create();
	    public static final DominionCard Graverobber = new DominionCardBuilder(DominionItemType.Graverobber, Set, 5).action().create();
	    public static final DominionCard Junkdealer = new DominionCardBuilder(DominionItemType.Junkdealer, Set, 5).action().create();
	    public static final DominionCard Knights = new DominionCardBuilder(DominionItemType.Knights, Set, 5).action().attack().knight().create();
	    public static final DominionCard Mystic = new DominionCardBuilder(DominionItemType.Mystic, Set, 5).action().create();
	    public static final DominionCard Pillage = new DominionCardBuilder(DominionItemType.Pillage, Set, 5).action().attack().create();
	    public static final DominionCard Rebuild = new DominionCardBuilder(DominionItemType.Rebuild, Set, 5).action().create();
	    public static final DominionCard Rogue = new DominionCardBuilder(DominionItemType.Rogue, Set, 5).action().attack().create();
	    
	    public static final DominionCard Altar = new DominionCardBuilder(DominionItemType.Altar, Set, 6).action().create();
	    public static final DominionCard HuntingGrounds = new DominionCardBuilder(DominionItemType.HuntingGrounds, Set, 6).action().create();
	    
	    public static ArrayList<DominionCard> GetKnightsDeck(){
	        ArrayList<DominionCard> knightsDeck = new ArrayList<DominionCard>(10);
	        knightsDeck.add(DameAnna);
	        knightsDeck.add(DameJosephine);
	        knightsDeck.add(DameMolly);
	        knightsDeck.add(DameNatalie);
	        knightsDeck.add(DameSylvia);
	        knightsDeck.add(SirBailey);
	        knightsDeck.add(SirDestry);
	        knightsDeck.add(SirMartin);
	        knightsDeck.add(SirMichael);
	        knightsDeck.add(SirVander);
	        return knightsDeck;
	    }
	}
	public static ArrayList<DominionCard> darkAgesCards = new ArrayList<DominionCard>(35);
	
	public static class Alchemy{
	    public static DominionSet Set = DominionSet.Alchemy;
	    
	    public static final DominionCard Potion = new DominionCardBuilder(DominionItemType.Potion, Set, 4).treasure().create();
	    
	    public static final DominionCard Herbalist = new DominionCardBuilder(DominionItemType.Herbalist, Set, 2).action().create();
	    
	    public static final DominionCard Apprentice = new DominionCardBuilder(DominionItemType.Apprentice, Set, 5).action().create();
	    
	    public static final DominionCard Transmute = new DominionCardBuilder(DominionItemType.Transmute, Set, 0).action().potionCost().create();
	    public static final DominionCard Vineyard = new DominionCardBuilder(DominionItemType.Vineyard, Set, 0).victory().potionCost().create();
	    
	    public static final DominionCard Apothecary = new DominionCardBuilder(DominionItemType.Apothecary, Set, 2).action().potionCost().create();
	    public static final DominionCard ScryingPool = new DominionCardBuilder(DominionItemType.ScryingPool, Set, 2).action().potionCost().attack().create();
	    public static final DominionCard University = new DominionCardBuilder(DominionItemType.University, Set, 2).action().potionCost().create();
	    
	    public static final DominionCard Alchemist = new DominionCardBuilder(DominionItemType.Alchemist, Set, 3).action().potionCost().create();
	    public static final DominionCard Familiar = new DominionCardBuilder(DominionItemType.Familiar, Set, 3).action().potionCost().attack().create();
	    public static final DominionCard PhilosophersStone = new DominionCardBuilder(DominionItemType.PhilosophersStone, Set, 3).treasure().potionCost().create();
	    
	    public static final DominionCard Golem = new DominionCardBuilder(DominionItemType.Golem, Set, 4).action().potionCost().create();
	    
	    public static final DominionCard Possession = new DominionCardBuilder(DominionItemType.Possession, Set, 6).action().potionCost().create();
	}
	public static ArrayList<DominionCard> alchemyCards = new ArrayList<DominionCard>(12);
	
	public static class Promo{
	    public static DominionSet Set = DominionSet.Promos;
	    
	    public static final DominionCard Stash = new DominionCardBuilder(DominionItemType.Stash, DominionSet.StashPromo, 5).treasure().create();
	    public static final DominionCard BlackMarket = new DominionCardBuilder(DominionItemType.BlackMarket, DominionSet.BlackMarketPromo, 3).action().create();
	    public static final DominionCard Envoy = new DominionCardBuilder(DominionItemType.Envoy, DominionSet.EnvoyPromo, 4).action().create();
	    public static final DominionCard WalledVillage = new DominionCardBuilder(DominionItemType.WalledVillage, DominionSet.WalledVillagePromo, 4).action().create();
	    public static final DominionCard Governor = new DominionCardBuilder(DominionItemType.Governor, DominionSet.GovernorPromo, 5).action().create();
	}
	public static ArrayList<DominionCard> promoCards = new ArrayList<DominionCard>(5);
	
	public static ArrayList<DominionCard> getAllCardsFromSets(List<DominionSet> sets){
		ArrayList<DominionCard> allCards = new ArrayList<DominionCard>();
		for (DominionSet set : sets) {
			switch(set){
			case Cornucopia:
			    allCards.addAll(cornucopiaCards);
			    break;
			case Dominion:
				allCards.addAll(dominionCards);
				break;
			case Intrigue:
				allCards.addAll(intrigueCards);
				break;
			case Prosperity:
				allCards.addAll(prosperityCards);
				break;
			case Hinterlands:
				allCards.addAll(hinterlandsCards);
				break;
			case Seaside:
			    allCards.addAll(seasideCards);
			    break;
			case DarkAges:
			    allCards.addAll(darkAgesCards);
			    break;
			case Alchemy:
			    allCards.addAll(alchemyCards);
			    break;
			case Promos:
			    allCards.addAll(promoCards);
			    break;
		    default:
		        // do nothing
		        break;
			}
		}
		return allCards;
	}

	static {
		createBasicCards();
		createBaseDominionCards();
		createCornucopiaCards();
		createIntrigueCards();
		createProsperityCards();
		createHinterlandsCards();
		createSeasideCards();
		createDarkAgesCards();
		createAlchemyCards();
		createPromoCards();
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
	
	private static void createCornucopiaCards(){
	    cornucopiaCards.add(Cornucopia.Hamlet);
	    
	    cornucopiaCards.add(Cornucopia.FortuneTeller);
	    cornucopiaCards.add(Cornucopia.Menagerie);
	    
	    cornucopiaCards.add(Cornucopia.FarmingVillage);
	    cornucopiaCards.add(Cornucopia.HorseTraders);
	    cornucopiaCards.add(Cornucopia.Remake);
	    cornucopiaCards.add(Cornucopia.Tournament);
	    cornucopiaCards.add(Cornucopia.YoungWitch);
	    
	    cornucopiaCards.add(Cornucopia.Harvest);
	    cornucopiaCards.add(Cornucopia.HornOfPlenty);
	    cornucopiaCards.add(Cornucopia.HuntingParty);
	    cornucopiaCards.add(Cornucopia.Jester);
	    
	    cornucopiaCards.add(Cornucopia.Fairgrounds);
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

	private static void createProsperityCards(){
		nonKingdomCards.add(Prosperity.Platinum);
		nonKingdomCards.add(Prosperity.Colony);
		
		nonKingdomCards.add(Prosperity.TradeRouteMat);
		nonKingdomCards.add(Prosperity.VictoryTokenMat);
		nonKingdomCards.add(Prosperity.TradeRouteCoin);
		nonKingdomCards.add(Prosperity.OneVictoryPointToken);
		nonKingdomCards.add(Prosperity.FiveVictoryPointToken);
		
		prosperityCards.add(Prosperity.Loan);
		prosperityCards.add(Prosperity.TradeRoute);
		prosperityCards.add(Prosperity.Watchtower);
		
		prosperityCards.add(Prosperity.Bishop);
		prosperityCards.add(Prosperity.Monument);
		prosperityCards.add(Prosperity.Quarry);
		prosperityCards.add(Prosperity.Talisman);
		prosperityCards.add(Prosperity.WorkersVillage);
		
		prosperityCards.add(Prosperity.City);
		prosperityCards.add(Prosperity.Contraband);
		prosperityCards.add(Prosperity.CountingHouse);
		prosperityCards.add(Prosperity.Mint);
		prosperityCards.add(Prosperity.Mountebank);
		prosperityCards.add(Prosperity.Rabble);
		prosperityCards.add(Prosperity.RoyalSeal);
		prosperityCards.add(Prosperity.Vault);
		prosperityCards.add(Prosperity.Venture);
		
		prosperityCards.add(Prosperity.Goons);
		prosperityCards.add(Prosperity.GrandMarket);
		prosperityCards.add(Prosperity.Hoard);
		
		prosperityCards.add(Prosperity.Bank);
		prosperityCards.add(Prosperity.Expand);
		prosperityCards.add(Prosperity.Forge);
		prosperityCards.add(Prosperity.KingsCourt);
		
		prosperityCards.add(Prosperity.Peddler);
	}
	
	private static void createHinterlandsCards(){
		hinterlandsCards.add(Hinterlands.Crossroads);
		hinterlandsCards.add(Hinterlands.Duchess);
		hinterlandsCards.add(Hinterlands.FoolsGold);
		
		hinterlandsCards.add(Hinterlands.Develop);
		hinterlandsCards.add(Hinterlands.Oasis);
		hinterlandsCards.add(Hinterlands.Oracle);
		hinterlandsCards.add(Hinterlands.Scheme);
		hinterlandsCards.add(Hinterlands.Tunnel);
		
		hinterlandsCards.add(Hinterlands.JackOfAllTrades);
		hinterlandsCards.add(Hinterlands.NobleBrigand);
		hinterlandsCards.add(Hinterlands.NomadCamp);
		hinterlandsCards.add(Hinterlands.SilkRoad);
		hinterlandsCards.add(Hinterlands.SpiceMerchant);
		hinterlandsCards.add(Hinterlands.Trader);
		
		hinterlandsCards.add(Hinterlands.Cache);
		hinterlandsCards.add(Hinterlands.Cartographer);
		hinterlandsCards.add(Hinterlands.Embassy);
		hinterlandsCards.add(Hinterlands.Haggler);
		hinterlandsCards.add(Hinterlands.Highway);
		hinterlandsCards.add(Hinterlands.IllGottenGains);
		hinterlandsCards.add(Hinterlands.Inn);
		hinterlandsCards.add(Hinterlands.Mandarin);
		hinterlandsCards.add(Hinterlands.Margrave);
		hinterlandsCards.add(Hinterlands.Stables);
		
		hinterlandsCards.add(Hinterlands.BorderVillage);
		hinterlandsCards.add(Hinterlands.Farmland);
	}
	
	private static void createSeasideCards(){
	    seasideCards.add(Seaside.Embargo);
	    seasideCards.add(Seaside.Haven);
	    seasideCards.add(Seaside.Lighthouse);
	    seasideCards.add(Seaside.NativeVillage);
	    seasideCards.add(Seaside.PearlDiver);
	    
	    seasideCards.add(Seaside.Ambassador);
	    seasideCards.add(Seaside.FishingVillage);
	    seasideCards.add(Seaside.Lookout);
	    seasideCards.add(Seaside.Smugglers);
	    seasideCards.add(Seaside.Warehouse);
	    
	    seasideCards.add(Seaside.Caravan);
	    seasideCards.add(Seaside.Cutpurse);
	    seasideCards.add(Seaside.Island);
	    seasideCards.add(Seaside.Navigator);
	    seasideCards.add(Seaside.PirateShip);
	    seasideCards.add(Seaside.Salvager);
	    seasideCards.add(Seaside.SeaHag);
	    seasideCards.add(Seaside.TreasureMap);
	    
	    seasideCards.add(Seaside.Bazaar);
	    seasideCards.add(Seaside.Explorer);
	    seasideCards.add(Seaside.GhostShip);
	    seasideCards.add(Seaside.MerchantShip);
	    seasideCards.add(Seaside.Outpost);
	    seasideCards.add(Seaside.Tactician);
	    seasideCards.add(Seaside.Treasury);
	    seasideCards.add(Seaside.Wharf);
	}
	
	private static void createDarkAgesCards() {
	    darkAgesCards.add(DarkAges.PoorHouse);
	    
	    darkAgesCards.add(DarkAges.Beggar);
	    darkAgesCards.add(DarkAges.Squire);
	    darkAgesCards.add(DarkAges.Vagrant);
	    
	    darkAgesCards.add(DarkAges.Forager);
	    darkAgesCards.add(DarkAges.Hermit);
	    darkAgesCards.add(DarkAges.MarketSquare);
	    darkAgesCards.add(DarkAges.Sage);
	    darkAgesCards.add(DarkAges.Storeroom);
	    darkAgesCards.add(DarkAges.Urchin);
	    
	    darkAgesCards.add(DarkAges.Armory);
	    darkAgesCards.add(DarkAges.DeathCart);
	    darkAgesCards.add(DarkAges.Feodum);
	    darkAgesCards.add(DarkAges.Fortress);
	    darkAgesCards.add(DarkAges.Ironmonger);
	    darkAgesCards.add(DarkAges.Marauder);
	    darkAgesCards.add(DarkAges.Procession);
	    darkAgesCards.add(DarkAges.Rats);
	    darkAgesCards.add(DarkAges.Scavenger);
	    darkAgesCards.add(DarkAges.WanderingMinstrel);
	    
	    darkAgesCards.add(DarkAges.BandOfMisfits);
	    darkAgesCards.add(DarkAges.BanditCamp);
	    darkAgesCards.add(DarkAges.Catacombs);
	    darkAgesCards.add(DarkAges.Count);
	    darkAgesCards.add(DarkAges.Counterfeit);
	    darkAgesCards.add(DarkAges.Cultist);
	    darkAgesCards.add(DarkAges.Graverobber);
	    darkAgesCards.add(DarkAges.Junkdealer);
	    darkAgesCards.add(DarkAges.Knights);
	    darkAgesCards.add(DarkAges.Mystic);
	    darkAgesCards.add(DarkAges.Pillage);
	    darkAgesCards.add(DarkAges.Rebuild);
	    darkAgesCards.add(DarkAges.Rogue);
	    
	    darkAgesCards.add(DarkAges.Altar);
	    darkAgesCards.add(DarkAges.HuntingGrounds);
    }
	
	public static void createAlchemyCards(){
	    alchemyCards.add(Alchemy.Herbalist);
	    
	    alchemyCards.add(Alchemy.Apprentice);
	    
	    alchemyCards.add(Alchemy.Transmute);
	    alchemyCards.add(Alchemy.Vineyard);
	    
	    alchemyCards.add(Alchemy.Apothecary);
	    alchemyCards.add(Alchemy.ScryingPool);
	    alchemyCards.add(Alchemy.University);
	    
	    alchemyCards.add(Alchemy.Alchemist);
	    alchemyCards.add(Alchemy.Familiar);
	    alchemyCards.add(Alchemy.PhilosophersStone);
	    
	    alchemyCards.add(Alchemy.Golem);
	    
	    alchemyCards.add(Alchemy.Possession);
	}
	
	public static void createPromoCards(){
	    promoCards.add(Promo.BlackMarket);
	    promoCards.add(Promo.Envoy);
	    promoCards.add(Promo.Governor);
	    promoCards.add(Promo.Stash);
	    promoCards.add(Promo.WalledVillage);
	}
}
