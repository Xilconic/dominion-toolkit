package com.xilconic.dominiontoolkit.Activities.GameSetup;

import java.util.ArrayList;

import com.xilconic.dominiontoolkit.R;
import com.xilconic.dominiontoolkit.DominionCards.AmountOfDominionGameItem;
import com.xilconic.dominiontoolkit.DominionCards.DominionCard;
import com.xilconic.dominiontoolkit.DominionCards.DominionGameItem;
import com.xilconic.dominiontoolkit.Utils.ResourcesHelper;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GameSetupExpandableListAdapter extends BaseExpandableListAdapter {
	private LayoutInflater inflater;
	private ArrayList<GameSetupParentItem> parentItems;
	private GameSetupParentItem eachPlayerStartsWithGroup;
	private GameSetupParentItem globalStartsWithGroup;
	private GameSetupParentItem kingdomCardsStartsWithGroup;
	private GameSetup setup;
	private Context _context;
	private final StringBuilder stringBuilder;
	
	public GameSetupExpandableListAdapter(Context context, GameSetup gameSetup){
		this.setup = gameSetup;
		this._context = context;
		inflater = LayoutInflater.from(context);
		stringBuilder = new StringBuilder(" ");
		
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
		kingdomCardsStartsWithGroup.setArrayChildren(setup.getKingdomCardSetup());
		
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
			viewHolder.iconPlaceHolder = (RelativeLayout) convertView.findViewById(R.id.set_icon);
			
			convertView.setTag(viewHolder);
		}
		
		AmountOfDominionGameItem AmountOfItem = parentItems.get(groupPosition).getArrayChildren().get(childPosition);
		ViewHolder viewHolder = (ViewHolder) convertView.getTag();
		
		viewHolder.countText.setText(Integer.toString(AmountOfItem.getCount()));
		
		// Set card cost text and CardTypes:
		if(AmountOfItem.getItem() instanceof DominionCard){
			DominionCard card = (DominionCard)AmountOfItem.getItem();
			viewHolder.costText.setText(Integer.toString(card.get_cost()));
			viewHolder.cardTypesText.setText(getCardTypes(card));
		}
		else{
			viewHolder.costText.setText("");
			viewHolder.cardTypesText.setText("");
		}

		
		// Set card name text:
		viewHolder.nameText.setText(ResourcesHelper.GetDominionItemName(_context, AmountOfItem.getItem()));
		
		// Set icon image:
		viewHolder.iconPlaceHolder.setBackgroundDrawable(ResourcesHelper.GetSetIcon(_context, AmountOfItem.getItem().get_dominionSet()));
		
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
		public RelativeLayout iconPlaceHolder;
	}
}
