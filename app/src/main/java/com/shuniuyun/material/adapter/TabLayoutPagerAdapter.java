package com.shuniuyun.material.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.shuniuyun.material.fragment.TabLayoutFragment;
import com.shuniuyun.material.fragment.TabLayoutFragment2;
import com.shuniuyun.material.fragment.TabLayoutFragment3;

public class TabLayoutPagerAdapter extends FragmentStatePagerAdapter {
	private int tabNum;

	public TabLayoutPagerAdapter(FragmentManager fm, int tabNum) {
		super(fm);
		this.tabNum=tabNum;
	}

	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			return new TabLayoutFragment();
		case 1:
			return new TabLayoutFragment2();
		case 2:
			return new TabLayoutFragment3();
		default:
			return null;
		}
	}

	public int getCount() {
		return tabNum;
	}

}
