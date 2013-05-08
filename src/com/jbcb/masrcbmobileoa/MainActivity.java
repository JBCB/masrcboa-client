package com.jbcb.masrcbmobileoa;

import java.util.ArrayList;

import com.jbcb.masrcbmobileoa.widget.BottomBar;
import com.jbcb.masrcbmobileoa.widget.BottomBar.OnItemChangedListener;
import com.jbcb.masrcbmobileoa.widget.FragmentViewPagerAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class MainActivity extends FragmentActivity {
	private ViewPager mViewPager;
    private ArrayList<Fragment> fragmentsList;
    private BottomBar bottomBar;
    private int lastSelected = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initViewPaper();
		
        bottomBar = (BottomBar)findViewById(R.id.main_bottom_bar);
        bottomBar.setOnItemChangedListener(new OnItemChangedListener() 
        {
			
			@Override
			public void onItemChanged(int index) 
			{
				mViewPager.setCurrentItem(index);
			}
		});
        bottomBar.setSelectedState(0);
	}
	
	private void initViewPaper() {
		mViewPager = (ViewPager) findViewById(R.id.fragment_viewPager);
        fragmentsList = new ArrayList<Fragment>();

        FragmentDiary fragmentDiary = new FragmentDiary();
        FragmentAnnounce fragmentAnnounce = new FragmentAnnounce();
        FragmentmMail fragmentMail = new FragmentmMail();

        fragmentsList.add(fragmentDiary);
        fragmentsList.add(fragmentAnnounce);
        fragmentsList.add(fragmentMail);
        
        mViewPager.setAdapter(new FragmentViewPagerAdapter(getSupportFragmentManager(), fragmentsList));
        mViewPager.setCurrentItem(0);
        mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());
    }

    public class MyOnPageChangeListener implements OnPageChangeListener {

        @Override
        public void onPageSelected(int arg0) {
        	bottomBar.setNormalState(lastSelected);
            bottomBar.setSelectedState(arg0);
            lastSelected = arg0;
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }
}
