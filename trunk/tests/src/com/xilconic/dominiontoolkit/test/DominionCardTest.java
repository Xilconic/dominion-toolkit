package com.xilconic.dominiontoolkit.test;

import com.xilconic.dominiontoolkit.DominionCards.DominionCard;
import com.xilconic.dominiontoolkit.DominionCards.DominionSet;

import android.os.Parcel;
import android.test.AndroidTestCase;

public class DominionCardTest extends AndroidTestCase {

	private DominionCard cardToTest;
	// Required for JUnit
	public DominionCardTest(){}
	
	protected void setUp() throws Exception{
		cardToTest = new DominionCard(1, "test", 4, true, false, false, false, false, false, DominionSet.Basic);
		super.setUp();
	}
	
	public void testPreCondition(){
		assertTrue("Card is not null", cardToTest != null);
		assertTrue("Cardcost of a DominionCard cannot be negative", cardToTest.get_cost() >= 0);
	}
	
	public void testEquals(){
		DominionCard cardToEquate = new DominionCard(1, "test", 4, true, false, false, false, false, false, DominionSet.Basic);
		assertEquals("Cards should be equal", cardToTest, cardToEquate);
		
		cardToEquate = new DominionCard(2, "test", 4, true, false, false, false, false, false, DominionSet.Basic);
		assertFalse("Cards should not be equal", cardToTest.equals(cardToEquate));
		cardToEquate = new DominionCard(1, "test1", 4, true, false, false, false, false, false, DominionSet.Basic);
		assertFalse("Cards should not be equal", cardToTest.equals(cardToEquate));
		cardToEquate = new DominionCard(1, "test", 3, false, false, false, false, false, false, DominionSet.Basic);
		assertFalse("Cards should not be equal", cardToTest.equals(cardToEquate));
		cardToEquate = new DominionCard(1, "test", 4, true, true, false, false, false, false, DominionSet.Basic);
		assertFalse("Cards should not be equal", cardToTest.equals(cardToEquate));
		cardToEquate = new DominionCard(1, "test", 4, true, false, true, false, false, false, DominionSet.Basic);
		assertFalse("Cards should not be equal", cardToTest.equals(cardToEquate));
		cardToEquate = new DominionCard(1, "test", 4, true, false, false, true, false, false, DominionSet.Basic);
		assertFalse("Cards should not be equal", cardToTest.equals(cardToEquate));
		cardToEquate = new DominionCard(1, "test", 4, true, false, false, false, true, false, DominionSet.Basic);
		assertFalse("Cards should not be equal", cardToTest.equals(cardToEquate));
		cardToEquate = new DominionCard(1, "test", 4, true, false, false, false, false, true, DominionSet.Basic);
		assertFalse("Cards should not be equal", cardToTest.equals(cardToEquate));
		cardToEquate = new DominionCard(1, "test", 4, true, false, false, false, false, false, DominionSet.Dominion);
		assertFalse("Cards should not be equal", cardToTest.equals(cardToEquate));
	}

	public void testParcelableCreator(){
		Parcel parcel = Parcel.obtain();
		cardToTest.writeToParcel(parcel, 0);
		
		// Done writing, reset parcel for reading:
		parcel.setDataPosition(0);
		
		// Retrieve:
		DominionCard createdFromParcel = DominionCard.CREATOR.createFromParcel(parcel);
		assertEquals("Cards should be equal", cardToTest, createdFromParcel);
	}
}
