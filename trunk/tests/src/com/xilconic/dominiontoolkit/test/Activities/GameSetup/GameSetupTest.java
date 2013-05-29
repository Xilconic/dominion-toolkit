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
package com.xilconic.dominiontoolkit.test.Activities.GameSetup;

import java.util.ArrayList;

import android.os.Parcel;
import android.test.AndroidTestCase;

import com.xilconic.dominiontoolkit.Activities.GameSetup.GameSetup;
import com.xilconic.dominiontoolkit.DominionCards.AmountOfDominionGameItem;
import com.xilconic.dominiontoolkit.DominionCards.CardsDB;
import com.xilconic.dominiontoolkit.DominionCards.DominionCard;
import com.xilconic.dominiontoolkit.DominionCards.DominionSet;

public class GameSetupTest extends AndroidTestCase {
	private GameSetup gameSetup;
	
	// Required for JUnit
	public GameSetupTest(){}
	
	protected void setUp() throws Exception{
		gameSetup = new GameSetup();
	}
	
	public void testPreCondition(){
		assertTrue("DominionGameSetup default constructor assumes 4 players", 
				gameSetup.getPlayerCount() == 4);
		ArrayList<AmountOfDominionGameItem> kingdomCardSetup = gameSetup.getKingdomCardSetup();
		assertTrue("DominionGameSetup default constructor should initialize the kingdom card setup", 
				kingdomCardSetup != null);
		assertTrue("DominionGameSetup default constructor should have created an empty kingdom card setup", 
				kingdomCardSetup.size() == 0);
		assertTrue("DominionGameSetup default constructor should be marked as not fully set up", 
				gameSetup.isFullySetup() == false);
	}
	
	public void testSetKingdomCardSet(){
		try{
			gameSetup.setKingdomCardSet(null);
		}
		catch(IllegalArgumentException e){
			assertTrue("Should not accept null as argument",
					e.getMessage().equals("Argument kingdomCards cannot be null"));
		}
		
		try{
			gameSetup.setKingdomCardSet(new ArrayList<DominionCard>());
		}
		catch(IllegalArgumentException e){
			assertTrue("Should only accept 10 items as argument",
					e.getMessage().equals("Must specify 10 kingdom cards"));
		}
			
		ArrayList<DominionCard> kingdomCardsReference = createSimpleKingdomCardList();
		
		gameSetup.setKingdomCardSet(kingdomCardsReference);
		ArrayList<AmountOfDominionGameItem> kingdomCardSetup = gameSetup.getKingdomCardSetup();
		
		assertEquals(10, kingdomCardSetup.get(0).getCount()); // Regular card
		assertEquals(12, kingdomCardSetup.get(1).getCount()); // Victory card
		assertTrue("Game should be marked as not fully set up",
				gameSetup.isFullySetup() == false);
	}
	
	public void testSetPlayerCount(){
		try{
			gameSetup.setPlayerCount(1);
		}
		catch(IllegalArgumentException e){
			assertTrue("Should only accept players being set in the inclusive range of [2,6]", 
					e.getMessage().equals("Number of players must be within the range of [2,6]"));
		}
		for(int i = 2; i <= 6; i++){
			gameSetup.setPlayerCount(i);
			assertTrue(i + " should be an accepted number of players",
					gameSetup.getPlayerCount() == i);
		}
		try{
			gameSetup.setPlayerCount(7);
		}
		catch(IllegalArgumentException e){
			assertTrue("Should only accept players being set in the inclusive range of [2,6]", 
					e.getMessage().equals("Number of players must be within the range of [2,6]"));
		}
	}
	
	public void testSettingPlayerCountCorectNumberOfVictoryCards(){
		ArrayList<DominionCard> kingdomCardsReference = createSimpleKingdomCardList();
		
		gameSetup.setKingdomCardSet(kingdomCardsReference);
		ArrayList<AmountOfDominionGameItem> kingdomCardSetup = gameSetup.getKingdomCardSetup();
		
		assertEquals(10, kingdomCardSetup.get(0).getCount()); // Regular card
		assertEquals(12, kingdomCardSetup.get(1).getCount()); // Victory card
		
		gameSetup.setPlayerCount(2);
		
		assertEquals(10, kingdomCardSetup.get(0).getCount()); // Regular card
		assertEquals(8, kingdomCardSetup.get(1).getCount()); // Victory card
	}
	
