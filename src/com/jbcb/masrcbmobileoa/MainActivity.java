package com.jbcb.masrcbmobileoa;

import com.jbcb.masrcbmobileoa.widget.BottomBar;
import com.jbcb.masrcbmobileoa.widget.BottomBar.OnItemChangedListener;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        final BottomBar bottomBar = (BottomBar)findViewById(R.id.main_bottom_bar);
        bottomBar.setOnItemChangedListener(new OnItemChangedListener() 
        {
			
			@Override
			public void onItemChanged(int index) 
			{

				showDetails(index);
			}
		});
        bottomBar.setSelectedState(0);
	}
	
	private void showDetails(int index)
	{
		Fragment details = (Fragment)
				getSupportFragmentManager().findFragmentById(R.id.main_details);
		switch(index)
		{
		case 0:
			details = new FragmentDiary();
			break;
		case 1:
			details = new FragmentAnnounce();
			break;
		case 2:
			details = new Fragmentmail();
			break;
		}
		// Execute a transaction, replacing any existing
        // fragment with this one inside the frame.
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_details, details);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//        ft.addToBackStack(null);//这行代码可以返回之前的操作（横屏的情况下，即两边都显示的情况下）
        ft.commit();
		
	}
}
