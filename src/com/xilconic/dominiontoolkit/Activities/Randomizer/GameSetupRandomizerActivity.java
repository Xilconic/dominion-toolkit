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
import android.widget.Toast;

/**
 * This activity allows the user to randomly generate a game of dominion
 * to be played.
 * @author Bas des Bouvrie
 *
 */
public class GameSetupRandomizerActivity extends FragmentActivity {
	public static final String EXTRA_CARD_LIST_KEY = "cardList";
	private static final String GAME_SETUP_FRAGMENT_TAG = "gameSetupFragment";
	private static final String STATE_CURRENT_GAME_SETUP = "currentGameSetup";
	
	private GameSetup gameSetup;
	private GameSetupRandomizer randomizer;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_setup_randomizer);
		
		// Get list of DominionCards from intent:
		Intent i = getIntent();
		ArrayList<DominionCard> cardList = i.getParcelableArrayListExtra(EXTRA_CARD_LIST_KEY);
		
		// Create randomizer and...
		randomizer = new GameSetupRandomizer(cardList);
		// ... generate a random kingdom deck:
		if (savedInstanceState != null) {
			gameSetup = savedInstanceState.getParcelable(STATE_CURRENT_GAME_SETUP);
		} else {
		    generateGameSetup();
		}
		gameSetup.SetUp();
		
		// Set GameSetupFragment:
		FragmentManager fragmentManager = getSupportFragmentManager();
		GameSetupFragment fragment = (GameSetupFragment)fragmentManager.findFragmentByTag(GAME_SETUP_FRAGMENT_TAG);
		if (fragment == null){
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
			fragment = GameSetupFragment.newInstance(gameSetup);
			fragmentTransaction.add(R.id.gameSetupFragmentPlaceholder, fragment, GAME_SETUP_FRAGMENT_TAG);
			fragmentTransaction.commit();
		}
	}
	
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState){
		savedInstanceState.putParcelable(STATE_CURRENT_GAME_SETUP, gameSetup);
		super.onSaveInstanceState(savedInstanceState);
	}
	
	public void shuffleKingdomDeck(View v){
	    generateGameSetup();
		gameSetup.SetUp();
		
		FragmentManager fragmentManager = getSupportFragmentManager();
		GameSetupFragment fragment = (GameSetupFragment)fragmentManager.findFragmentByTag(GAME_SETUP_FRAGMENT_TAG);
		fragment.setGameSetup(gameSetup);
	}
	
	private void generateGameSetup(){
	    gameSetup = null;
	    int tryCount = 0;
        while(tryCount < 5){
            try {
                gameSetup = randomizer.GetRandomGameSetup();
            } catch (RandomizationFailedException e) {
                tryCount++;
            }
            
            // No Exceptions thrown, continue:
            break;
        }
        
        if (gameSetup == null){
            Toast.makeText(this, R.string.Randomizer_UnableToCreateRandomizedSetup, Toast.LENGTH_SHORT).show();
            gameSetup = new GameSetup();
        }
	}
}