	public void testPlayersStartWith(){
		ArrayList<DominionCard> kingdomCardsReference = createSimpleKingdomCardList();
		
		gameSetup.setKingdomCardSet(kingdomCardsReference);
		gameSetup.SetUp();
		assertTrue("Should be fully set up after call.", gameSetup.isFullySetup());
		ArrayList<AmountOfDominionGameItem> gameStartingItems = gameSetup.GetPlayerStartingItems();
		
		assertEquals("Expecting two cathegories", 2, gameStartingItems.size());
		
		AmountOfDominionGameItem firstEntry = gameStartingItems.get(0);
		AmountOfDominionGameItem secondEntry = gameStartingItems.get(1);
		assertEquals("First entries should be starting cards",
				true, firstEntry.isCard());
		assertEquals("First entries should be starting cards",
				true, secondEntry.isCard());
		
		DominionCard copperCard = (DominionCard)firstEntry.getItem();
		assertEquals("Start with coppers", CardsDB.Basic.Copper, copperCard);
		assertEquals(7, firstEntry.getCount());
		
		DominionCard estateCard = (DominionCard)secondEntry.getItem();
		assertEquals("Follow with other starting deck cards", CardsDB.Basic.Estate, estateCard);
		assertEquals(3, secondEntry.getCount());
	}
	
	public void testGlobalStartsWith(){
		ArrayList<DominionCard> kingdomCardsReference = createSimpleKingdomCardList();

		gameSetup.setKingdomCardSet(kingdomCardsReference);
		gameSetup.SetUp();
		assertTrue("Should be fully set up after call.", gameSetup.isFullySetup());
		ArrayList<AmountOfDominionGameItem> gameGlobalStartingItems = gameSetup.getGlobalStartingItems();

		assertEquals("6 banks cards", 6, gameGlobalStartingItems.size());

		for(int i = 0; i < 6; i++){
			AmountOfDominionGameItem item = gameGlobalStartingItems.get(i);
			assertTrue("For i = "+ i, item.isCard());
			
			switch(i){
			case 0: // Copper
				assertEquals(CardsDB.Basic.Copper, item.getItem());
				assertEquals(60 - 4*7, item.getCount()); // 60 total, - 7 x #players
				break;
			case 1: // Silver
				assertEquals(CardsDB.Basic.Silver, item.getItem());
				assertEquals(40, item.getCount()); // 40 total
				break;
			case 2: // Gold
				assertEquals(CardsDB.Basic.Gold, item.getItem());
				assertEquals(30, item.getCount()); // 30 total
				break;
			case 3: // Estate
				assertEquals(CardsDB.Basic.Estate, item.getItem());
				assertEquals(12, item.getCount()); // 12 for 4 players
				break;
			case 4: // Duchy
				assertEquals(CardsDB.Basic.Duchy, item.getItem());
				assertEquals(12, item.getCount()); // 12 for 4 players
				break;
			case 5: // Province
				assertEquals(CardsDB.Basic.Province, item.getItem());
				assertEquals(12, item.getCount()); // 12 for 4 players
				break;
			}
		}
	}
	
