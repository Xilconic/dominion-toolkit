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

public enum DominionItemType {
	/**
	 * This entry is a dummy placeholder, which should not be used any more during a release.
	 */
	TODO,
	// DominionSet.Basic:
	Copper, Silver, Gold, Estate, Duchy, Province, Curse,
	
	// DominionSet.Alchemy:
	Potion,
	Herbalist,
	Apprentice,
	Transmute, Vineyard,
	Apothecary, ScryingPool, University,
	Alchemist, Familiar, PhilosophersStone,
	Golem,
	Possession,
	
	// DominionSet.Cornucopia:
	Hamlet,
	FortuneTeller, Menagerie,
	FarmingVillage, HorseTraders, Remake, Tournament, YoungWitch,
	Harvest, HornOfPlenty, HuntingParty, Jester,
	Fairgrounds,
	BagOfGold, Diadem, Followers, Princess, TrustySteed,
	
	// DominionSet.DarkAges:
	// Ruins:
	Ruin, AbandonedMine, RuinedLibrary, RuinedMarket, RuinedVillage, Survivors,
	// Shelters:
	Hovel, Necropolis, OvergrownEstate,
	// Knights:
	DameAnna, DameJosephine, DameMolly, DameNatalie, DameSylvia, SirBailey, SirDestry, SirMartin, SirMichael, SirVander,
	// Other
	Madman, Mercenary, Spoils, 
	
	PoorHouse,
	Beggar,Squire,Vagrant,
	Forager, Hermit, MarketSquare, Sage, Storeroom, Urchin,
	Armory, DeathCart, Feodum, Fortress, Ironmonger, Marauder, Procession, Rats, Scavenger, WanderingMinstrel,
	BandOfMisfits, BanditCamp, Catacombs, Count, Counterfeit, Cultist, Graverobber, Junkdealer, Knights, Mystic, Pillage, Rebuild, Rogue,
	Altar, HuntingGrounds,
	
	// DominionSet.Dominion:
	Cellar, Chapel, Moat, 
	Chancellor, Village, Woodcutter, Worshop,
	Bureaucrat, Feast, Gardens, Militia, Moneylender, Remodel, Smithy, Spy, Thief, ThroneRoom,
	CouncilRoom, Festival, Laboratory, Library, Market, Mine, Witch,
	Adventurer,
	
	// DominionSet.Hinterlands:
	Crossroads, Duchess, FoolsGold,
	Develop, Oasis, Oracle, Scheme, Tunnel,
	JackOfAllTrades, NobleBrigand, NomadCamp, SilkRoad, SpiceMerchant, Trader,
	Cache, Cartographer, Embassy, Haggler, Highway, IllGottenGains, Inn, Mandarin, Margrave, Stables,
	BorderVillage, Farmland,
	
	// DominionSet.Intrigue:
	Courtyard, Pawn, SecretChamber,
	GreatHall, Masquerade, ShantyTown, Steward, Swindler, WishingWell,
	Baron, Bridge, Conspirator, Coppersmith, Ironworks, MiningVillage, Scout,
	Duke, Minion, Saboteur, Torturer, TradingPost, Tribute, Upgrade,
	Harem, Nobles,
	
	// DominionSet.Prosperity:
	TradeRouteMat, VictoryTokenMat, OneVictoryPointToken, FiveVictoryPointToken, TradeRouteCoin,
	Colony, Platinum,
	Loan, TradeRoute, Watchtower,
	Bishop, Monument, Quarry, Talisman, WorkersVillage,
	City, Contraband, CountingHouse, Mint, Mountebank, Rabble, RoyalSeal, Vault, Venture,
	Goons, GrandMarket, Hoard, 
	Bank, Expand, Forge, KingsCourt,
	Peddler,
	
	// DominionSet.Seaside:
	IslandMat, NativeVillageMat, PirateShipMat, PirateShipCoinToken, EmbargoToken,
	Embargo, Haven, Lighthouse, NativeVillage, PearlDiver,
	Ambassador, FishingVillage, Lookout, Smugglers, Warehouse,
	Caravan, Cutpurse, Island, Navigator, PirateShip, Salvager, SeaHag, TreasureMap,
	Bazaar, Explorer, GhostShip, MerchantShip, Outpost, Tactician, Treasury, Wharf,
	
	// DominionSet.Guilds:
	CoinToken,
	CandlestickMaker, StoneMason,
	Doctor, Masterpiece,
	Advisor, Plaza, Taxman, Herald,
	Baker, Butcher, Journeyman, MerchantGuild, Soothsayer,
	
	// Promo's:
	Stash, BlackMarket, Envoy, WalledVillage, Governor
}
