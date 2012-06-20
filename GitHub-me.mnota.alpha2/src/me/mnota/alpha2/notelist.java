package me.mnota.alpha2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class notelist extends SherlockActivity {
	
	private Intent i;
	
	private static final int REFRESH = 1;
	private static final int SUBJECT = 2;
	private static final int PREFS = 3;
	private static final int HOME = android.R.id.home;
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	    	
	    	//using force overflow
	    	int theme = R.style.Theme_Sherlock_ForceOverflow;
	    	theme = R.style.Theme_Sherlock_Light_DarkActionBar_ForceOverflow;
	    	setTheme(theme);
	    	
	    	//set current xml view
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.notelist);
	        
	        //activate UP navigation button
	        ActionBar actionBar = getSupportActionBar();
	        actionBar.setDisplayHomeAsUpEnabled(true);
	    }
	 
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {

	    	//add Search button with id=SEARCH to action bar
	    	menu.add(0, REFRESH, 0, "Refresh")
	            .setIcon(R.drawable.ac_refresh)
	            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
	        
	    	//add Subjek button with id=SUBJECT to action bar
	    	menu.add(0, SUBJECT, 0, "Pilihan Subjek")
	        	.setShowAsAction(MenuItem.SHOW_AS_ACTION_WITH_TEXT);
	        
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
	    		Toast.makeText( notelist.this, "Button REFRESH is clicked", Toast.LENGTH_SHORT).show();
	    		return true;
	    	
	    	case SUBJECT:
	    		openIntent(SUBJECT);
	    		return true;
	    		
	    	case PREFS:
	    		openIntent(PREFS);
	    		return true;
    		
        	//used for UP navigation button
        	case HOME:
    			openIntent(HOME);
    			return true;

	    	default:
	            return super.onOptionsItemSelected(item);
	    	}
	    }
	    
	    //start of openIntent-----------------------------------------------------------
	    public void openIntent(int intentInput){
	    	
	    	switch (intentInput){
	    	
	    	case SUBJECT:
	    		i = new Intent(this, subjectlist.class);
	            startActivity(i);
	    		break;
	    		
	    	case PREFS:
	    		i = new Intent(this, tetapan.class);
	            startActivity(i);
	    		break;
	    		
	    	case HOME:
	    		i = new Intent(this, mainmenu.class);
	    		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(i);
	            break;
	    		
	    	}

	    }//end of openIntent------------------------------------------------------------
}
