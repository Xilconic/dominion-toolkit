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
package com.xilconic.dominiontoolkit.Activities.GameSetup;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;
import com.xilconic.dominiontoolkit.DominionCards.AmountOfDominionGameItem;
import com.xilconic.dominiontoolkit.DominionCards.CardsDB;
import com.xilconic.dominiontoolkit.DominionCards.DominionCard;
import com.xilconic.dominiontoolkit.DominionCards.DominionGameItem;

/**
 * This class will gather all the required elements to play a game of Dominion,
 * given a set of Kingdom cards.
 * @author Bas des Bouvrie
 *
 */
public class GameSetup implements Parcelable{
	private ArrayList<AmountOfDominionGameItem> kingdomCardsAndCount;
	private ArrayList<AmountOfDominionGameItem> eachPlayerReceives;
	private ArrayList<AmountOfDominionGameItem> gameStartsWith;
	private int playerCount;
	private boolean isFullySetUp, useProsperitySetup, useDarkAgesSetup;
    private AmountOfDominionGameItem baneCard;
	
	/**
	 * Constructor without a set of cards to play with, assuming 4 players.
	 */
	public GameSetup(){
		kingdomCardsAndCount = new ArrayList<AmountOfDominionGameItem>(10);
		eachPlayerReceives = new ArrayList<AmountOfDominionGameItem>(2);
		gameStartsWith = new ArrayList<AmountOfDominionGameItem>(6);
		playerCount = 4;
		isFullySetUp = false;
		useProsperitySetup = false;
		useDarkAgesSetup = false;
	}
	
	/**
	 * Constructor with a set of Kingdom cards to play with.
	 * @param kingdomCards
	 */
	public GameSetup(ArrayList<DominionCard> kingdomCards){
		this();
		setKingdomCardSet(kingdomCards);
	}
	
	public boolean setUseProsperitySetup(){
	    return useProsperitySetup;
	}
	
	public void setUseProsperitySetup(boolean useSetup) {
        useProsperitySetup = useSetup;
    }

	public boolean setUseDarkAgesSetup(){
	    return useDarkAgesSetup;
	}
	
    public void setUseDarkAgesSetup(boolean useSetup) {
        useDarkAgesSetup = useSetup;
    }
	
	/**
	 * Checks if {@link GameSetup} has been fully configured for
	 * the given set of kingdom cards.
	 * @return
	 */
	public boolean isFullySetup(){
		return isFullySetUp;
	}
	
	/**
	 * Sets a collection of Kingdom cards for this game.
	 * The list must be 10 items large.
	 * @param kingdomCards
	 */
	public void setKingdomCardSet(ArrayList<DominionCard> kingdomCards){
		if (kingdomCards == null){
			throw new IllegalArgumentException("Argument kingdomCards cannot be null");
		}
		if (kingdomCards.size() != 10){
			throw new IllegalArgumentException("Must specify 10 kingdom cards");
		}

		isFullySetUp = false;
		kingdomCardsAndCount.clear();
		
		for(DominionCard card : kingdomCards){
			kingdomCardsAndCount.add(new AmountOfDominionGameItem(card, getNumberOfOccurences(card, CardPile.Kingdom)));
		}
	}

	/**
	 * Retrieves the kingdom cards and the number to cards for each.
	 * @return
	 */
	public ArrayList<AmountOfDominionGameItem> getKingdomCardSetup() {
		return kingdomCardsAndCount;
	}
	
	private int getNumberOfOccurences(DominionCard card, CardPile pile){
	    switch (pile) {
        case Kingdom:
            if (card.isVictory()) return 8 + (playerCount-2)*2;
            if (card.equals(CardsDB.DarkAges.Rats)) return 20;

            return 10;
        case GameStart:
            if (card.isVictory()) return 8 + (playerCount-2)*2;
            if (card.equals(CardsDB.Basic.Copper)) return 60 - playerCount * 7;
            if (card.equals(CardsDB.Basic.Silver)) return 40;
            if (card.equals(CardsDB.Basic.Gold)) return 30;
            if (card.equals(CardsDB.Prosperity.Platinum)) return 12;
            if (card.equals(CardsDB.Basic.Curse) || card.equals(CardsDB.DarkAges.Ruin)) return (playerCount-1)*10;
            if (card.equals(CardsDB.DarkAges.Mercenary) ||
                card.equals(CardsDB.DarkAges.Madman)){
                return 10;
            }
            if (card.equals(CardsDB.DarkAges.Spoils) ||
                card.equals(CardsDB.Seaside.EmbargoToken)) return 15;
            if (card.equals(CardsDB.Seaside.PirateShipCoinToken)) return 25;
            if (card.equals(CardsDB.Alchemy.Potion)) return 16;

        default:
            break;
        }
		return 0;
	}

	/**
	 * The number of players this game has been configured with.
	 * @return
	 */
	public int getPlayerCount() {
		return playerCount;
	}

