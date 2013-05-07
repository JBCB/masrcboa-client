package com.jbcb.masrcbmobileoa;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

/**
 * 需要使用不带参数的构造器，可以使用getActivity()替换context参数
 * 否则屏幕在旋转的时候会抛出异常：
 * Caused by: java.lang.InstantiationException: 
 * can't instantiate class com.michael.fragment.FragmentExecute; no empty constructor
 * 
 * @see http://stackoverflow.com/questions/7016632/unable-to-instantiate-fragment
 * */
public class Fragmentmail extends Fragment
{
	private Button btn_refresh;
	private ProgressBar progressBar_refresh;

	public Fragmentmail()
	{
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{
		if (container == null) 
		{
            // Currently in a layout without a container, so no
            // reason to create our view.
            return null;
        }
		LayoutInflater myInflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	    View layout = myInflater.inflate(R.layout.activity_mail, container, false); 
	    
	    btn_refresh = (Button)layout.findViewById(R.id.frag_mail_btn_refresh);
	    progressBar_refresh = (ProgressBar)layout.findViewById(R.id.frag_mail_progress_loading);
	    btn_refresh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				btn_refresh.setVisibility(Button.INVISIBLE);
				progressBar_refresh.setVisibility(ProgressBar.VISIBLE);
			}
		});
	    
	    progressBar_refresh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				btn_refresh.setVisibility(Button.VISIBLE);
				progressBar_refresh.setVisibility(ProgressBar.INVISIBLE);
			}
		});
		
		return layout;
	}
}
