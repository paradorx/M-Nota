package me.mnota.alpha2;

import android.os.Bundle;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class subjectlist extends SherlockActivity {
	
	private static final int REFRESH = 1;
	private static final int SUBJECT = 2;
	private static final int PREFS = 3;
	
    /** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	//using force overflow
    	int theme = R.style.Theme_Sherlock_ForceOverflow;
    	theme = R.style.Theme_Sherlock_Light_DarkActionBar_ForceOverflow;
    	setTheme(theme);
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subjectlist);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

    	menu.add(0, REFRESH, 0, "Refresh")
            .setIcon(R.drawable.ac_refresh)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        
    	menu.add(0, SUBJECT, 0, "Pilihan Subjek")
        	.setShowAsAction(MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        
    	menu.add(0, PREFS, 0, "Tetapan")
    		.setShowAsAction(MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        

        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    	
    	case REFRESH:
    		Toast.makeText( subjectlist.this, "Button REFRESH is clicked", Toast.LENGTH_SHORT).show();
    		return true;
    	
    	case SUBJECT:
    		Toast.makeText( subjectlist.this, "Button SUBJECT is clicked", Toast.LENGTH_SHORT).show();
    		return true;
    		
    	case PREFS:
    		Toast.makeText( subjectlist.this, "Button PREFS is clicked", Toast.LENGTH_SHORT).show();
    		return true;
    	
    	default:
            return super.onOptionsItemSelected(item);
    	}
    }
}