	/**
	 * Sets the number of players for this game and update the
	 * card occurrences based on the number of players.
	 * @param numberOfPlayers
	 */
	public void setPlayerCount(int numberOfPlayers) {
		if (numberOfPlayers < 2 || numberOfPlayers > 6){
			throw new IllegalArgumentException("Number of players must be within the range of [2,6]");
		}
		this.playerCount = numberOfPlayers;

		// Correct card counts:
		for (AmountOfDominionGameItem cardAndCount : kingdomCardsAndCount) {
			// Assumption: kingdamCardsAndCount only has DominionCard classes as item.
			cardAndCount.setCount(getNumberOfOccurences((DominionCard)cardAndCount.getItem(), CardPile.Kingdom));
		}
		
		for(AmountOfDominionGameItem cardAndCount : gameStartsWith){
		    // Assumption: gameStartsWith only has DominionCard classes as item.
            cardAndCount.setCount(getNumberOfOccurences((DominionCard)cardAndCount.getItem(), CardPile.GameStart));
		}
		
		if (baneCard != null){
		    baneCard.setCount(getNumberOfOccurences((DominionCard)baneCard.getItem(), CardPile.Kingdom));
		}
	}

	/**
	 * Configures the game based on the selected kingdom cards.
	 */
	public void SetUp() {
		setUpPlayerStartingItems();
		setUpGameStartingItems();
		
		isFullySetUp = true;
	}
	
	private void setUpPlayerStartingItems(){
		eachPlayerReceives.clear();
		
		if (useDarkAgesSetup){
		    eachPlayerReceives.add(new AmountOfDominionGameItem(CardsDB.Basic.Copper, 7));
		    eachPlayerReceives.add(new AmountOfDominionGameItem(CardsDB.DarkAges.Hovel, 1));
		    eachPlayerReceives.add(new AmountOfDominionGameItem(CardsDB.DarkAges.Necropolis, 1));
		    eachPlayerReceives.add(new AmountOfDominionGameItem(CardsDB.DarkAges.OvergrownEstate, 1));
		}
		else{
		    eachPlayerReceives.add(new AmountOfDominionGameItem(CardsDB.Basic.Copper, 7));
	        eachPlayerReceives.add(new AmountOfDominionGameItem(CardsDB.Basic.Estate, 3));
		}
		
		for (AmountOfDominionGameItem gameItemAmount : kingdomCardsAndCount) {
            DominionGameItem item = gameItemAmount.getItem();
            
            if (item.equals(CardsDB.Seaside.NativeVillage)) eachPlayerReceives.add(new AmountOfDominionGameItem(CardsDB.Seaside.NativeVillageMat, 1));
            if (item.equals(CardsDB.Seaside.PirateShip)) eachPlayerReceives.add(new AmountOfDominionGameItem(CardsDB.Seaside.PirateShipMat, 1));
            if (item.equals(CardsDB.Seaside.Island)) eachPlayerReceives.add(new AmountOfDominionGameItem(CardsDB.Seaside.IslandMat, 1));
        }
	}
	
