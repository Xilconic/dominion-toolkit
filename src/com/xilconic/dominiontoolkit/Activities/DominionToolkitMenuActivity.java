package com.xilconic.dominiontoolkit.Activities;

import java.util.List;

import com.xilconic.dominiontoolkit.R;
import com.xilconic.dominiontoolkit.Activities.CardListingActivityClasses.CardListingActivity;
import com.xilconic.dominiontoolkit.Activities.RandomizerActivityClasses.RandomizerActivity;
import com.xilconic.dominiontoolkit.DominionCards.DominionSet;
import com.xilconic.dominiontoolkit.DominionCards.DominionToolkitDatabaseHandler;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class DominionToolkitMenuActivity extends Activity {
	
	private DominionToolkitDatabaseHandler database;

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
		
		if (database == null) {
			database = new DominionToolkitDatabaseHandler(DominionToolkitMenuActivity.this);
		}
		List<DominionSet> cardSets = DominionToolkitPreferences.getActiveDominionSets(this);
		intent.putParcelableArrayListExtra("cardList", database.getDominionCardsByCardset(cardSets));
		
		startActivity(intent);
	}
	
	public void startSetupRemindersActivity(View v){
		Intent intent = new Intent(DominionToolkitMenuActivity.this, SetupRemindersActivity.class);
		startActivity(intent);
	}
	
	public void startCardListingActivity(View v){
		Intent intent = new Intent(DominionToolkitMenuActivity.this, CardListingActivity.class);
		
		if (database == null) {
			database = new DominionToolkitDatabaseHandler(DominionToolkitMenuActivity.this);
		}
		List<DominionSet> cardSets = DominionToolkitPreferences.getActiveDominionSets(this);
		intent.putParcelableArrayListExtra("cardList", database.getDominionCardsByCardset(cardSets));
		
		startActivity(intent);
	}
	
	public void startPreferencesActivity(View v){
		Intent intent = new Intent(DominionToolkitMenuActivity.this, PreferencesActivity.class);
		startActivity(intent);
	}

}
