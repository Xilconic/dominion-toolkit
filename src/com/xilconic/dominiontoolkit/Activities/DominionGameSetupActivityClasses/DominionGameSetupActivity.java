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
package com.xilconic.dominiontoolkit.Activities.DominionGameSetupActivityClasses;

import java.util.ArrayList;

import com.xilconic.dominiontoolkit.R;
import com.xilconic.dominiontoolkit.DominionCards.DominionCard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Spinner;

// TODO: Add syncing player selection:
/**
 * This activity visualizes everything required to play a game of Dominion.
 * It features a list of Kingdom cards, setting up information based on a
 * number of players, and will show all additional cards required that are
 * also required to play this particular game.
 * @author Bas des Bouvrie
 *
 */
public class DominionGameSetupActivity extends Activity {
	public static final String ExpectedCardListExtraKey = "cardList";
	private DominionGameSetup gameSetup;
	private ExpandableListView expandableList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dominiongamesetupview);
		
		// Get list of DominionCards from Intent:
		Intent i = getIntent();
		ArrayList<DominionCard> cardList = i.getParcelableArrayListExtra(ExpectedCardListExtraKey);
		
		gameSetup = new DominionGameSetup(cardList);
		gameSetup.SetUp();
		
		// Setup player count selection Spinner:
		Spinner playerSpinner = (Spinner) findViewById(R.id.dominoinGameSetupPlayerSpinner);
		playerSpinner.setSelection(gameSetup.getPlayerCount()-2);
		
		// Setup ExpandableList:
		expandableList = (ExpandableListView)findViewById(R.id.dominionGameSetupExpandableListView);
		DominionGameSetupExpandableListAdapter adapter = new DominionGameSetupExpandableListAdapter(this, gameSetup);
		expandableList.setAdapter(adapter);
		
		// Expand the Kingdom Cards group:
		int kingdomCardsGroupId = adapter.getKingdomCardsGroupId();
		expandableList.expandGroup(kingdomCardsGroupId);
	}
}
