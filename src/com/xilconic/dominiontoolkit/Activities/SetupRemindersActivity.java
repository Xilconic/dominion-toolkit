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

import com.xilconic.dominiontoolkit.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

/**
 * Class for visualization of game setup and gameplay reminders
 * @author Bas des Bouvrie
 *
 */
public class SetupRemindersActivity extends Activity {
	private static final String STATE_NUMBER_OF_PLAYERS = "numberOfPlayers";
	
	private int numberOfPlayers;
	private TextView playerCountTextView, curseCountTextView, victoryCountTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setup_reminders);
		
		if (savedInstanceState != null){
			numberOfPlayers = savedInstanceState.getInt(STATE_NUMBER_OF_PLAYERS);
		}
		else{
			numberOfPlayers = 2;
		}
		
		playerCountTextView = (TextView)findViewById(R.id.playerCountTextView);
		curseCountTextView = (TextView)findViewById(R.id.curseCountTextView);
		victoryCountTextView = (TextView)findViewById(R.id.victoryCountTextView);
		
		SetTextToTextViews();
	}

	private void SetTextToTextViews() {
		playerCountTextView.setText(String.valueOf(numberOfPlayers));
		curseCountTextView.setText(String.valueOf(10 * (numberOfPlayers - 1)));
		victoryCountTextView.setText(String.valueOf(8 + (numberOfPlayers -2) * 2));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_setup_reminders_menu, menu);
		return true;
	}
	
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState){
		savedInstanceState.putInt(STATE_NUMBER_OF_PLAYERS, numberOfPlayers);
		super.onSaveInstanceState(savedInstanceState); // Always call this for hierarchy
	}
	
	public void add_player(View v){
		if (numberOfPlayers < 4){
			numberOfPlayers++;
			SetTextToTextViews();
		}
	}
	
	public void remove_player(View v){
		if (numberOfPlayers > 2){
			numberOfPlayers--;
			SetTextToTextViews();
		}
	}
}
