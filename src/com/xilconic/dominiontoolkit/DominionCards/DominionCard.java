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

import android.os.Parcel;
import android.os.Parcelable;

public class DominionCard extends DominionGameItem implements Parcelable {
	// private variables:
	private int _cost = 0; // Card cost
	private boolean _isAction = false; // Is card an Action card
	private boolean _isAttack = false; // Is card an Attack card
	private boolean _isReaction = false; // Is card a Reaction card
	private boolean _isVictory = false; // Is card a Victory card
	private boolean _isTreasure = false; // Is card a Treasure card
	private boolean _isCurse = false; // Is card a Curse card
	private boolean _isDuration = false; // Is card a Duration card
	private boolean _isRuin = false; // Is card a Ruin card
	private boolean _isShelter = false; // Is card a Shelter card
	private boolean _isKnight = false; // Is card a Knight card
	private boolean _isLooter = false; // Is card a Looter card
	
	public DominionCard(DominionItemType id, String name, DominionSet set){
		super(id, name, set);
	}
	
	/**
	 * @param _id ID of the card.
	 * @param _name Name of the card.
	 * @param _cost Buying cost of the card.
	 * @param _isAction Indicates if the card is an action card.
	 * @param _isAttack Indicates if the card is an attack card.
	 * @param _isReaction Indicates if the card is a reaction card.
	 * @param _isTreasure Indicates if the card is a treasure card.
	 * @param _isVictory Indicates if the card is a victory card.
	 * @param _isCurse Indicates if the card is a curse card.
	 * @param _isDuration Indicates if the card is a duration card.
	 * @param _isRuin Indicates if the card is a ruin card.
	 * @param _isShelter Indicates if the card is a shelter card.
	 * @param _isKnight Indicates if the card is a knight card.
	 * @param _isLooter Indicates if the card is a looter card.
	 * @param _dominionSet Indicates the set of the DominionCard.
	 */
	public DominionCard(int _id, String _name, int _cost, boolean _isAction,
			boolean _isAttack, boolean _isReaction, boolean _isTreasure,
			boolean _isVictory, boolean _isCurse, boolean _isDuration, 
			boolean _isRuin, boolean _isShelter, boolean _isKnight,
			boolean _isLooter,
			DominionSet _dominionSet) {
		super(DominionItemType.TODO, _name, _dominionSet);
		this._cost = _cost;
		this._isAction = _isAction;
		this._isAttack = _isAttack;
		this._isReaction = _isReaction;
		this._isVictory = _isVictory;
		this._isTreasure = _isTreasure;
		this._isCurse = _isCurse;
		this._isDuration = _isDuration;
		this._isRuin = _isRuin;
		this._isShelter = _isShelter;
		this._isKnight = _isKnight;
		this._isLooter = _isLooter;
	}
	
	public int get_cost() {
		return _cost;
	}
	public void set_cost(int _cost) {
		this._cost = _cost;
	}
	
	public boolean isAction() {
		return _isAction;
	}
	public void set_isAction(boolean _isAction) {
		this._isAction = _isAction;
	}
	
	public boolean isAttack() {
		return _isAttack;
	}
	public void set_isAttack(boolean _isAttack) {
		this._isAttack = _isAttack;
	}
	
	public boolean isReaction() {
		return _isReaction;
	}
	public void set_isReaction(boolean _isReaction) {
		this._isReaction = _isReaction;
	}
	
	public boolean isVictory() {
		return _isVictory;
	}
	public void set_isVictory(boolean _isVictory) {
		this._isVictory = _isVictory;
	}
	
	public boolean isTreasure() {
		return _isTreasure;
	}
	public void set_isTreasure(boolean _isTreasure) {
		this._isTreasure = _isTreasure;
	}
	
	public boolean isCurse() {
		return _isCurse;
	}
	public void set_isCurse(boolean _isCurse) {
		this._isCurse = _isCurse;
	}	

	public boolean isDuration() {
        return _isDuration;
    }

    public void set_isDuration(boolean _isDuration) {
        this._isDuration = _isDuration;
    }

    public boolean isRuin() {
        return _isRuin;
    }

    public void set_isRuin(boolean _isRuin) {
        this._isRuin = _isRuin;
    }

    public boolean isShelter() {
        return _isShelter;
    }

    public void set_isShelter(boolean _isShelter) {
        this._isShelter = _isShelter;
    }

    public boolean isKnight() {
        return _isKnight;
    }

    public void set_isKnight(boolean _isKnight) {
        this._isKnight = _isKnight;
    }

    public boolean isLooter() {
        return _isLooter;
    }

    public void set_isLooter(boolean _isLooter) {
        this._isLooter = _isLooter;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + _cost;
		result = prime * result + (_isAction ? 1231 : 1237);
		result = prime * result + (_isAttack ? 1231 : 1237);
		result = prime * result + (_isCurse ? 1231 : 1237);
		result = prime * result + (_isReaction ? 1231 : 1237);
		result = prime * result + (_isTreasure ? 1231 : 1237);
		result = prime * result + (_isVictory ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!super.equals(obj)) return false;
		if (getClass() != obj.getClass()) return false;
		
		DominionCard other = (DominionCard) obj;
		if (_cost != other._cost) return false;
		if (_isAction != other._isAction) return false;
		if (_isAttack != other._isAttack) return false;
		if (_isCurse != other._isCurse)	return false;
		if (_isReaction != other._isReaction) return false;
		if (_isTreasure != other._isTreasure) return false;
		if (_isVictory != other._isVictory)	return false;
		
		if (_isDuration != other._isDuration)   return false;
		if (_isRuin != other._isRuin)   return false;
		if (_isShelter != other._isShelter)   return false;
		if (_isKnight != other._isKnight)   return false;
		if (_isLooter != other._isLooter)   return false;
		
		return true;
	}

	// ==== Interface: Parcelable =======================
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int flags) {
		super.writeToParcel(parcel, flags);
		parcel.writeInt(_cost);
		parcel.writeBooleanArray(new boolean[]{
		        _isAction, _isAttack, _isReaction, _isVictory, _isTreasure, _isCurse,
		        _isDuration, _isRuin, _isShelter, _isKnight, _isLooter
		        });
	}
	
	protected DominionCard(Parcel parcel){
		super(parcel);
		_cost = parcel.readInt();
		boolean[] flags = new boolean[11];
		parcel.readBooleanArray(flags);
		_isAction = flags[0];
		_isAttack = flags[1];
		_isReaction = flags[2];
		_isVictory = flags[3];
		_isTreasure = flags[4];
		_isCurse = flags[5];
		_isDuration = flags[6];
		_isRuin = flags[7];
		_isShelter = flags[8];
		_isKnight = flags[9];
		_isLooter = flags[10];
	}

    public static final Parcelable.Creator<DominionCard> CREATOR = new Parcelable.Creator<DominionCard>()
	{
		public DominionCard createFromParcel(Parcel parcel) {
			return new DominionCard(parcel);
		}
		
		public DominionCard[] newArray(int size) {
			return new DominionCard[size];
		}
	};
	// = END Interface: Parcelable ======================	
}
