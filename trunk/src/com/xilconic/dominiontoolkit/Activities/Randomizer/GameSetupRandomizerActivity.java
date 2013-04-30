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
import com.xilconic.dominiontoolkit.Activities.GameSetup.GameSetup;
import com.xilconic.dominiontoolkit.Activities.GameSetup.GameSetupFragment;
import com.xilconic.dominiontoolkit.DominionCards.DominionCard;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

public class GameSetupRandomizerActivity extends FragmentActivity {
	private static final String STATE_CURRENT_CARD_LIST = "currentCardList";
	public static final String EXTRA_CARD_LIST_KEY = "cardList";
	
	private Randomizer randomizer;
	private ArrayList<DominionCard> currentCardList;
	private GameSetup gameSetup;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_setup_randomizer);
		
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
		gameSetup = new GameSetup(currentCardList);
		gameSetup.SetUp();
		
		// Set GameSetupFragment:
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		GameSetupFragment fragment = GameSetupFragment.newInstance(gameSetup);
		fragmentTransaction.add(R.id.gameSetupFragmentPlaceholder, fragment);
		fragmentTransaction.commit();
	}
	
	public void shuffleKingdomDeck(View v){		
		gameSetup.setKingdomCardSet(randomizer.GetRandomKingdomDeck());
		gameSetup.SetUp();
		
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		GameSetupFragment fragment = GameSetupFragment.newInstance(gameSetup);
		fragmentTransaction.replace(R.id.gameSetupFragmentPlaceholder, fragment);
		fragmentTransaction.commit();
	}
}
