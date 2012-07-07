package me.mnota.alpha2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class List_note_FragmentAdapter extends FragmentPagerAdapter{
	
	protected static final String[] CONTENT = new String[] { "Fakulti", "Program", "Subjek", "Set", };
    private int mCount = CONTENT.length;

	public List_note_FragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		//position % CONTENT.length eg: position=4, content length=4; then 4%4=0; content will be at instance 0
		return List_note_tFragment.newInstance(CONTENT[position % CONTENT.length]);
	}

	@Override
	public int getCount() {
		return mCount;
	}
	
	public void setCount(int count) {
        if (count > 0 && count <= 10) {
            mCount = count;
            notifyDataSetChanged();
        }
    }

}
