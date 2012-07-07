package me.mnota.alpha2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;

public class viewfakulti extends List_subject  {
	
	/**
     * Declaration *
     ** * * * * * **/
	
	private static final String TABLE_NAME="fakulti";
	private ArrayList<String> TABLE_LIST = new ArrayList<String>();
	private static ArrayAdapter<String> aAdapter;
	
	// url to make request
	private static String[] urlLIST = {"http://mnota.comuv.com/JSONtest.php"};
	
	/**
     * Extended Main Activity *
     ** * * * * * * * * * * * */
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		getTable();
		
		ListView list = getListView();
		list.setTextFilterEnabled(true);
		
		list.setOnItemClickListener(new OnItemClickListener(){
			
			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int listviewposition, long listviewid) {
				
				String viewgettext = (String) ((TextView) view).getText();
				openChild(viewgettext);
				
			}
			
		});
		
	}
	
	public void getTable(){
		
		//try to make a SQLite commands to get all the list
		try{
			
			sqlhelper info = new sqlhelper(this);
	        info.open();
	        setTABLE_LIST(info.getListName(TABLE_NAME));
	        info.close();
			
		}catch (Exception e){
			
			e.printStackTrace();
			Log.e("SQLException Error", "SQLException Error: " + e.toString());
			Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
			
		}
		
		aAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getTABLE_LIST());
		aAdapter.setNotifyOnChange(true);
		setListAdapter(aAdapter);
		
	}
	
	public ArrayList<String> getTABLE_LIST() {
		return TABLE_LIST;
	}

	public void setTABLE_LIST(ArrayList<String> tABLE_LIST) {
		TABLE_LIST = tABLE_LIST;
	}
	
	//opening child activity while passing the id of selected item from OnItemClickListener
	protected void openChild(String viewgettext) {
		try{
			
			sqlhelper info = new sqlhelper(this);
			info.open();
			String thisId = info.getSelectedId(TABLE_NAME, viewgettext);
			info.close();
			Toast.makeText(getApplicationContext(), thisId, Toast.LENGTH_SHORT).show();
			
			viewprogram.setFakultiId(thisId);
			
			Intent i = new Intent(this, viewprogram.class);
            startActivity(i);
			
		}catch (Exception e){
			
			String error = e.toString();
			Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
			
		}
	}

}