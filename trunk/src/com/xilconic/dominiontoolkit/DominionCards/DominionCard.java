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

public class DominionCard implements Parcelable {

	// private variables:
	private int _id; // database ID
	private String _name; // Card name
	private int _cost; // Card cost
	private boolean _isAction; // Is card an Action card
	private boolean _isAttack; // Is card an Attack card
	private boolean _isReaction; // Is card a Reaction card
	private boolean _isVictory; // Is card a Victory card
	private boolean _isTreasure; // Is card a Treasure card
	private boolean _isCurse; // Is card a Curse card
	private DominionSet _dominionSet; // Card set that this card belongs to
	
	/**
	 * @param _id ID of the card.
	 * @param _name Name of the card.
	 * @param _cost Buying cost of the card.
	 * @param _isAction Indicates if the card is an action card.
	 * @param _isAttack Indicates if the card is an attack card.
	 * @param _isReaction Indicates if the card is a reaction card.
	 * @param _isTreasure Indicates if the card is a treasure card.
	 * @param _isVictory Indicates if the card is a victory card.
	 * @param _dominionSet Indicates the set of the DominionCard.
	 */
	public DominionCard(int _id, String _name, int _cost, boolean _isAction,
			boolean _isAttack, boolean _isReaction, boolean _isTreasure,
			boolean _isVictory, boolean _isCurse, DominionSet _dominionSet) {
		this._id = _id;
		this._name = _name;
		this._cost = _cost;
		this._isAction = _isAction;
		this._isAttack = _isAttack;
		this._isReaction = _isReaction;
		this._isVictory = _isVictory;
		this._isTreasure = _isTreasure;
		this._isCurse = _isCurse;
		this._dominionSet = _dominionSet;
	}

	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
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
	
	public DominionSet get_dominionSet() {
		return _dominionSet;
	}

	public void set_dominionSet(DominionSet _dominionSet) {
		this._dominionSet = _dominionSet;
	}
	
	@Override
	public boolean equals(Object o){
		if (!o.getClass().equals(DominionCard.class)){
			super.equals(o);
		}
		DominionCard other = (DominionCard)o;
		return _id == other.get_id() &&
				_name.equals(other.get_name()) &&
				_cost == other.get_cost() &&
				_isAction == other.isAction() &&
				_isAttack == other.isAttack() &&
				_isReaction == other.isReaction() &&
				_isVictory == other.isVictory() &&
				_isTreasure == other.isTreasure() &&
				_isCurse == other.isCurse() &&
				_dominionSet == other.get_dominionSet();
	}

	// ==== Interface: Parcelable =======================
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int flags) {
		parcel.writeInt(_id);
		parcel.writeString(_name);
		parcel.writeInt(_cost);
		parcel.writeBooleanArray(new boolean[]{_isAction, _isAttack, _isReaction, _isVictory, _isTreasure, _isCurse});
		parcel.writeString(_dominionSet.name());
	}
	
	private DominionCard(Parcel parcel){
		_id = parcel.readInt();
		_name = parcel.readString();
		_cost = parcel.readInt();
		boolean[] flags = new boolean[6];
		parcel.readBooleanArray(flags);
		_isAction = flags[0];
		_isAttack = flags[1];
		_isReaction = flags[2];
		_isVictory = flags[3];
		_isTreasure = flags[4];
		_isCurse = flags[5];
		_dominionSet = DominionSet.valueOf(parcel.readString());
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
