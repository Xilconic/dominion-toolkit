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
package com.xilconic.dominiontoolkit.DominionCards;

/**
 * A tuple of a {@link DominionGameItem} and the number of times it occurs.
 * @author Bas des Bouvrie
 */
public class AmountOfDominionGameItem {
	private DominionGameItem item;
	private int count;
	private boolean isCard;
	
	/**
	 * Creates a tuple of a {@link DominionGameItem} and the number of times
	 * it occurs.
	 * @param item The item; Must not be null.
	 * @param count The number of occurrences of the item; Cannot be less than 0;
	 */
	public AmountOfDominionGameItem(DominionGameItem item, int count){
		// Preconditions:
		if (item == null){
			throw new IllegalArgumentException("Item must not be null");
		}
		if (count < 0){
			throw new IllegalArgumentException("count must not be < 0");
		}
		
		this.item = item;
		this.count = count;
		this.isCard = item instanceof DominionCard;
	}
	
	/**
	 * The item.
	 * @return
	 */
	public DominionGameItem getItem(){
		return item;
	}
	
	/**
	 * The number of occurrences.
	 * @return
	 */
	public int getCount(){
		return count;
	}
	
	/**
	 * Checks if the item is a {@link DominionCard} of something else.
	 * @return
	 */
	public boolean isCard(){
		return isCard;
	}
	
	/**
	 * Sets the number of occurrences.
	 * @param cardCount Number of occurrences; Cannot be less than 0.
	 */
	public void setCount(int cardCount){
		if (cardCount < 0){
			throw new IllegalArgumentException("count must not be < 0");
		}
		count = cardCount;
	}
}
