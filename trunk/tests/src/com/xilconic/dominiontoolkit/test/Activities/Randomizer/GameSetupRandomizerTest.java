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
package com.xilconic.dominiontoolkit.test.Activities.Randomizer;

import java.util.ArrayList;
import java.util.HashSet;

import junit.framework.Assert;

import com.xilconic.dominiontoolkit.Activities.GameSetup.GameSetup;
import com.xilconic.dominiontoolkit.Activities.Randomizer.GameSetupRandomizer;
import com.xilconic.dominiontoolkit.Activities.Randomizer.RandomizationFailedException;
import com.xilconic.dominiontoolkit.DominionCards.AmountOfDominionGameItem;
import com.xilconic.dominiontoolkit.DominionCards.CardsDB;
import com.xilconic.dominiontoolkit.DominionCards.DominionCard;
import com.xilconic.dominiontoolkit.DominionCards.DominionGameItem;
import com.xilconic.dominiontoolkit.DominionCards.DominionSet;

import android.test.AndroidTestCase;

public class GameSetupRandomizerTest extends AndroidTestCase{
    private GameSetupRandomizer randomizer;
    //  Required for JUnit
    public GameSetupRandomizerTest() {}

    protected void setUp() throws Exception{
        ArrayList<DominionCard> cardpool = new ArrayList<DominionCard>();
        randomizer = new GameSetupRandomizer(cardpool);
    }
    
