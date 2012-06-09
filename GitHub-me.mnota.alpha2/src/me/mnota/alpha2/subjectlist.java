package me.mnota.alpha2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class subjectlist extends SherlockActivity {
	
	private Intent i;
	
	private static final int REFRESH = 1;
	private static final int PREFS = 3;
	private static final int SEARCH = 5;
	private static final int HOME = android.R.id.home;

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	//using force overflow
    	int theme = R.style.Theme_Sherlock_ForceOverflow;
    	theme = R.style.Theme_Sherlock_Light_DarkActionBar_ForceOverflow;
    	setTheme(theme);
    	
    	//set current xml view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subjectlist);
        
        //activate UP navigation button
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
    	//add Search button with id=SEARCH to action bar
        menu.add(0, SEARCH, 0, "Search")
	        .setIcon(R.drawable.ac_search)
	        .setActionView(R.layout.searchactionbar)
	        .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);

        //add Refresh button with id=REFRESH to action bar
    	menu.add(0, REFRESH, 0, "Refresh")
            .setIcon(R.drawable.ac_refresh)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);

    	//add Tetapan button with id=PREFS to action bar
    	menu.add(0, PREFS, 0, "Tetapan")
    		.setShowAsAction(MenuItem.SHOW_AS_ACTION_WITH_TEXT);

        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	//action if button with available id
    	switch (item.getItemId()) {
    	
    	case REFRESH:
    		Toast.makeText( subjectlist.this, "Button REFRESH is clicked", Toast.LENGTH_SHORT).show();
    		return true;
	
    	case PREFS:
    		Toast.makeText( subjectlist.this, "Button PREFS is clicked", Toast.LENGTH_SHORT).show();
    		openIntent(PREFS);
    		return true;
    		
    	case SEARCH:
    		Toast.makeText( subjectlist.this, "Button SEARCH is clicked", Toast.LENGTH_SHORT).show();
    		return true;
    		
    	//used for UP navigation button
    	case HOME:
			Toast.makeText( subjectlist.this, "Button HOME is clicked", Toast.LENGTH_SHORT).show();
			openIntent(HOME);
			return true;
    	
    	default:
            return super.onOptionsItemSelected(item);
    	}
    }
    
    //start of openIntent-----------------------------------------------------------
    public void openIntent(int intentInput){
    	if (intentInput==PREFS){
    		i = new Intent(this, tetapan.class);
            startActivity(i);
    	}
    	else if (intentInput==HOME){
    		i = new Intent(this, mainmenu.class);
    		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
    	}
    }//end of openIntent------------------------------------------------------------
}