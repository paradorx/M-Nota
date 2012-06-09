package me.mnota.alpha2;

import com.actionbarsherlock.app.ActionBar;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class tetapan extends PreferenceActivity {
	
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.tetapan);
	}
	
}
