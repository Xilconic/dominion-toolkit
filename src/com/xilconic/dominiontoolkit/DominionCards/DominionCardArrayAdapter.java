package com.xilconic.dominiontoolkit.DominionCards;

import java.util.ArrayList;

import com.xilconic.dominiontoolkit.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class DominionCardArrayAdapter extends ArrayAdapter<DominionCard> {
	private final ArrayList<DominionCard> _cardList;
	private final Context _context;
	
	public DominionCardArrayAdapter(Context context, ArrayList<DominionCard> cardList) {
		super(context, R.layout.dominion_card_array_item, cardList);
		_context = context;
		_cardList = cardList;
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
			
			dominionCardView.setTag(viewHolder);
		}
		
		ViewHolder viewHolder = (ViewHolder) dominionCardView.getTag();
		
		DominionCard card = _cardList.get(position);
		// Set card cost text:
		viewHolder.costText.setText(Integer.toString(card.get_cost()));
		
		// Set card name text:
		viewHolder.nameText.setText(card.get_name());
		
		return dominionCardView;
	}
	
	// View Holder pattern - Optimalization
	private static class ViewHolder {
		public TextView costText;
		public TextView nameText;
	}
	
}