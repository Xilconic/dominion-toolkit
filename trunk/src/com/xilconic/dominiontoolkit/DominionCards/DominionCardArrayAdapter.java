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
import com.xilconic.dominiontoolkit.Utils.ResourcesHelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DominionCardArrayAdapter extends ArrayAdapter<DominionCard> {
	private final ArrayList<DominionCard> _cardList;
	private final Context _context;
	
	public DominionCardArrayAdapter(Context context, ArrayList<DominionCard> cardList) {
		super(context, R.layout.dominion_card_array_item, cardList);
		_context = context;
		_cardList = cardList;
		new StringBuilder(" ");
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
			viewHolder.iconPlaceHolder = (ImageView) dominionCardView.findViewById(R.id.set_icon);
			viewHolder.potionIcon = (ImageView) dominionCardView.findViewById(R.id.potionImageView);
			
			// Collapse and hide the card count and reference arrow image:
			dominionCardView.findViewById(R.id.countText).setVisibility(View.GONE);
			dominionCardView.findViewById(R.id.arrowImage).setVisibility(View.GONE);
			
			dominionCardView.setTag(viewHolder);
		}
		
		ViewHolder viewHolder = (ViewHolder) dominionCardView.getTag();
		
		DominionCard card = _cardList.get(position);
		// Set card cost text:
		viewHolder.costText.setText(Integer.toString(card.get_cost()));
		
		// Set card name text:
		viewHolder.nameText.setText(ResourcesHelper.GetDominionCardName(_context, card));
		
		// Set cardTypeText:
		viewHolder.cardTypesText.setText(ResourcesHelper.getCardTypes(_context, card, false));
		
		// Set icon image:
		viewHolder.iconPlaceHolder.setImageDrawable(ResourcesHelper.GetSetIcon(_context, card.get_dominionSet()));
		
		if(card.is_costsPotion()){
		    viewHolder.potionIcon.setVisibility(View.VISIBLE);
		}else{
		    viewHolder.potionIcon.setVisibility(View.GONE);
		}
		    
		
		return dominionCardView;
	}
	
	// View Holder pattern - Optimization
	private static class ViewHolder {
		public TextView costText;
		public TextView nameText;
		public TextView cardTypesText;
		public ImageView iconPlaceHolder;
		public ImageView potionIcon;
	}
	
}