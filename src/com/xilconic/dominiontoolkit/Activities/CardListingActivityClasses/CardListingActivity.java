package com.xilconic.dominiontoolkit.Activities.CardListingActivityClasses;

import java.util.ArrayList;
import com.xilconic.dominiontoolkit.R;
import com.xilconic.dominiontoolkit.DominionCards.DominionCard;
import com.xilconic.dominiontoolkit.DominionCards.DominionCardArrayAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class CardListingActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_card_listing);
		
		// Get list of DominionCards from intent:
		Intent i = getIntent();
		ArrayList<DominionCard> cardList = i.getParcelableArrayListExtra("cardList");
		
		ListView listview = (ListView)findViewById(R.id.cardListingListView);
		DominionCardArrayAdapter adapter = new DominionCardArrayAdapter(this, cardList);
		listview.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_card_listing_menu, menu);
		return true;
	}
}
