package com.shuniuyun.material.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.shuniuyun.material.fragment.AppBarLayoutFragment;
import com.shuniuyun.material.fragment.AppBarLayoutFragment2;

public class AppBarLayoutPagerAdapter extends FragmentStatePagerAdapter {
	private int tabNum;
	public AppBarLayoutPagerAdapter(FragmentManager fm, int tabNum) {
		super(fm);
		this.tabNum=tabNum;
	}

	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			return new AppBarLayoutFragment();
		case 1:
			return new AppBarLayoutFragment2();
		default:
			return null;
		}
	}

	public int getCount() {
		return tabNum;
	}

}
