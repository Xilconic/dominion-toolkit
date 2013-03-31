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

import java.util.ArrayList;

import com.xilconic.dominiontoolkit.R;
import com.xilconic.dominiontoolkit.Utils.DominionResourcesHelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DominionCardArrayAdapter extends ArrayAdapter<DominionCard> {
	private final ArrayList<DominionCard> _cardList;
	private final Context _context;
	private final StringBuilder stringBuilder;
	
	public DominionCardArrayAdapter(Context context, ArrayList<DominionCard> cardList) {
		super(context, R.layout.dominion_card_array_item, cardList);
		_context = context;
		_cardList = cardList;
		stringBuilder = new StringBuilder(" ");
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View dominionCardView = convertView;
		if (dominionCardView == null)
		{
			LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			dominionCardView = inflater.inflate(R.layout.dominion_card_array_item, parent, false);
			
			// Setup ViewHolder
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.costText = (TextView) dominionCardView.findViewById(R.id.costText);
			viewHolder.nameText = (TextView) dominionCardView.findViewById(R.id.cardNameText);
			viewHolder.cardTypesText = (TextView) dominionCardView.findViewById(R.id.cardTypeText);
			viewHolder.iconPlaceHolder = (RelativeLayout) dominionCardView.findViewById(R.id.set_icon);
			
			dominionCardView.setTag(viewHolder);
		}
		
		ViewHolder viewHolder = (ViewHolder) dominionCardView.getTag();
		
		DominionCard card = _cardList.get(position);
		// Set card cost text:
		viewHolder.costText.setText(Integer.toString(card.get_cost()));
		
		// Set card name text:
		viewHolder.nameText.setText(card.get_name());
		
		// Set cardTypeText:
		viewHolder.cardTypesText.setText(getCardTypes(card));
		
		// Set icon image:
		viewHolder.iconPlaceHolder.setBackgroundDrawable(DominionResourcesHelper.GetSetIcon(_context, card.get_dominionSet()));
		
		return dominionCardView;
	}
	
	private CharSequence getCardTypes(DominionCard card) {
		stringBuilder.delete(0, stringBuilder.length());
		
		boolean firstType = true;
		if (card.isAction()){
			stringBuilder.append(_context.getResources().getString(R.string.Cards_Types_Action));
			firstType = false;
		}
		
		if (card.isAttack()){
			if (!firstType) stringBuilder.append(", ");
			stringBuilder.append(_context.getResources().getString(R.string.Cards_Types_Attack));
			firstType = false;
		}
		
		if (card.isReaction()){
			if (!firstType) stringBuilder.append(", ");
			stringBuilder.append(_context.getResources().getString(R.string.Cards_Types_Reaction));
			firstType = false;
		}
		
		if (card.isCurse()){
			if (!firstType) stringBuilder.append(", ");
			stringBuilder.append(_context.getResources().getString(R.string.Cards_Types_Curse));
			firstType = false;
		}
		
		if (card.isTreasure()){
			if (!firstType) stringBuilder.append(", ");
			stringBuilder.append(_context.getResources().getString(R.string.Cards_Types_Treasure));
			firstType = false;
		}
		
		if (card.isVictory()){
			if (!firstType) stringBuilder.append(", ");
			stringBuilder.append(_context.getResources().getString(R.string.Cards_Types_Victory));
			firstType = false;
		}

		return stringBuilder.toString();
	}

	// View Holder pattern - Optimization
	private static class ViewHolder {
		public TextView costText;
		public TextView nameText;
		public TextView cardTypesText;
		public RelativeLayout iconPlaceHolder;
	}
	
}