    public void testGetRandomKingdomDeckWithTooFewCards(){
        ArrayList<DominionCard> cardpool = randomizer.getCardpool();
        cardpool.clear();
        
        try{
            randomizer.GetRandomGameSetup();
            Assert.fail("RandomizationFailedException expected");
        }
        catch(RandomizationFailedException e){
            assertEquals("Card pool is of size 0 but should be at least 10", e.getMessage());
        }
        
        ArrayList<DominionCard> collection = new ArrayList<DominionCard>();
        collection.add(new DominionCard(1, "t1", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(2, "t2", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(3, "t3", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(4, "t4", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(5, "t5", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(6, "t6", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(7, "t7", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(8, "t8", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(9, "t9", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        cardpool.addAll(collection);
        try{
            randomizer.GetRandomGameSetup();
            Assert.fail("RandomizationFailedException expected");
        }
        catch(RandomizationFailedException e){
            assertEquals("Card pool is of size 9 but should be at least 10", e.getMessage());
        }
    }
    
    public void testGetRandomKingdomDeck(){
        ArrayList<DominionCard> collection = new ArrayList<DominionCard>();
        collection.add(new DominionCard(1, "t1", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(2, "t2", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(3, "t3", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(4, "t4", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(5, "t5", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(6, "t6", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(7, "t7", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(8, "t8", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(9, "t9", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(10, "t10", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        ArrayList<DominionCard> cardpool = randomizer.getCardpool();
        cardpool.clear();
        cardpool.addAll(collection);
        
        GameSetup result = randomizer.GetRandomGameSetup();
        assertEquals("Result should be size 10", 
                10, result.getKingdomCardSetup().size());
        ArrayList<DominionGameItem> allKingdomCards = new ArrayList<DominionGameItem>(10);
        for (AmountOfDominionGameItem dominionCard : result.getKingdomCardSetup()) {
            allKingdomCards.add(dominionCard.getItem());
        }
        // Ensure all cards have been drawn:
        assertTrue("Random kingdom Deck of 10 cards should return all 10", 
                allKingdomCards.containsAll(collection));
        assertEquals(null, result.getBaneCard());
        
        collection = new ArrayList<DominionCard>();
        collection.add(new DominionCard(11, "t11", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(12, "t12", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(13, "t13", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(14, "t14", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(15, "t15", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(16, "t16", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(17, "t17", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(18, "t18", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(19, "t19", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(20, "t20", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        randomizer.getCardpool().addAll(collection);
        
        result = randomizer.GetRandomGameSetup();
        allKingdomCards.clear();
        for (AmountOfDominionGameItem dominionCard : result.getKingdomCardSetup()) {
            allKingdomCards.add(dominionCard.getItem());
        }
        HashSet<DominionGameItem> enforcedNonDuplicates = new HashSet<DominionGameItem>(allKingdomCards);
        assertEquals("Random kingdom Deck of 20 cards should return 10 unique cards", 
                10, enforcedNonDuplicates.size());
    }
    
    public void testGetRandomKingdomDeckDoesNotPickStandardCards(){
        ArrayList<DominionCard> collection = new ArrayList<DominionCard>();
        collection.add(new DominionCard(1, "t1", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Basic));
        collection.add(new DominionCard(2, "t2", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Basic));
        collection.add(new DominionCard(3, "t3", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Basic));
        collection.add(new DominionCard(4, "t4", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Basic));
        collection.add(new DominionCard(5, "t5", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Basic));
        collection.add(new DominionCard(6, "t6", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Basic));
        collection.add(new DominionCard(7, "t7", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Basic));
        collection.add(new DominionCard(8, "t8", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Basic));
        collection.add(new DominionCard(9, "t9", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Basic));
        collection.add(new DominionCard(10, "t10", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Basic));
        ArrayList<DominionCard> cardpool = randomizer.getCardpool();
        cardpool.clear();
        cardpool.addAll(collection);
        
        try{
            randomizer.GetRandomGameSetup();
            Assert.fail("IllegalStateException expected");
        }
        catch(RandomizationFailedException e){
            // Is expected
        }
    }

    public void testGetRandomKingdomDeckYoungWitchThowExceptionWhenUnableToSelectBaneCard(){
        ArrayList<DominionCard> collection = new ArrayList<DominionCard>();
        collection.add(new DominionCard(1, "t1", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(2, "t2", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(3, "t3", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(4, "t4", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(5, "t5", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(6, "t6", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(7, "t7", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(8, "t8", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(9, "t9", 1, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(CardsDB.Cornucopia.YoungWitch);
        ArrayList<DominionCard> cardpool = randomizer.getCardpool();
        cardpool.clear();
        cardpool.addAll(collection);
        
        try {
            randomizer.GetRandomGameSetup();
            Assert.fail("RandomizationFailedException expected");
        } catch (RandomizationFailedException e) {
            assertEquals("Young Witch: No cards with cost of 2 or 3 available to pick as Bane card", e.getMessage());
        }
    }
    
    public void testGetRandomKingdomDeckYoungWitchSetsBaneCard(){
        ArrayList<DominionCard> collection = new ArrayList<DominionCard>();
        collection.add(new DominionCard(1, "t1", 2, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(2, "t2", 2, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(3, "t3", 2, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(4, "t4", 2, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(5, "t5", 2, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(6, "t6", 2, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(7, "t7", 2, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(8, "t8", 2, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(9, "t9", 2, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(new DominionCard(10, "t10", 2, true, false, false, false, false, false, false, false, false, false, false, false, DominionSet.Dominion));
        collection.add(CardsDB.Cornucopia.YoungWitch);
        ArrayList<DominionCard> cardpool = randomizer.getCardpool();
        cardpool.clear();
        cardpool.addAll(collection);
        
        GameSetup result = randomizer.GetRandomGameSetup();
        boolean done = false;
        while(!done){
            for (AmountOfDominionGameItem amountOfItem : result.getKingdomCardSetup()) {
                // Require Young Witch to be part of Kingdom Cards to continue test
                if (amountOfItem.getItem().equals(CardsDB.Cornucopia.YoungWitch)){
                    done = true;
                    break;
                }
            }
            
            // Retry to get Young Witch in the kingdom cards selection
            result = randomizer.GetRandomGameSetup();
        }
        // Bane card should be selected:
        assertNotNull(result.getBaneCard());
    }
}