	private void setUpGameStartingItems(){
		gameStartsWith.clear();
		
		gameStartsWith.add(new AmountOfDominionGameItem(CardsDB.Basic.Copper, getNumberOfOccurences(CardsDB.Basic.Copper, CardPile.GameStart)));
		gameStartsWith.add(new AmountOfDominionGameItem(CardsDB.Basic.Silver, getNumberOfOccurences(CardsDB.Basic.Silver, CardPile.GameStart)));
		gameStartsWith.add(new AmountOfDominionGameItem(CardsDB.Basic.Gold, getNumberOfOccurences(CardsDB.Basic.Gold, CardPile.GameStart)));
		if (useProsperitySetup){
		    gameStartsWith.add(new AmountOfDominionGameItem(CardsDB.Prosperity.Platinum, getNumberOfOccurences(CardsDB.Prosperity.Platinum, CardPile.GameStart)));
		}
		
		gameStartsWith.add(new AmountOfDominionGameItem(CardsDB.Basic.Estate, getNumberOfOccurences(CardsDB.Basic.Estate, CardPile.GameStart)));
		gameStartsWith.add(new AmountOfDominionGameItem(CardsDB.Basic.Duchy, getNumberOfOccurences(CardsDB.Basic.Duchy, CardPile.GameStart)));
		gameStartsWith.add(new AmountOfDominionGameItem(CardsDB.Basic.Province, getNumberOfOccurences(CardsDB.Basic.Province, CardPile.GameStart)));
		if (useProsperitySetup){
            gameStartsWith.add(new AmountOfDominionGameItem(CardsDB.Prosperity.Colony, getNumberOfOccurences(CardsDB.Prosperity.Colony, CardPile.GameStart)));
        }
		
		boolean addedSpoils = false;
		boolean addedRuins = false;
		boolean addedPotion = false;
		for (AmountOfDominionGameItem gameItemAmount : kingdomCardsAndCount) {
            DominionGameItem item = gameItemAmount.getItem();
            
            if (item.equals(CardsDB.Cornucopia.Tournament)){
                for (DominionCard prizeCard : CardsDB.Cornucopia.getPrizeCards()) {
                    gameStartsWith.add(new AmountOfDominionGameItem(prizeCard, 1));
                }
            }
            
            if (item.equals(CardsDB.Seaside.PirateShip)) gameStartsWith.add(new AmountOfDominionGameItem(CardsDB.Seaside.PirateShipCoinToken, 25));
            if (item.equals(CardsDB.Seaside.Embargo)) gameStartsWith.add(new AmountOfDominionGameItem(CardsDB.Seaside.EmbargoToken, 15));
            if (item.equals(CardsDB.DarkAges.Hermit)) gameStartsWith.add(new AmountOfDominionGameItem(CardsDB.DarkAges.Madman, getNumberOfOccurences(CardsDB.DarkAges.Madman, CardPile.GameStart)));
            if (item.equals(CardsDB.DarkAges.Urchin)) gameStartsWith.add(new AmountOfDominionGameItem(CardsDB.DarkAges.Mercenary, getNumberOfOccurences(CardsDB.DarkAges.Mercenary, CardPile.GameStart)));
            if ((item.equals(CardsDB.DarkAges.BanditCamp) || 
                item.equals(CardsDB.DarkAges.Marauder) || 
                item.equals(CardsDB.DarkAges.Pillage)) && !addedSpoils) 
            {
                gameStartsWith.add(new AmountOfDominionGameItem(CardsDB.DarkAges.Spoils, getNumberOfOccurences(CardsDB.DarkAges.Spoils, CardPile.GameStart)));
                addedSpoils = true;
            }
            
            if (gameItemAmount.isCard()){
                DominionCard card = (DominionCard)item;
                
                if (card.isLooter() && !addedRuins) 
                {
                    gameStartsWith.add(new AmountOfDominionGameItem(CardsDB.DarkAges.Ruin, getNumberOfOccurences(CardsDB.DarkAges.Ruin, CardPile.GameStart)));
                    addedRuins = true;
                }
                
                if (card.is_costsPotion() && !addedPotion){
                    gameStartsWith.add(new AmountOfDominionGameItem(CardsDB.Alchemy.Potion, getNumberOfOccurences(CardsDB.Alchemy.Potion, CardPile.GameStart)));
                    addedPotion = true;
                }
            }
        }
	}

	public ArrayList<AmountOfDominionGameItem> GetPlayerStartingItems() {
		return eachPlayerReceives;
	}

	public ArrayList<AmountOfDominionGameItem> getGlobalStartingItems() {
		return gameStartsWith;
	}
	
	public AmountOfDominionGameItem getBaneCard(){
	    return baneCard;
	}
	
	public void setBaneCard(DominionCard card){
	    if (card.get_cost() != 2 && card.get_cost() != 3) throw new IllegalArgumentException("Bane card must have cost of 2 or 3.");
	    baneCard = new AmountOfDominionGameItem(card, getNumberOfOccurences(card, CardPile.Kingdom));
	}
	
	// ==== Interface: Parcelable =======================
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int flags) {
		parcel.writeInt(playerCount);
		parcel.writeBooleanArray(new boolean[]{isFullySetUp});
		parcel.writeTypedList(kingdomCardsAndCount);
		if (isFullySetUp){
			parcel.writeTypedList(eachPlayerReceives);
			parcel.writeTypedList(gameStartsWith);
		}
	}
	
	protected GameSetup(Parcel parcel){
		kingdomCardsAndCount = new ArrayList<AmountOfDominionGameItem>(10);
		eachPlayerReceives = new ArrayList<AmountOfDominionGameItem>(2);
		gameStartsWith = new ArrayList<AmountOfDominionGameItem>(6);
		
		playerCount = parcel.readInt();
		boolean[] flags = new boolean[1];
		parcel.readBooleanArray(flags);
		isFullySetUp = flags[0];
		parcel.readTypedList(kingdomCardsAndCount, AmountOfDominionGameItem.CREATOR);
		
		if (isFullySetUp){
			parcel.readTypedList(eachPlayerReceives, AmountOfDominionGameItem.CREATOR);
			parcel.readTypedList(gameStartsWith, AmountOfDominionGameItem.CREATOR);
		}
	}

	public static final Parcelable.Creator<GameSetup> CREATOR = new Parcelable.Creator<GameSetup>()
	{
		public GameSetup createFromParcel(Parcel parcel) {
			return new GameSetup(parcel);
		}
		
		public GameSetup[] newArray(int size) {
			return new GameSetup[size];
		}
	};
	// = END Interface: Parcelable ======================
	
	private enum CardPile { Kingdom, GameStart, PlayerReceive }
}
