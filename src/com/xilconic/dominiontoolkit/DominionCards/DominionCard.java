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
	private int _cost; // Card cost
	private boolean _isAction; // Is card an Action card
	private boolean _isAttack; // Is card an Attack card
	private boolean _isReaction; // Is card a Reaction card
	private boolean _isVictory; // Is card a Victory card
	private boolean _isTreasure; // Is card a Treasure card
	private boolean _isCurse; // Is card a Curse card
	
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
	 * @param _dominionSet Indicates the set of the DominionCard.
	 */
	public DominionCard(int _id, String _name, int _cost, boolean _isAction,
			boolean _isAttack, boolean _isReaction, boolean _isTreasure,
			boolean _isVictory, boolean _isCurse, DominionSet _dominionSet) {
		super(_id, _name, _dominionSet);
		this._cost = _cost;
		this._isAction = _isAction;
		this._isAttack = _isAttack;
		this._isReaction = _isReaction;
		this._isVictory = _isVictory;
		this._isTreasure = _isTreasure;
		this._isCurse = _isCurse;
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
	/*
	@Override
	public boolean equals(Object o){
		if (o == null){ return false;}
		if (getClass() != o.getClass()){return false;}
		
		if (!super.equals(o)){
			return false;
		}
		else {
			DominionCard other = (DominionCard)o;
			return  _cost == other.get_cost() &&
					_isAction == other.isAction() &&
					_isAttack == other.isAttack() &&
					_isReaction == other.isReaction() &&
					_isVictory == other.isVictory() &&
					_isTreasure == other.isTreasure() &&
					_isCurse == other.isCurse();
		}
	}*/
	

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
		parcel.writeBooleanArray(new boolean[]{_isAction, _isAttack, _isReaction, _isVictory, _isTreasure, _isCurse});
	}
	
	protected DominionCard(Parcel parcel){
		super(parcel);
		_cost = parcel.readInt();
		boolean[] flags = new boolean[6];
		parcel.readBooleanArray(flags);
		_isAction = flags[0];
		_isAttack = flags[1];
		_isReaction = flags[2];
		_isVictory = flags[3];
		_isTreasure = flags[4];
		_isCurse = flags[5];
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
