package me.mnota.alpha2;

import java.util.ArrayList;

import com.actionbarsherlock.app.SherlockListFragment;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;

public class List_note_tFragment extends SherlockListFragment {
	
	private static final String KEY_CONTENT = "tFragment:Content";
	private String mContent = "???";
	
	Context ctx;
	Resources res;
	
	String[] options;
	TypedArray icons;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
            mContent = savedInstanceState.getString(KEY_CONTENT);
        }
    }
	
	/**
	 * this will create the data inside the pager
	 * */
	
	String[] values = new String[] { "1", "2", "3", "4" };
	ArrayList<String> appvalues = new ArrayList<String>();
	List_note_ImageAndTextAdapter adapter;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		
		super.onActivityCreated(savedInstanceState);
		
		ctx = getActivity().getApplicationContext();
        res = ctx.getResources();
		
        options = res.getStringArray(R.array.country_names);
        icons = res.obtainTypedArray(R.array.country_icons);
		
		adapter = new List_note_ImageAndTextAdapter(ctx, R.layout.list_nota_item,options, icons);
		setListAdapter(adapter);
		
	}
	
	/**
	 * this is to save the state to prevent memory loss after being killed
	 * the data will be recalled in onCreate if its ben recreated
	 * */
	@Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CONTENT, mContent);
    }

	public static List_note_tFragment newInstance(String content) {
        List_note_tFragment fragment = new List_note_tFragment();

        for (int i = 0; i < fragment.values.length; i++) {
        	
        	fragment.appvalues.add(content+" "+i);
        	
        }

        return fragment;
    }

}
