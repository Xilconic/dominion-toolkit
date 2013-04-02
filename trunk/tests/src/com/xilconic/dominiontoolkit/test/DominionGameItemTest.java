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

import android.os.Parcel;
import android.test.AndroidTestCase;

import com.xilconic.dominiontoolkit.DominionCards.DominionItemType;
import com.xilconic.dominiontoolkit.DominionCards.DominionGameItem;
import com.xilconic.dominiontoolkit.DominionCards.DominionSet;

public class DominionGameItemTest extends AndroidTestCase {
	private DominionGameItem itemToTest;
	
	// Required for JUnit:
	public DominionGameItemTest(){
		
	}
	
	protected void setUp() throws Exception{
		itemToTest = new DominionGameItem(DominionItemType.Copper, "test", DominionSet.Basic);
		super.setUp();
	}
	
	public void testPreCondition(){
		assertTrue("Item is not null", itemToTest != null);
	}
	
	public void testEquals(){
		DominionGameItem itemToEquate = new DominionGameItem(DominionItemType.Copper, "test", DominionSet.Basic);
		assertEquals("Items should be equal", itemToTest, itemToEquate);
		assertEquals("Items should be equal", itemToEquate, itemToTest);
	}
	
	public void testParcelableCreator(){
		Parcel parcel = Parcel.obtain();
		itemToTest.writeToParcel(parcel, 0);
		
		// Done writing, reset parcel for reading:
		parcel.setDataPosition(0);
		
		// Retrieve:
		DominionGameItem createdFromParcel = DominionGameItem.CREATOR.createFromParcel(parcel);
		assertEquals("Items should be equal", itemToTest, createdFromParcel);
	}
}
