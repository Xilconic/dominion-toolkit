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
import com.xilconic.dominiontoolkit.Utils.ResourcesHelper;

import android.test.AndroidTestCase;

public class ResourcesHelperTest extends AndroidTestCase {
    //Required for JUnit:
    public ResourcesHelperTest() {}
    
    public void testGetCardTypes(){
        DominionCard card = new DominionCardBuilder(DominionItemType.TODO, DominionSet.Basic, 4).action().create();
        String result = ResourcesHelper.getCardTypes(getContext(), card, false);
        assertEquals("Actie", result);
        
        card = new DominionCardBuilder(DominionItemType.TODO, DominionSet.Basic, 4).action().attack().create();
        result = ResourcesHelper.getCardTypes(getContext(), card, false);
        assertEquals("Actie, Aanval", result);
        
        card = new DominionCardBuilder(DominionItemType.TODO, DominionSet.Basic, 4).action().attack().shelter().looter().duration().knight().create();
        result = ResourcesHelper.getCardTypes(getContext(), card, false);
        assertEquals("Actie, Aanval, Duurzaam, Ridder, Plunderaar, Onderdak", result);
    }
}
