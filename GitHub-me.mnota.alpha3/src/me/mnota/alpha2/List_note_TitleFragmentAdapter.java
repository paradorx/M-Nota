package me.mnota.alpha2;

import android.support.v4.app.FragmentManager;

public class List_note_TitleFragmentAdapter extends List_note_FragmentAdapter {
	
	public List_note_TitleFragmentAdapter(FragmentManager fm) {
		super(fm);
	}
	
	@Override
    public CharSequence getPageTitle(int position) {
        return List_note_FragmentAdapter.CONTENT[position % CONTENT.length];
    }

}
