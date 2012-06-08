package me.mnota.alpha2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class mainmenu extends SherlockActivity {

	private static final int PREFS = 3;
	
    /** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	//using force overflow
    	int theme = R.style.Theme_Sherlock_ForceOverflow;
    	theme = R.style.Theme_Sherlock_Light_DarkActionBar_ForceOverflow;
    	setTheme(theme);
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //start of setOnClickListener subjek button
        findViewById(R.id.btnsubjek).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	Toast.makeText( mainmenu.this, "Button SUBJEK is clicked", Toast.LENGTH_SHORT).show();
            	opensubjek();
            }
        });// end of setOnClickListener subjek button
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

    	menu.add(0, PREFS, 0, "Tetapan")
            .setIcon(R.drawable.ac_setting)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
    	
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {

    	case PREFS:
    		Toast.makeText( mainmenu.this, "Button PREFS is clicked", Toast.LENGTH_SHORT).show();
    		return true;
    	
    	default:
            return super.onOptionsItemSelected(item);
    	}
    }
    
    //start of open setting intent
    public void opensubjek(){
        Intent i = new Intent(mainmenu.this, subjectlist.class);
        startActivity(i);
    }//end of open setting intent
    
}