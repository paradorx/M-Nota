package me.mnota.alpha2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class mainmenu extends SherlockActivity {
	
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
        
        //start of setOnClickListener subjek button
        findViewById(R.id.btnsubjek).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	Toast.makeText( mainmenu.this, "Button SUBJEK is clicked", Toast.LENGTH_SHORT).show();
            	openIntent(SUBJECT);
            }
        });// end of setOnClickListener subjek button

        //start of setOnClickListener note button
        findViewById(R.id.btnnota).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	Toast.makeText( mainmenu.this, "Button NOTA is clicked", Toast.LENGTH_SHORT).show();
            	openIntent(NOTE);
            }
        });// end of setOnClickListener note button
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
    		Toast.makeText( mainmenu.this, "Button PREFS is clicked", Toast.LENGTH_SHORT).show();
    		openIntent(PREFS);
    		return true;
    	
    	default:
            return super.onOptionsItemSelected(item);
    	}
    }
    
    //start of openIntent-----------------------------------------------------------
    public void openIntent(int intentInput){
    	
    	if (intentInput==SUBJECT){
    		i = new Intent(this, subjectlist.class);
            startActivity(i);
    	}
    	else if (intentInput==NOTE){
    		i = new Intent(this, notelist.class);
            startActivity(i);
    	}
    	else if (intentInput==PREFS){
    		i = new Intent(this, tetapan.class);
            startActivity(i);
    	}
    }//end of openIntent------------------------------------------------------------
    
}