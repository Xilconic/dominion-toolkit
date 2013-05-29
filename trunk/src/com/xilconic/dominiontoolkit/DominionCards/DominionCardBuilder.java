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

public class DominionCardBuilder {
	private DominionItemType _type = null;
	private DominionSet _set = null;
	private int _cost = 0;
	private boolean _isAction, _isAttack, _isReaction, _isTreasure, _isVictory, _isCurse,
	_isDuration, _isRuin, _isShelter, _isKnight, _isLooter, _costsPotion;
	
	/**
	 * Sets up the initial must-have fields for a {@link DominionCard}.
	 * @param type The card definition.
	 * @param set The expansion set where this card belongs to.
	 * @param cost The cost of the card.
	 */
	public DominionCardBuilder(DominionItemType type, DominionSet set, int cost){
		this._type = type;
		this._set = set;
		this._cost = cost;
	}
	
	/**
	 * Marks the card as an action.
	 * @return This builder.
	 */
	public DominionCardBuilder action(){
		_isAction = true;
		return this;
	}
	
	/**
	 * Marks the card as an attack.
	 * @return This builder.
	 */
	public DominionCardBuilder attack(){
		_isAttack = true;
		return this;
	}
	
	/**
	 * Marks the card as a reaction.
	 * @return This builder.
	 */
	public DominionCardBuilder reaction(){
		_isReaction = true;
		return this;
	}
	
	/**
	 * Marks the card as a treasure.
	 * @return This builder.
	 */
	public DominionCardBuilder treasure(){
		_isTreasure = true;
		return this;
	}
	
	/**
	 * Marks the card as a victory.
	 * @return This builder.
	 */
	public DominionCardBuilder victory(){
		_isVictory = true;
		return this;
	}
	
	/**
	 * Marks the card as a curse.
	 * @return This builder.
	 */
	public DominionCardBuilder curse(){
		_isCurse = true;
		return this;
	}
	
	public DominionCardBuilder duration(){
	    _isDuration = true;
	    return this;
	}
	
    public DominionCardBuilder ruins() {
        _isRuin = true;
        return this;
    }
    
    public DominionCardBuilder shelter() {
        _isShelter = true;
        return this;
    }
    
    public DominionCardBuilder knight() {
        _isKnight = true;
        return this;
    }

    public DominionCardBuilder looter() {
        _isLooter = true;
        return this;
    }

    public DominionCardBuilder potionCost() {
        _costsPotion = true;
        return this;
    }
	
	/**
	 * Creates the card as configured.
	 * @return The built card.
	 */
	public DominionCard create(){
		preconditionCreate();
		DominionCard card = new DominionCard(_type, "", _set);
		card.set_cost(_cost);
		card.set_isAction(_isAction);
		card.set_isAttack(_isAttack);
		card.set_isReaction(_isReaction);
		card.set_isTreasure(_isTreasure);
		card.set_isVictory(_isVictory);
		card.set_isCurse(_isCurse);
		card.set_isDuration(_isDuration);
		card.set_isRuin(_isRuin);
		card.set_isShelter(_isShelter);
		card.set_isKnight(_isKnight);
		card.set_isLooter(_isLooter);
		card.set_costsPotion(_costsPotion);
		return card;
	}
	
	private void preconditionCreate(){
		if (_type == null) throw new IllegalArgumentException("Type must be set");
		if (_set == null) throw new IllegalArgumentException("Dominion Set must be set");
		if (_cost < 0) throw new IllegalArgumentException("Cost cannot be engative");
		if (!(_isAction || _isAttack || _isReaction || _isTreasure || _isVictory || _isCurse ||
		        _isDuration || _isShelter || _isRuin || _isKnight || _isLooter || _costsPotion)){
			throw new IllegalArgumentException("Must specify at least one play type");
		}
	}
}
