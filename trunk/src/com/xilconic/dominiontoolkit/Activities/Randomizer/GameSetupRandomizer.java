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
package com.xilconic.dominiontoolkit.Activities.Randomizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.xilconic.dominiontoolkit.Activities.GameSetup.GameSetup;
import com.xilconic.dominiontoolkit.DominionCards.CardsDB;
import com.xilconic.dominiontoolkit.DominionCards.DominionCard;
import com.xilconic.dominiontoolkit.DominionCards.DominionSet;

public class GameSetupRandomizer {
    private ArrayList<DominionCard> cardPool;
    private ArrayList<DominionCard> workset;

    /**
     * Creates a randomizer that configures a {@link GameSetup} randomly
     * on basis of a set of cards.
     * @param cardpool The collection of cards to work with. Can be null.
     */
    public GameSetupRandomizer(ArrayList<DominionCard> cardpool) {
        this.cardPool = cardpool != null ? cardpool : new ArrayList<DominionCard>();
    }

    /**
     * The card collection to work with.
     */
    public ArrayList<DominionCard> getCardpool() {
        return cardPool;
    }

    /**
     * Randomly generates a Kingdom card selection to play with.
     * @return A randomized selection of Kingdom cards from the card pool.
     * @throws RandomizationFailedException In case the randomizer was unable to generate a set of cards.
     */
    public GameSetup GetRandomGameSetup() {
        workset = removeBasicCardsFilter(cardPool);
        
        if (workset.size() < 10) {
            throw new RandomizationFailedException(String.format("Card pool is of size %d but should be at least 10", 
                    workset.size()));
        }
        
        Collections.shuffle(workset);
        
        ArrayList<DominionCard> kingdomCards = new ArrayList<DominionCard>(workset.subList(0, 10)); // Note: subList does not create a new list!
        GameSetup setup = new GameSetup(kingdomCards);

        // If required, find generate Bane card
        if (kingdomCards.contains(CardsDB.Cornucopia.YoungWitch)){
            ArrayList<DominionCard> baneCardCandidates = getBaneCardCandidates(workset.subList(10, workset.size()));
            if (baneCardCandidates.size() == 0){
                throw new RandomizationFailedException("Young Witch: No cards with cost of 2 or 3 available to pick as Bane card");
            }
            setup.setBaneCard(baneCardCandidates.get(0));
        }

        return setup;
    }

    /**
     * Creates a new {@link ArrayList<DominionCard>} based on {@link list}, filtering
     * out all {@link DominionSet.Basic} cards.
     * @param list Collection of {@link DominionCard} to be filtered.
     * @return The filtered set.
     */
    private ArrayList<DominionCard> removeBasicCardsFilter(List<DominionCard> list){
        ArrayList<DominionCard> filterResult = new ArrayList<DominionCard>();
        
        for (DominionCard dominionCard : list) {
            if (dominionCard.get_dominionSet() == DominionSet.Basic) continue;
                
            filterResult.add(dominionCard);
        }
        return filterResult;
    }
    
    private ArrayList<DominionCard> getBaneCardCandidates(List<DominionCard> list){
        ArrayList<DominionCard> filterResult = new ArrayList<DominionCard>();
        
        int cost = -1;
        for (DominionCard dominionCard : list) {
            cost = dominionCard.get_cost();
            if (cost != 2 && cost != 3) continue;
                
            filterResult.add(dominionCard);
        }
        return filterResult;
    }
}
