package me.mnota.alpha2;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Menu_tetapan extends PreferenceActivity {
	
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.tetapan);
	}
	
}
