package com.xilconic.dominiontoolkit.Activities;

import com.xilconic.dominiontoolkit.R;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.CheckBox;

/**
 * Activity to allow to use to define user preferences such as which card set to use.
 * @author Bas des Bouvrie
 *
 */
public class PreferencesActivity extends Activity {
		private CheckBox useDominionCheckBox;
		private CheckBox useIntrigueCheckBox;
		private CheckBox useSeasideCheckBox;
		private CheckBox useAlchemistsCheckBox;
		private CheckBox useProsperityCheckBox;
		private CheckBox useCornucopiaCheckBox;
		private CheckBox useHinterlandsCheckBox;
		private CheckBox useDarkAgesCheckBox;
		private CheckBox usePromosCheckBox;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preferences);
		
		setViewHandles();
		setSavedPreferences();
	}

	@Override
	protected void onPause(){
		super.onPause();
		
		Log.d("PreferencesActivity", "onPause()...");
		
		// Save preferences state:
		SharedPreferences settings = DominionToolkitPreferences.getPreferences(this);
		SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean(DominionToolkitPreferences.useDominion, useDominionCheckBox.isChecked());
		editor.putBoolean(DominionToolkitPreferences.useIntrigue, useIntrigueCheckBox.isChecked());
		editor.putBoolean(DominionToolkitPreferences.useSeaside, useSeasideCheckBox.isChecked());
		editor.putBoolean(DominionToolkitPreferences.useAlchemy, useAlchemistsCheckBox.isChecked());
		editor.putBoolean(DominionToolkitPreferences.useProsperity, useProsperityCheckBox.isChecked());
		editor.putBoolean(DominionToolkitPreferences.useCornucopia, useCornucopiaCheckBox.isChecked());
		editor.putBoolean(DominionToolkitPreferences.useHinterlands, useHinterlandsCheckBox.isChecked());
		editor.putBoolean(DominionToolkitPreferences.useDarkAges, useDarkAgesCheckBox.isChecked());
		editor.putBoolean(DominionToolkitPreferences.usePromos, usePromosCheckBox.isChecked());
		editor.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_preferences_menu, menu);
		return true;
	}
	
	/**
	 * Retrieves handles to used {@link View} objects.
	 */
	private void setViewHandles() {
		useDominionCheckBox = (CheckBox)findViewById(R.id.preferencesDominionBaseCheckBox);
		useIntrigueCheckBox = (CheckBox)findViewById(R.id.preferencesDominionIntrigueCheckBox);
		useSeasideCheckBox = (CheckBox)findViewById(R.id.preferencesSeasideCheckBox);
		useAlchemistsCheckBox = (CheckBox)findViewById(R.id.preferencesAlchemyCheckBox);
		useProsperityCheckBox = (CheckBox)findViewById(R.id.preferencesProsperityCheckBox);
		useCornucopiaCheckBox = (CheckBox)findViewById(R.id.preferencesCornucopiaCheckBox);
		useHinterlandsCheckBox = (CheckBox)findViewById(R.id.preferencesHinterlandsCheckBox);
		useDarkAgesCheckBox = (CheckBox)findViewById(R.id.preferencesDarkAgesCheckBox);
		usePromosCheckBox = (CheckBox)findViewById(R.id.preferencesPromoCardsCheckBox);
	}
	
	/**
	 * Sets preferences state to views
	 */
	private void setSavedPreferences(){
		SharedPreferences settings = DominionToolkitPreferences.getPreferences(this);

		useDominionCheckBox.setChecked(settings.getBoolean(DominionToolkitPreferences.useDominion, false));
		useIntrigueCheckBox.setChecked(settings.getBoolean(DominionToolkitPreferences.useIntrigue, false));
		useSeasideCheckBox.setChecked(settings.getBoolean(DominionToolkitPreferences.useSeaside, false));
		useAlchemistsCheckBox.setChecked(settings.getBoolean(DominionToolkitPreferences.useAlchemy, false));
		useProsperityCheckBox.setChecked(settings.getBoolean(DominionToolkitPreferences.useProsperity, false));
		useCornucopiaCheckBox.setChecked(settings.getBoolean(DominionToolkitPreferences.useCornucopia, false));
		useHinterlandsCheckBox.setChecked(settings.getBoolean(DominionToolkitPreferences.useHinterlands, false));
		useDarkAgesCheckBox.setChecked(settings.getBoolean(DominionToolkitPreferences.useDarkAges, false));
		usePromosCheckBox.setChecked(settings.getBoolean(DominionToolkitPreferences.usePromos, false));
	}
}
