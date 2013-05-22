package com.jbcb.masrcbmobileoa;

import java.util.ArrayList;
import java.util.List;

import com.jbcb.masrcbmobileoa.datamodel.AnnounceItem;
import com.jbcb.masrcbmobileoa.widget.FilterImageButton;
import com.jbcb.masrcbmobileoa.widget.FilterPopMenu;
import com.jbcb.masrcbmobileoa.widget.FilterPopMenu.OnItemClickListener;
import com.jbcb.masrcbmobileoa.widget.FilterPopMenu.OnPopMenuDismissListener;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;

/**
 * 需要使用不带参数的构造器，可以使用getActivity()替换context参数 否则屏幕在旋转的时候会抛出异常： Caused by:
 * java.lang.InstantiationException: can't instantiate class
 * com.michael.fragment.FragmentExecute; no empty constructor
 * 
 * @see http
 *      ://stackoverflow.com/questions/7016632/unable-to-instantiate-fragment
 * */
public class FragmentAnnounce extends Fragment {
	private FilterImageButton btn_filter;
	private FilterPopMenu pop_menu;
	private Button btn_refresh;
	private ProgressBar progressBar_refresh;
	private LinearLayout ll_list;

	private String filterItem_All;
	private String filterItem_Today;
	private String filterItem_Week;
	private String filterItem_Month;
	private String filterItem_Quarter;
	private String filterItem_HalfYear;
	private String filterItem_Year;
	
	private ArrayList<AnnounceItem> itemList;

	public FragmentAnnounce() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			// Currently in a layout without a container, so no
			// reason to create our view.
			return null;
		}
		LayoutInflater myInflater = (LayoutInflater) getActivity()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = myInflater.inflate(R.layout.activity_announce, container,
				false);

		// init header
		initHeader(layout);

		// init list
		initList(layout);

		return layout;
	}

	private void initHeader(View layout) {
		filterItem_All = getResources().getString(R.string.filter_item_all);
		filterItem_Today = getResources().getString(R.string.filter_item_today);
		filterItem_Week = getResources().getString(R.string.filter_item_week);
		filterItem_Month = getResources().getString(R.string.filter_item_month);
		filterItem_Quarter = getResources().getString(
				R.string.filter_item_quarter);
		filterItem_HalfYear = getResources().getString(
				R.string.filter_item_halfyear);
		filterItem_Year = getResources().getString(R.string.filter_item_year);

		pop_menu = new FilterPopMenu(this.getActivity());
		pop_menu.addItems(new String[] { filterItem_All, filterItem_Today,
				filterItem_Week, filterItem_Month, filterItem_Quarter,
				filterItem_HalfYear, filterItem_Year });

		btn_filter = (FilterImageButton) layout
				.findViewById(R.id.frag_announce_btn_filter);

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

		btn_refresh = (Button) layout
				.findViewById(R.id.frag_announce_btn_refresh);
		progressBar_refresh = (ProgressBar) layout
				.findViewById(R.id.frag_announce_progress_loading);
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
	}

	private void initList(View layout) {
		ll_list = (LinearLayout) layout
				.findViewById(R.id.frag_announce_ll_list);

		ListView listView = new ListView(getActivity());
		listView.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.activity_announce_listitem, getData()));
		listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		        Intent intent = new Intent();
		        Bundle mBundle = new Bundle();
		        mBundle.putSerializable("AnnounceItem", itemList.get(arg2));
		        intent.putExtras(mBundle);
		        intent.setClass(getActivity(), AnnounceDetailActivity.class);
		        getActivity().startActivity(intent);
			}
		});

		ll_list.addView(listView);
	}
	
	private List<String> getData(){
		AnnounceItem item1 = new AnnounceItem("关于个人账户身份核实过程中。。。", "2013-01-01", "关于个人账户身份核实过程中。。。");
		AnnounceItem item2 = new AnnounceItem("关于演讲比赛的补充通知。。。", "2013-02-01", "关于演讲比赛的补充通知。。。");
		AnnounceItem item3 = new AnnounceItem("关于2013年劳动节放假通知", "2013-03-01", "关于2013年劳动节放假通知");
		AnnounceItem item4 = new AnnounceItem("关于工资发放日期更改。。。", "2013-04-01", "关于工资发放日期更改。。。");
		itemList = new ArrayList<AnnounceItem>();
		
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		itemList.add(item4);
        
        List<String> data = new ArrayList<String>();
        data.add(item1.getTitle());
        data.add(item2.getTitle());
        data.add(item3.getTitle());
        data.add(item4.getTitle());
         
        return data;
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
