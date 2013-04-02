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

public class DominionGameItem implements Parcelable{
	// private variables:
	protected int _id; // database ID
	protected String _name; // Game item name
	protected DominionSet _dominionSet; // Card set that this card belongs to
	
	public DominionGameItem(int id, String name, DominionSet set) {
		this._id = id;
		this._name = name;
		this._dominionSet = set;
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
	
		public DominionSet get_dominionSet() {
		return _dominionSet;
	}

	public void set_dominionSet(DominionSet _dominionSet) {
		this._dominionSet = _dominionSet;
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
		parcel.writeString(_dominionSet.name());
	}
	
	protected DominionGameItem(Parcel parcel){
		_id = parcel.readInt();
		_name = parcel.readString();
		_dominionSet = DominionSet.valueOf(parcel.readString());
	}

	public static final Parcelable.Creator<DominionGameItem> CREATOR = new Parcelable.Creator<DominionGameItem>()
	{
		public DominionGameItem createFromParcel(Parcel parcel) {
			return new DominionGameItem(parcel);
		}
		
		public DominionGameItem[] newArray(int size) {
			return new DominionGameItem[size];
		}
	};
	// = END Interface: Parcelable =======================

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_dominionSet == null) ? 0 : _dominionSet.hashCode());
		result = prime * result + _id;
		result = prime * result + ((_name == null) ? 0 : _name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj){ return true; }
		if (obj == null){ return false; }
		if (getClass() != obj.getClass()) { return false; }
		
		DominionGameItem other = (DominionGameItem) obj;
		if (_dominionSet != other._dominionSet)	return false;
		if (_id != other._id) return false;
		if (_name == null) {
			if (other._name != null) return false;
		} else if (!_name.equals(other._name)) return false;
		
		return true;
	}
}
