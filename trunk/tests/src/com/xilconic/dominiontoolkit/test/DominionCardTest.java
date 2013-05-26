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
package com.xilconic.dominiontoolkit.test;

import com.xilconic.dominiontoolkit.DominionCards.DominionCard;
import com.xilconic.dominiontoolkit.DominionCards.DominionCardBuilder;
import com.xilconic.dominiontoolkit.DominionCards.DominionItemType;
import com.xilconic.dominiontoolkit.DominionCards.DominionSet;

import android.os.Parcel;
import android.test.AndroidTestCase;

public class DominionCardTest extends AndroidTestCase {

	private DominionCard cardToTest;
	// Required for JUnit
	public DominionCardTest(){}
	
	protected void setUp() throws Exception{
		cardToTest = new DominionCardBuilder(DominionItemType.Adventurer, DominionSet.Dominion, 4).action().create();
		super.setUp();
	}
	
	public void testPreCondition(){
		assertTrue("Card is not null", cardToTest != null);
		assertTrue("Cardcost of a DominionCard cannot be negative", cardToTest.get_cost() >= 0);
	}
	
	public void testEquals(){
		DominionCard cardToEquate = new DominionCardBuilder(DominionItemType.Adventurer, DominionSet.Dominion, 4).action().create();
		assertEquals("Cards should be equal", cardToTest, cardToEquate);
		assertEquals("Cards should be equal", cardToEquate, cardToTest);
		
		cardToEquate = new DominionCardBuilder(DominionItemType.Baron, DominionSet.Dominion, 4).action().create();
		assertFalse("Cards should not be equal", cardToTest.equals(cardToEquate));
		cardToEquate = new DominionCardBuilder(DominionItemType.Adventurer, DominionSet.Basic, 4).action().create();
		assertFalse("Cards should not be equal", cardToTest.equals(cardToEquate));
		cardToEquate = new DominionCardBuilder(DominionItemType.Adventurer, DominionSet.Dominion, 3).action().create();
		assertFalse("Cards should not be equal", cardToTest.equals(cardToEquate));
		cardToEquate = new DominionCardBuilder(DominionItemType.Adventurer, DominionSet.Dominion, 4).action().attack().create();
		assertFalse("Cards should not be equal", cardToTest.equals(cardToEquate));
		cardToEquate = new DominionCardBuilder(DominionItemType.Adventurer, DominionSet.Dominion, 4).action().reaction().create();
		assertFalse("Cards should not be equal", cardToTest.equals(cardToEquate));
		cardToEquate = new DominionCardBuilder(DominionItemType.Adventurer, DominionSet.Dominion, 4).action().treasure().create();
		assertFalse("Cards should not be equal", cardToTest.equals(cardToEquate));
		cardToEquate = new DominionCardBuilder(DominionItemType.Adventurer, DominionSet.Dominion, 4).action().victory().create();
		assertFalse("Cards should not be equal", cardToTest.equals(cardToEquate));
		cardToEquate = new DominionCardBuilder(DominionItemType.Adventurer, DominionSet.Dominion, 4).action().curse().create();
		assertFalse("Cards should not be equal", cardToTest.equals(cardToEquate));
	}

	public void testParcelableCreator(){
		Parcel parcel = Parcel.obtain();
		DominionCard card = new DominionCard(0, "test", 5, true, true, true, true, true, true, true, true, true, true, true, DominionSet.BlackMarketPromo);
		card.writeToParcel(parcel, 0);
		
		// Done writing, reset parcel for reading:
		parcel.setDataPosition(0);
		
		// Retrieve:
		DominionCard createdFromParcel = DominionCard.CREATOR.createFromParcel(parcel);
		assertEquals("Cards should be equal", card, createdFromParcel);
	}
}
