package com.xilconic.dominiontoolkit.test.Activities.Randomizer;

import java.util.ArrayList;
import java.util.HashSet;

import junit.framework.Assert;

import com.xilconic.dominiontoolkit.Activities.RandomizerActivityClasses.DominionCardRandomizer;
import com.xilconic.dominiontoolkit.DominionCards.DominionCard;
import com.xilconic.dominiontoolkit.DominionCards.DominionSet;

import android.test.AndroidTestCase;

public class DominionCardRandomizerTest extends AndroidTestCase {
	private DominionCardRandomizer randomizer;
	
	// Required for JUnit
	public DominionCardRandomizerTest(){}
	
	protected void setUp() throws Exception{
		ArrayList<DominionCard> cardpool = new ArrayList<DominionCard>();
		randomizer = new DominionCardRandomizer(cardpool);
	}
	
	public void testPreCondition(){
		assertTrue("Randomizer cardpool cannot be null", randomizer.getCardpool() != null);
	}
	
	public void testGetRandomKingdomDeckWithTooFewCards(){
		ArrayList<DominionCard> cardpool = randomizer.getCardpool();
		cardpool.clear();
		
		try{
			randomizer.GetRandomKingdomDeck();
			Assert.fail("IllegalStateException expected");
		}
		catch(IllegalStateException e){
			// Is expected
		}
		
		ArrayList<DominionCard> collection = new ArrayList<DominionCard>();
		collection.add(new DominionCard(1, "t1", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(2, "t2", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(3, "t3", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(4, "t4", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(5, "t5", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(6, "t6", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(7, "t7", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(8, "t8", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(9, "t9", 1, true, false, false, false, false, false, DominionSet.Dominion));
		cardpool.addAll(collection);
		try{
			randomizer.GetRandomKingdomDeck();
			Assert.fail("IllegalStateException expected");
		}
		catch(IllegalStateException e){
			// Is expected
		}
	}
	
	public void testGetRandomKingdomDeck(){
		ArrayList<DominionCard> collection = new ArrayList<DominionCard>();
		collection.add(new DominionCard(1, "t1", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(2, "t2", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(3, "t3", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(4, "t4", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(5, "t5", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(6, "t6", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(7, "t7", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(8, "t8", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(9, "t9", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(10, "t10", 1, true, false, false, false, false, false, DominionSet.Dominion));
		ArrayList<DominionCard> cardpool = randomizer.getCardpool();
		cardpool.clear();
		cardpool.addAll(collection);
		
		ArrayList<DominionCard> result = randomizer.GetRandomKingdomDeck();
		assertEquals("Result should be size 10", 
				10, result.size());
		// Ensure all cards have been drawn:
		assertTrue("Random kingdom Deck of 10 cards should return all 10", 
				result.containsAll(collection));
		
		collection = new ArrayList<DominionCard>();
		collection.add(new DominionCard(11, "t11", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(12, "t12", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(13, "t13", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(14, "t14", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(15, "t15", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(16, "t16", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(17, "t17", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(18, "t18", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(19, "t19", 1, true, false, false, false, false, false, DominionSet.Dominion));
		collection.add(new DominionCard(20, "t20", 1, true, false, false, false, false, false, DominionSet.Dominion));
		randomizer.getCardpool().addAll(collection);
		
		result = randomizer.GetRandomKingdomDeck();
		HashSet<DominionCard> enforcedNonDuplicates = new HashSet<DominionCard>(result);
		assertEquals("Random kingdom Deck of 20 cards should return 10 unique cards", 
				10, enforcedNonDuplicates.size());
	}
	
	public void testGetRandomKingdomDeckDoesNotPickStandardCards(){
		ArrayList<DominionCard> collection = new ArrayList<DominionCard>();
		collection.add(new DominionCard(1, "t1", 1, true, false, false, false, false, false, DominionSet.Basic));
		collection.add(new DominionCard(2, "t2", 1, true, false, false, false, false, false, DominionSet.Basic));
		collection.add(new DominionCard(3, "t3", 1, true, false, false, false, false, false, DominionSet.Basic));
		collection.add(new DominionCard(4, "t4", 1, true, false, false, false, false, false, DominionSet.Basic));
		collection.add(new DominionCard(5, "t5", 1, true, false, false, false, false, false, DominionSet.Basic));
		collection.add(new DominionCard(6, "t6", 1, true, false, false, false, false, false, DominionSet.Basic));
		collection.add(new DominionCard(7, "t7", 1, true, false, false, false, false, false, DominionSet.Basic));
		collection.add(new DominionCard(8, "t8", 1, true, false, false, false, false, false, DominionSet.Basic));
		collection.add(new DominionCard(9, "t9", 1, true, false, false, false, false, false, DominionSet.Basic));
		collection.add(new DominionCard(10, "t10", 1, true, false, false, false, false, false, DominionSet.Basic));
		ArrayList<DominionCard> cardpool = randomizer.getCardpool();
		cardpool.clear();
		cardpool.addAll(collection);
		
		try{
			randomizer.GetRandomKingdomDeck();
			Assert.fail("IllegalStateException expected");
		}
		catch(IllegalStateException e){
			// Is expected
		}
	}
}
