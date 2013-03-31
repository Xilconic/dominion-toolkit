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
package com.xilconic.dominiontoolkit.Activities.RandomizerActivityClasses;

import java.util.ArrayList;
import java.util.Collections;

import com.xilconic.dominiontoolkit.DominionCards.DominionCard;
import com.xilconic.dominiontoolkit.DominionCards.DominionSet;

public class DominionCardRandomizer {
	private ArrayList<DominionCard> _cardpool;
	private ArrayList<DominionCard> _workset;

	public DominionCardRandomizer(ArrayList<DominionCard> cardpool){
		_cardpool = cardpool;
	}
	
	public ArrayList<DominionCard> GetRandomKingdomDeck(){
		_workset = removeBasicCardsFilter(_cardpool);
		
		if (_workset.size() < 10) {
			throw new IllegalStateException(String.format("Workset is of size %d but should be at least 10", 
					_workset.size()));
		}
		
		Collections.shuffle(_workset);
		
		return new ArrayList<DominionCard>(_workset.subList(0, 10)); // Note: subList does not create a new list!
	}

	public ArrayList<DominionCard> getCardpool() {
		return _cardpool;
	}
	
	/**
	 * Creates a new {@link ArrayList<DominionCard>} based on {@link list}, filtering
	 * out all {@link DominionSet.Basic} cards.
	 * @param list Collection of {@link DominionCard} to be filtered.
	 * @return The filtered set.
	 */
	private ArrayList<DominionCard> removeBasicCardsFilter(ArrayList<DominionCard> list){
		ArrayList<DominionCard> filterResult = new ArrayList<DominionCard>();
		
		for (DominionCard dominionCard : list) {
			if (dominionCard.get_dominionSet() == DominionSet.Basic) continue;
				
			filterResult.add(dominionCard);
		}
		return filterResult;
	}
}