	public void testParcelableCreator(){
		ArrayList<DominionCard> simpleKingdomCardList = createSimpleKingdomCardList();
		Parcel parcel = Parcel.obtain();
		
		gameSetup.setKingdomCardSet(simpleKingdomCardList);
		gameSetup.setPlayerCount(2); // Non-default
		
		// Write to parcel while not fully set up:
		gameSetup.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		
		// Retrieve:
		GameSetup createdFromParcel = GameSetup.CREATOR.createFromParcel(parcel);
		assertEquals(false, createdFromParcel.isFullySetup());
		assertEquals(2, createdFromParcel.getPlayerCount());
		ArrayList<AmountOfDominionGameItem> kingdomCards = createdFromParcel.getKingdomCardSetup();
		assertEquals(10, kingdomCards.size());
		
		for (int i = 0; i < simpleKingdomCardList.size(); i++) {
			assertEquals(simpleKingdomCardList.get(i), kingdomCards.get(i).getItem());
			int cardCount = simpleKingdomCardList.get(i).isVictory() ? 8 : 10;
			assertEquals(cardCount, kingdomCards.get(i).getCount());
		}
		assertEquals(0, createdFromParcel.getGlobalStartingItems().size());
		assertEquals(0, createdFromParcel.GetPlayerStartingItems().size());
		
		// Write to parcel while fully set up:
		parcel = Parcel.obtain();
		gameSetup.SetUp();
		gameSetup.writeToParcel(parcel, 0);
		parcel.setDataPosition(0);
		
		// Retrieve:
		createdFromParcel = GameSetup.CREATOR.createFromParcel(parcel);
		assertEquals(true, createdFromParcel.isFullySetup());
		assertEquals(2, createdFromParcel.getPlayerCount());
		kingdomCards = createdFromParcel.getKingdomCardSetup();
		assertEquals(10, kingdomCards.size());
		
		for (int i = 0; i < simpleKingdomCardList.size(); i++) {
			assertEquals(simpleKingdomCardList.get(i), kingdomCards.get(i).getItem());
			int cardCount = simpleKingdomCardList.get(i).isVictory() ? 8 : 10;
			assertEquals(cardCount, kingdomCards.get(i).getCount());
		}
		assertEquals(gameSetup.getGlobalStartingItems().size(), createdFromParcel.getGlobalStartingItems().size());
		assertEquals(gameSetup.GetPlayerStartingItems().size(), createdFromParcel.GetPlayerStartingItems().size());
	}
	
