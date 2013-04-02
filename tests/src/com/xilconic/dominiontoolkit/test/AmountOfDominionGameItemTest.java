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

import com.xilconic.dominiontoolkit.DominionCards.AmountOfDominionGameItem;
import com.xilconic.dominiontoolkit.DominionCards.DominionCard;
import com.xilconic.dominiontoolkit.DominionCards.DominionItemType;
import com.xilconic.dominiontoolkit.DominionCards.DominionGameItem;
import com.xilconic.dominiontoolkit.DominionCards.DominionSet;

import android.test.AndroidTestCase;

public class AmountOfDominionGameItemTest extends AndroidTestCase {
	// Required for JUnit:
	public AmountOfDominionGameItemTest() {}
	
	public void testAmountOfDominionGameItemAsItem(){
		DominionGameItem item = new DominionGameItem(DominionItemType.Copper, "test", DominionSet.Basic);
		AmountOfDominionGameItem itemToTest = new AmountOfDominionGameItem(item, 3);
		
		assertEquals(3, itemToTest.getCount());
		assertEquals(item, itemToTest.getItem());
		assertEquals(false, itemToTest.isCard());
	}
	
	public void testAmountOfDominionGameItemAsCard(){
		DominionCard item = new DominionCard(1, "test", 2, true, false, false, false, false, false, DominionSet.Basic);
		AmountOfDominionGameItem itemToTest = new AmountOfDominionGameItem(item, 3);
		
		assertEquals(3, itemToTest.getCount());
		assertEquals(item, itemToTest.getItem());
		assertEquals(true, itemToTest.isCard());
	}
}
