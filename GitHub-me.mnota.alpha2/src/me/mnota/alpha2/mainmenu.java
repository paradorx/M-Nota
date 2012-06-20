package me.mnota.alpha2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class mainmenu extends SherlockActivity implements OnClickListener {
	
	private Intent i;

	private static final int SUBJECT = 2;
	private static final int PREFS = 3;
	private static final int NOTE = 4;
	
    /** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	//using force overflow
    	int theme = R.style.Theme_Sherlock_ForceOverflow;
    	theme = R.style.Theme_Sherlock_Light_DarkActionBar_ForceOverflow;
    	setTheme(theme);
    	
    	//set current xml view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //set setOnClickListener subjek button
        findViewById(R.id.btnsubjek).setOnClickListener(this);

        //start of setOnClickListener note button
        findViewById(R.id.btnnota).setOnClickListener(this);
    }
    
	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		
		case R.id.btnsubjek:
			openIntent(SUBJECT);
			break;
			
		case R.id.btnnota:
			openIntent(NOTE);
			break;
		}
	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
    	//add Tetapan button with id=PREFS to action bar
    	menu.add(0, PREFS, 0, "Tetapan")
            .setIcon(R.drawable.ac_setting)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
    	
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	//action if button with available id
    	switch (item.getItemId()) {

    	case PREFS:
    		openIntent(PREFS);
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
    		
    	case NOTE:
    		i = new Intent(this, notelist.class);
            startActivity(i);
    		break;
    		
    	case PREFS:
    		i = new Intent(this, tetapan.class);
            startActivity(i);
    		break;
    	}

    }//end of openIntent------------------------------------------------------------
    
}