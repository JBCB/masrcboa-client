package com.jbcb.masrcbmobileoa;

import com.jbcb.masrcbmobileoa.widget.FilterImageButton;
import com.jbcb.masrcbmobileoa.widget.FilterPopMenu;
import com.jbcb.masrcbmobileoa.widget.FilterPopMenu.OnItemClickListener;
import com.jbcb.masrcbmobileoa.widget.FilterPopMenu.OnPopMenuDismissListener;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * 需要使用不带参数的构造器，可以使用getActivity()替换context参数
 * 否则屏幕在旋转的时候会抛出异常：
 * Caused by: java.lang.InstantiationException: 
 * can't instantiate class com.michael.fragment.FragmentExecute; no empty constructor
 * 
 * @see http://stackoverflow.com/questions/7016632/unable-to-instantiate-fragment
 * */
public class FragmentDiary extends Fragment
{
	private FilterImageButton btn_filter;
	private FilterPopMenu pop_menu;
	
	private String filterItem_All;
	private String filterItem_Today;
	private String filterItem_Week;
	private String filterItem_Month;
	private String filterItem_Quarter;
	private String filterItem_HalfYear;
	private String filterItem_Year;
	
	public FragmentDiary()
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
	    View layout = myInflater.inflate(R.layout.activity_diary, container, false);
	    
	    Button btn_new = (Button)layout.findViewById(R.id.frag_diary_btn_new);
	    btn_new.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			}
		});
	    
		filterItem_All = getResources().getString(R.string.filter_item_all);
		filterItem_Today = getResources().getString(R.string.filter_item_today);
		filterItem_Week = getResources().getString(R.string.filter_item_week);
		filterItem_Month = getResources().getString(R.string.filter_item_month);
		filterItem_Quarter = getResources().getString(R.string.filter_item_quarter);
		filterItem_HalfYear = getResources().getString(R.string.filter_item_halfyear);
		filterItem_Year = getResources().getString(R.string.filter_item_year);
	    
	    pop_menu = new FilterPopMenu(this.getActivity());
	    pop_menu.addItems(new String[]{filterItem_All, filterItem_Today, filterItem_Week, filterItem_Month, filterItem_Quarter, filterItem_HalfYear, filterItem_Year});

	    btn_filter = (FilterImageButton)layout.findViewById(R.id.frag_diary_btn_filter);
	    
	    pop_menu.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(int index) {
				// TODO Auto-generated method stub
				btn_filter.setTextView(getFilterValue(index));
			}
		});
	    
	    pop_menu.setOnDismissListener(new OnPopMenuDismissListener() {
			@Override
			public void onDismiss() {
				// TODO Auto-generated method stub
				btn_filter.setImageView(R.drawable.header_filter_down);
			}
		});
	    
	    btn_filter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				btn_filter.setImageView(R.drawable.header_filter_up);
				pop_menu.showAsDropDown(v);
			}
		});
		
		return layout;
	}
	
	private String getFilterValue(int index) {
		String filterValue = "";
		
		switch (index) {
		case 0:
			filterValue = filterItem_All;
			break;
		case 1:
			filterValue = filterItem_Today;
			break;
		case 2:
			filterValue = filterItem_Week;
			break;
		case 3:
			filterValue = filterItem_Month;
			break;
		case 4:
			filterValue = filterItem_Quarter;
			break;
		case 5:
			filterValue = filterItem_HalfYear;
			break;
		case 6:
			filterValue = filterItem_Year;
			break;
		default:
			filterValue = filterItem_All;
			break;
		}
		
		return filterValue;
	}
}
