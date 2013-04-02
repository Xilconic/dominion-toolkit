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
package com.xilconic.dominiontoolkit.Activities.DominionGameSetupActivityClasses;

import java.util.ArrayList;

import com.xilconic.dominiontoolkit.DominionCards.AmountOfDominionGameItem;
import com.xilconic.dominiontoolkit.DominionCards.DominionCard;
import com.xilconic.dominiontoolkit.DominionCards.DominionSet;

/**
 * This class will gather all the required elements to play a game of Dominion,
 * given a set of Kingdom cards.
 * @author Bas des Bouvrie
 *
 */
public class DominionGameSetup {
	private ArrayList<AmountOfDominionGameItem> kingdomCardsAndCount;
	private ArrayList<AmountOfDominionGameItem> eachPlayerReceives;
	private int playerCount;
	private boolean isFullySetUp;
	
	/**
	 * Constructor without a set of cards to play with, assuming 4 players.
	 */
	public DominionGameSetup(){
		kingdomCardsAndCount = new ArrayList<AmountOfDominionGameItem>(10);
		eachPlayerReceives = new ArrayList<AmountOfDominionGameItem>(2); 
		playerCount = 4;
		isFullySetUp = false;
	}
	
	/**
	 * Constructor with a set of Kingdom cards to play with.
	 * @param kingdomCards
	 */
	public DominionGameSetup(ArrayList<DominionCard> kingdomCards){
		this();
		setKingdomCardSet(kingdomCards);
	}
	
	/**
	 * Checks if {@link DominionGameSetup} has been fully configured for
	 * the given set of 
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
			kingdomCardsAndCount.add(new AmountOfDominionGameItem(card, getNumberOfOccurences(card)));
		}
	}

	/**
	 * Retrieves the kingdom cards and the number to cards for each.
	 * @return
	 */
	public ArrayList<AmountOfDominionGameItem> getKingdomCardSetup() {
		return kingdomCardsAndCount;
	}
	
	private int getNumberOfOccurences(DominionCard card){
		if (card.isVictory()){
			return 8 + (playerCount-2)*2;
		}
		return 10;
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
			cardAndCount.setCount(getNumberOfOccurences((DominionCard)cardAndCount.getItem()));
		}
	}

	/**
	 * Configures the game based on the selected kingdom cards.
	 */
	public void SetUp() {
		eachPlayerReceives.clear();
		
		// HACK: TODO: Replace this with a call from data base
		DominionCard card = new DominionCard(0, "Koper", 0, false, false, false, true, false, false, DominionSet.Basic);
		eachPlayerReceives.add(new AmountOfDominionGameItem(card, 7));
		card = new DominionCard(0, "Landgoed", 0, false, false, false, false, true, false, DominionSet.Basic);
		eachPlayerReceives.add(new AmountOfDominionGameItem(card, 3));
		
		isFullySetUp = true;
	}

	public ArrayList<AmountOfDominionGameItem> GetPlayerStartingItems() {
		return eachPlayerReceives;
	}
}
