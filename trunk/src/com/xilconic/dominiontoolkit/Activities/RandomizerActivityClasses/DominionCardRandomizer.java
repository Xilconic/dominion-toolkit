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