	public void testBaneCard(){
	    gameSetup.setPlayerCount(4);
	    assertEquals("Should be null when constructed", null, gameSetup.getBaneCard());
	    
	    try {
	        gameSetup.setBaneCard(new DominionCard(0, "card too cheap", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
	        assertTrue("IllegalArgumentException expected to be thrown", false);
        } catch (IllegalArgumentException e) {
            assertEquals("Bane card must have cost of 2 or 3.", e.getMessage());
        }
	    
	    try {
            gameSetup.setBaneCard(new DominionCard(0, "card too expensive", 4, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
            assertTrue("IllegalArgumentException expected to be thrown", false);
        } catch (IllegalArgumentException e) {
            assertEquals("Bane card must have cost of 2 or 3.", e.getMessage());
        }
	    
	    DominionCard card = new DominionCard(0, "Card cost OK", 2, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion);
	    gameSetup.setBaneCard(card);
	    assertEquals(card, gameSetup.getBaneCard().getItem());
	    assertEquals(10, gameSetup.getBaneCard().getCount());
	    
	    card = new DominionCard(0, "Card cost OK", 2, true, false, false, false, true, false, false, false, false, false, false, false, DominionSet.Dominion);
        gameSetup.setBaneCard(card);
        assertEquals(card, gameSetup.getBaneCard().getItem());
        assertEquals(12, gameSetup.getBaneCard().getCount());
        
        gameSetup.setPlayerCount(2);
        assertEquals(8, gameSetup.getBaneCard().getCount());
	}
	
	public void testCornucopiaTournamentPrizesInGameStartsWith(){
	    ArrayList<DominionCard> kingdomCardsReference = createSimpleKingdomCardList();
	    kingdomCardsReference.set(0, CardsDB.Cornucopia.Tournament);

        gameSetup.setKingdomCardSet(kingdomCardsReference);
        gameSetup.SetUp();
        
        ArrayList<AmountOfDominionGameItem> gameGlobalStartingItems = gameSetup.getGlobalStartingItems();
        assertEquals(CardsDB.Cornucopia.BagOfGold, gameGlobalStartingItems.get(6).getItem());
        assertEquals(CardsDB.Cornucopia.Diadem, gameGlobalStartingItems.get(7).getItem());
        assertEquals(CardsDB.Cornucopia.Followers, gameGlobalStartingItems.get(8).getItem());
        assertEquals(CardsDB.Cornucopia.Princess, gameGlobalStartingItems.get(9).getItem());
        assertEquals(CardsDB.Cornucopia.TrustySteed, gameGlobalStartingItems.get(10).getItem());
        
        assertEquals(1, gameGlobalStartingItems.get(6).getCount());
        assertEquals(1, gameGlobalStartingItems.get(7).getCount());
        assertEquals(1, gameGlobalStartingItems.get(8).getCount());
        assertEquals(1, gameGlobalStartingItems.get(9).getCount());
        assertEquals(1, gameGlobalStartingItems.get(10).getCount());
	}
	
	public void testSeasideNativeVillageMatInEachPlayerStartsWith(){
	    ArrayList<DominionCard> kingdomCardsReference = createSimpleKingdomCardList();
        kingdomCardsReference.set(0, CardsDB.Seaside.NativeVillage);

        gameSetup.setKingdomCardSet(kingdomCardsReference);
        gameSetup.SetUp();
        
        ArrayList<AmountOfDominionGameItem> playerStartingItems = gameSetup.GetPlayerStartingItems();
        assertEquals(CardsDB.Seaside.NativeVillageMat, playerStartingItems.get(2).getItem());
        assertEquals(1, playerStartingItems.get(2).getCount());
	}
	
	public void testSeasideIslandMatInEachPlayerStartsWith(){
        ArrayList<DominionCard> kingdomCardsReference = createSimpleKingdomCardList();
        kingdomCardsReference.set(0, CardsDB.Seaside.Island);

        gameSetup.setKingdomCardSet(kingdomCardsReference);
        gameSetup.SetUp();
        
        ArrayList<AmountOfDominionGameItem> playerStartingItems = gameSetup.GetPlayerStartingItems();
        assertEquals(CardsDB.Seaside.IslandMat, playerStartingItems.get(2).getItem());
        assertEquals(1, playerStartingItems.get(2).getCount());
    }
	
	public void testSeasidePirateShipItemsInEachPlayerStartsWithAndGameStartsWith(){
        ArrayList<DominionCard> kingdomCardsReference = createSimpleKingdomCardList();
        kingdomCardsReference.set(0, CardsDB.Seaside.PirateShip);

        gameSetup.setKingdomCardSet(kingdomCardsReference);
        gameSetup.SetUp();
        
        ArrayList<AmountOfDominionGameItem> playerStartingItems = gameSetup.GetPlayerStartingItems();
        
        assertEquals(CardsDB.Seaside.PirateShipMat, playerStartingItems.get(2).getItem());
        assertEquals(1, playerStartingItems.get(2).getCount());
        
        ArrayList<AmountOfDominionGameItem> gameStartingItems = gameSetup.getGlobalStartingItems();
        assertEquals(CardsDB.Seaside.PirateShipCoinToken, gameStartingItems.get(6).getItem());
        assertEquals(25, gameStartingItems.get(6).getCount());
    }
	
	public void testSeasideEmbargoTokensInEachPlayerStartsWith(){
        ArrayList<DominionCard> kingdomCardsReference = createSimpleKingdomCardList();
        kingdomCardsReference.set(0, CardsDB.Seaside.Embargo);

        gameSetup.setKingdomCardSet(kingdomCardsReference);
        gameSetup.SetUp();
        
        ArrayList<AmountOfDominionGameItem> gameStartingItems = gameSetup.getGlobalStartingItems();
        assertEquals(CardsDB.Seaside.EmbargoToken, gameStartingItems.get(6).getItem());
        assertEquals(15, gameStartingItems.get(6).getCount());
    }
	
	/**
	 * Creates a list of dummy cards. The first card is a regular card, the second is a regular victory card.
	 * The rest as filler.
	 * @return A list of dummy cards.
	 */
	private ArrayList<DominionCard> createSimpleKingdomCardList(){
		ArrayList<DominionCard> kingdomCardsReference = new ArrayList<DominionCard>();
		// Regular card:
		kingdomCardsReference.add(new DominionCard(0, "card 1", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
		// Victory card:
		kingdomCardsReference.add(new DominionCard(0, "card 2", 1, true, false, false, false, true, false, false, false, false, false, false, false, DominionSet.Dominion));
		// More regular cards:
		kingdomCardsReference.add(new DominionCard(0, "card 3", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
		kingdomCardsReference.add(new DominionCard(0, "card 4", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
		kingdomCardsReference.add(new DominionCard(0, "card 5", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
		kingdomCardsReference.add(new DominionCard(0, "card 6", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
		kingdomCardsReference.add(new DominionCard(0, "card 7", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
		kingdomCardsReference.add(new DominionCard(0, "card 8", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
		kingdomCardsReference.add(new DominionCard(0, "card 9", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
		kingdomCardsReference.add(new DominionCard(0, "card 10", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
		
		return kingdomCardsReference;
	}
}
