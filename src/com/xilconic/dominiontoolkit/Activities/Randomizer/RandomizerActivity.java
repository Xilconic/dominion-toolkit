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
package com.xilconic.dominiontoolkit.Activities.Randomizer;

import java.util.ArrayList;

import com.xilconic.dominiontoolkit.R;
import com.xilconic.dominiontoolkit.DominionCards.DominionCard;
import com.xilconic.dominiontoolkit.DominionCards.DominionCardArrayAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class RandomizerActivity extends Activity {
	private static final String STATE_CURRENT_CARD_LIST = "currentCardList";
	public static final String EXTRA_CARD_LIST_KEY = "cardList";
	
	private Randomizer randomizer;
	private ListView listview;
	private DominionCardArrayAdapter adapter;
	private ArrayList<DominionCard> currentCardList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_randomizer);
		
		// Get list of DominionCards from intent:
		Intent i = getIntent();
		ArrayList<DominionCard> cardList = i.getParcelableArrayListExtra(EXTRA_CARD_LIST_KEY);
		
		// Create randomizer and...
		randomizer = new Randomizer(cardList);
		// ... generate a random kingdom deck:
		if (savedInstanceState != null) {
			currentCardList = savedInstanceState.getParcelableArrayList(STATE_CURRENT_CARD_LIST);
		} else {
			currentCardList = randomizer.GetRandomKingdomDeck();
		}
		
		// Set ListView:
		listview = (ListView)findViewById(R.id.randomizerKingdomCardsListView);
		adapter = new DominionCardArrayAdapter(this, currentCardList);
		listview.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_randomizer_menu, menu);
		return true;
	}
	
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		savedInstanceState.putParcelableArrayList(STATE_CURRENT_CARD_LIST, currentCardList);
		super.onSaveInstanceState(savedInstanceState); // Always call this for hierarchy
	}
	
	public void shuffleKingdomDeck(View v) {
		currentCardList = randomizer.GetRandomKingdomDeck();
		adapter = new DominionCardArrayAdapter(this, currentCardList);
		listview.setAdapter(adapter);
	}
}
