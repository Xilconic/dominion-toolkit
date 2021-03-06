package com.xilconic.dominiontoolkit.Activities.GameSetup;

import java.util.ArrayList;

import com.xilconic.dominiontoolkit.R;
import com.xilconic.dominiontoolkit.DominionCards.AmountOfDominionGameItem;
import com.xilconic.dominiontoolkit.DominionCards.CardsDB;
import com.xilconic.dominiontoolkit.DominionCards.DominionCard;
import com.xilconic.dominiontoolkit.Utils.ResourcesHelper;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GameSetupExpandableListAdapter extends BaseExpandableListAdapter {
	private LayoutInflater inflater;
	private ArrayList<GameSetupParentItem> parentItems;
	private GameSetupParentItem eachPlayerStartsWithGroup;
	private GameSetupParentItem globalStartsWithGroup;
	private GameSetupParentItem kingdomCardsStartsWithGroup;
	private GameSetup setup;
	private Context _context;
	
	public GameSetupExpandableListAdapter(Context context, GameSetup gameSetup){
		this.setup = gameSetup;
		this._context = context;
		inflater = LayoutInflater.from(context);
		new StringBuilder(" ");
		
		if (!setup.isFullySetup()){
			setup.SetUp();
		}
		
		globalStartsWithGroup = new GameSetupParentItem();
		globalStartsWithGroup.setTitle("Game starts with:");
		globalStartsWithGroup.setArrayChildren(setup.getGlobalStartingItems());
		
		eachPlayerStartsWithGroup = new GameSetupParentItem();
		eachPlayerStartsWithGroup.setTitle("Each player starts with:");
		eachPlayerStartsWithGroup.setArrayChildren(setup.GetPlayerStartingItems());
		
		kingdomCardsStartsWithGroup = new GameSetupParentItem();
		kingdomCardsStartsWithGroup.setTitle("Kingdom cards:");
		ArrayList<AmountOfDominionGameItem> kingdomCards = setup.getKingdomCardSetup();
        
		// Insert Bane card is required:
		AmountOfDominionGameItem baneCardAmount = setup.getBaneCard();
        if (baneCardAmount != null){
		    for (int i = 0; i < kingdomCards.size(); i++) {
                if (kingdomCards.get(i).getItem().equals(CardsDB.Cornucopia.YoungWitch) && !kingdomCards.contains(baneCardAmount)){
                    kingdomCards.add(i+1, baneCardAmount);
                }
            }
		}
		kingdomCardsStartsWithGroup.setArrayChildren(kingdomCards);
		
		parentItems = new ArrayList<GameSetupParentItem>(3);
		parentItems.add(kingdomCardsStartsWithGroup);
		parentItems.add(globalStartsWithGroup);
		parentItems.add(eachPlayerStartsWithGroup);
	}
	
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return parentItems.get(groupPosition).getArrayChildren().get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// Can do this, because child order will never change
		// between visualization and data source.
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		if (convertView == null){
			convertView = inflater.inflate(R.layout.dominion_card_array_item, parent, false);
			
			// Setup ViewHolder
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.costText = (TextView) convertView.findViewById(R.id.costText);
			viewHolder.nameText = (TextView) convertView.findViewById(R.id.cardNameText);
			viewHolder.cardTypesText = (TextView) convertView.findViewById(R.id.cardTypeText);
			viewHolder.countText = (TextView) convertView.findViewById(R.id.countText);
			viewHolder.iconPlaceHolder = (ImageView) convertView.findViewById(R.id.set_icon);
			viewHolder.potionIcon = (ImageView) convertView.findViewById(R.id.potionImageView);
			
			convertView.setTag(viewHolder);
		}
		
		AmountOfDominionGameItem AmountOfItem = parentItems.get(groupPosition).getArrayChildren().get(childPosition);
		ViewHolder viewHolder = (ViewHolder) convertView.getTag();
		
		viewHolder.countText.setText(Integer.toString(AmountOfItem.getCount()));
		
		AmountOfDominionGameItem baneCardAmount = setup.getBaneCard();
        boolean isBaneCard = baneCardAmount != null && AmountOfItem.getItem().equals(baneCardAmount.getItem());
		
		// Set card cost text and CardTypes:
		if(AmountOfItem.getItem() instanceof DominionCard){
			DominionCard card = (DominionCard)AmountOfItem.getItem();
			viewHolder.costText.setText(Integer.toString(card.get_cost()));
			viewHolder.cardTypesText.setText(ResourcesHelper.getCardTypes(_context, card, isBaneCard));
			if (card.is_costsPotion()){
			    viewHolder.potionIcon.setVisibility(View.VISIBLE);
			}
			else{
			    viewHolder.potionIcon.setVisibility(View.GONE);
			}
			
			convertView.findViewById(R.id.coin_bg).setVisibility(View.VISIBLE);
		}
		else{
			viewHolder.costText.setText("");
			viewHolder.cardTypesText.setText("");
			viewHolder.potionIcon.setVisibility(View.GONE);
			
			convertView.findViewById(R.id.coin_bg).setVisibility(View.INVISIBLE);
		}
		
		if (isBaneCard){
		    convertView.findViewById(R.id.arrowImage).setVisibility(View.VISIBLE);
		}else{
		    convertView.findViewById(R.id.arrowImage).setVisibility(View.GONE);
		}
		
		// Set card name text:
		viewHolder.nameText.setText(ResourcesHelper.GetDominionItemName(_context, AmountOfItem.getItem()));
		
		// Set icon image:
		viewHolder.iconPlaceHolder.setImageDrawable(ResourcesHelper.GetSetIcon(_context, AmountOfItem.getItem().get_dominionSet()));
		
		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return parentItems.get(groupPosition).getArrayChildren().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return parentItems.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return parentItems.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		// Can do this, as group order will never change
		// between visualization and data source.
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		if (convertView == null){
			convertView = inflater.inflate(R.layout.dominion_game_setup_parent_list_item, parent, false);
		}
		
		// TODO: Apply View Holder pattern here:
		TextView textView = (TextView) convertView.findViewById(R.id.dominion_game_setup_parent_textview);
		textView.setText(getGroup(groupPosition).toString());
		
		// Game starts with group:
				View highlightLayer = convertView.findViewById(R.id.dominion_game_setup_parent_item_highlight);
		if (groupPosition == 1){
		    int globalStartsWithSize = globalStartsWithGroup.getArrayChildren().size();
            if (globalStartsWithSize == 6 || globalStartsWithSize == 0){
                highlightLayer.setVisibility(View.INVISIBLE);
            }
            else {
                highlightLayer.setVisibility(View.VISIBLE);
            }
		}else if (groupPosition == 2){
		    int eachPlayerStartsWithSize = eachPlayerStartsWithGroup.getArrayChildren().size();
		    if (eachPlayerStartsWithSize == 2 || eachPlayerStartsWithSize == 0){
                highlightLayer.setVisibility(View.INVISIBLE);
            }
            else {
                highlightLayer.setVisibility(View.VISIBLE);
            }
		}else{
		    highlightLayer.setVisibility(View.INVISIBLE);
		}

		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

	@Override
	public void registerDataSetObserver(DataSetObserver observer){
		super.registerDataSetObserver(observer);
	}
	
	public int getEachPlayerStartsWithGroupId(){
		return parentItems.indexOf(eachPlayerStartsWithGroup);
	}
	
	public int getGlobalStartsWithGroupId(){
		return parentItems.indexOf(globalStartsWithGroup);
	}
	
	public int getKingdomCardsGroupId(){
		return parentItems.indexOf(kingdomCardsStartsWithGroup);
	}
	
	// View Holder pattern - Optimization
	private static class ViewHolder {
		public TextView costText;
		public TextView nameText;
		public TextView cardTypesText;
		public TextView countText;
		public ImageView iconPlaceHolder;
		public ImageView potionIcon;
	}
}
