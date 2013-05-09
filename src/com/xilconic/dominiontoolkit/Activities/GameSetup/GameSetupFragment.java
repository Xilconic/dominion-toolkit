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
package com.xilconic.dominiontoolkit.Activities.GameSetup;

import com.xilconic.dominiontoolkit.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ExpandableListView;
import android.widget.Spinner;

/**
 * This activity visualizes everything required to play a game of Dominion.
 * It features a list of Kingdom cards, setting up information based on the
 * number of players (configurable in this fragment) and will show all additional
 * cards or items required to play this particular game. 
 * @author Bas des Bouvrie
 *
 */
public class GameSetupFragment extends Fragment {
	public static final String GameSetupBundleKey = "game_setup";
	private GameSetup gameSetup;
	private ExpandableListView expandableList;
	private GameSetupExpandableListAdapter adapter;
	
	public static GameSetupFragment newInstance(GameSetup gameSetup){
		GameSetupFragment gsFragment = new GameSetupFragment();
		
		// Supply game setup as argument:
		Bundle args = new Bundle();
		args.putParcelable(GameSetupBundleKey, gameSetup);
		gsFragment.setArguments(args);
		
		return gsFragment;
	}
	
	public static GameSetupFragment newInstance(Bundle bundle){
		GameSetup gameSetup = bundle.getParcelable(GameSetupBundleKey);
		if (gameSetup == null) gameSetup = new GameSetup();

		return newInstance(gameSetup);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		if (container == null) return null;
		
		View fragmentView = inflater.inflate(R.layout.fragment_game_setup_view, container, false);
		
		gameSetup = getArguments().getParcelable(GameSetupBundleKey);
		if (!gameSetup.isFullySetup()) gameSetup.SetUp();
		
		setViews(fragmentView);
		
		Spinner playerSpinner = (Spinner) fragmentView.findViewById(R.id.dominoinGameSetupPlayerSpinner);
		playerSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
		    @Override
		    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
		    	if (gameSetup.getPlayerCount() != position+2) 
		    	{
		    	    gameSetup.setPlayerCount(position+2);
		    	    adapter.notifyDataSetChanged();
		    	}
		    }

		    @Override
		    public void onNothingSelected(AdapterView<?> parentView) { /* do nothing */ }
		});
		
		return fragmentView;
	}

	private void setViews(View fragmentView) {
		// Setup player count selection Spinner:
		Spinner playerSpinner = (Spinner) fragmentView.findViewById(R.id.dominoinGameSetupPlayerSpinner);
		playerSpinner.setSelection(gameSetup.getPlayerCount()-2);
		
		// Setup ExpandableList:
		expandableList = (ExpandableListView)fragmentView.findViewById(R.id.dominionGameSetupExpandableListView);
		adapter = new GameSetupExpandableListAdapter(getActivity(), gameSetup);
		expandableList.setAdapter(adapter);
		
		// Expand the Kingdom Cards group:
		int kingdomCardsGroupId = adapter.getKingdomCardsGroupId();
		expandableList.expandGroup(kingdomCardsGroupId);
	}
	
	public void setGameSetup(GameSetup gameSetup){
		this.gameSetup = gameSetup;
		if (!gameSetup.isFullySetup()) gameSetup.SetUp();
		
		setViews(getView());
	}
}
