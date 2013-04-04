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
package com.xilconic.dominiontoolkit.Activities;

import java.util.ArrayList;
import java.util.List;

import com.xilconic.dominiontoolkit.R;
import com.xilconic.dominiontoolkit.Activities.CardListing.CardListingActivity;
import com.xilconic.dominiontoolkit.Activities.GameSetup.GameSetup;
import com.xilconic.dominiontoolkit.Activities.GameSetup.GameSetupActivity;
import com.xilconic.dominiontoolkit.Activities.Randomizer.RandomizerActivity;
import com.xilconic.dominiontoolkit.DominionCards.CardsDB;
import com.xilconic.dominiontoolkit.DominionCards.DominionCard;
import com.xilconic.dominiontoolkit.DominionCards.DominionSet;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class DominionToolkitMenuActivity extends Activity {
	
	//private DominionToolkitDatabaseHandler database;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dominion_toolkit_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_dominion_toolkit_menu, menu);
		return true;
	}
	
	public void startRandomizerActivity(View v){
		Intent intent = new Intent(DominionToolkitMenuActivity.this, RandomizerActivity.class);
		
		//if (database == null) {
		//	database = new DominionToolkitDatabaseHandler(DominionToolkitMenuActivity.this);
		//}
		List<DominionSet> cardSets = DominionToolkitPreferences.getActiveDominionSets(this);
		//intent.putParcelableArrayListExtra("cardList", database.getDominionCardsByCardset(cardSets));
		intent.putParcelableArrayListExtra(RandomizerActivity.EXTRA_CARD_LIST_KEY, CardsDB.getAllCardsFromSets(cardSets));
		
		startActivity(intent);
	}
	
	public void startSetupRemindersActivity(View v){
		Intent intent = new Intent(DominionToolkitMenuActivity.this, SetupRemindersActivity.class);
		startActivity(intent);
	}
	
	public void startCardListingActivity(View v){
		Intent intent = new Intent(DominionToolkitMenuActivity.this, CardListingActivity.class);
		
		//if (database == null) {
		//	database = new DominionToolkitDatabaseHandler(DominionToolkitMenuActivity.this);
		//}
		List<DominionSet> cardSets = DominionToolkitPreferences.getActiveDominionSets(this);
		//intent.putParcelableArrayListExtra("cardList", database.getDominionCardsByCardset(cardSets));
		intent.putParcelableArrayListExtra(CardListingActivity.EXTRA_CARD_LIST_KEY, CardsDB.getAllCardsFromSets(cardSets));
		
		startActivity(intent);
	}
	
	public void startPreferencesActivity(View v){
		Intent intent = new Intent(DominionToolkitMenuActivity.this, PreferencesActivity.class);
		startActivity(intent);
	}
	
	public void startGameSetupActivity(View v){
		Intent intent = new Intent(DominionToolkitMenuActivity.this, GameSetupActivity.class);
		List<DominionSet> cardSets = DominionToolkitPreferences.getActiveDominionSets(this);
		ArrayList<DominionCard> allCards = CardsDB.getAllCardsFromSets(cardSets);
		ArrayList<DominionCard> intentExtras = new ArrayList<DominionCard>(10);
		for (int i = 0; i < 10; i++) {
			intentExtras.add(allCards.get(i));
		}
		
		intent.putParcelableArrayListExtra(GameSetupActivity.ExpectedCardListExtraKey, intentExtras);
		
		startActivity(intent);
	}

}
