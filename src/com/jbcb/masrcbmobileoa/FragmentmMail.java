package com.jbcb.masrcbmobileoa;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * 需要使用不带参数的构造器，可以使用getActivity()替换context参数 否则屏幕在旋转的时候会抛出异常： Caused by:
 * java.lang.InstantiationException: can't instantiate class
 * com.michael.fragment.FragmentExecute; no empty constructor
 * 
 * @see http
 *      ://stackoverflow.com/questions/7016632/unable-to-instantiate-fragment
 * */
public class FragmentmMail extends Fragment {
	private Button btn_refresh;
	private ProgressBar progressBar_refresh;
	private LinearLayout ll_send;
	private LinearLayout ll_rev;
	private LinearLayout ll_new;
	private LinearLayout ll_draft;
	private LinearLayout ll_rec;
	private TextView tv_send;
	private TextView tv_rev;
	private TextView tv_new;
	private TextView tv_draft;
	private TextView tv_rec;
	private String str_send;
	private String str_rev;
	private String str_new;
	private String str_draft;
	private String str_rec;
	private int count_send;
	private int count_rev;
	private int count_new;
	private int count_draft;
	private int count_rec;

	public FragmentmMail() {
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
		View layout = myInflater.inflate(R.layout.activity_mail, container,
				false);

		// init the header
		initHeader(layout);

		// init the mail items
		initMailItem(layout);

		return layout;
	}
	
	private void initHeader(View layout) {
		btn_refresh = (Button) layout.findViewById(R.id.frag_mail_btn_refresh);
		progressBar_refresh = (ProgressBar) layout
				.findViewById(R.id.frag_mail_progress_loading);

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
	
	private void initMailItem(View layout) {
		ll_send = (LinearLayout) layout.findViewById(R.id.mailitem_send_title_ll);
		ll_rev = (LinearLayout) layout.findViewById(R.id.mailitem_receive_title_ll);
		ll_new = (LinearLayout) layout.findViewById(R.id.mailitem_new_title_ll);
		ll_draft = (LinearLayout) layout.findViewById(R.id.mailitem_draft_title_ll);
		ll_rec = (LinearLayout) layout.findViewById(R.id.mailitem_recycle_title_ll);

		tv_send = (TextView) layout.findViewById(R.id.mailitem_send_title_tv);
		str_send = getResources().getString(R.string.mail_item_send);
		tv_send.setText(str_send);
		tv_rev = (TextView) layout.findViewById(R.id.mailitem_receive_title_tv);
		str_rev = getResources().getString(R.string.mail_item_reveive);
		tv_rev.setText(str_rev);
		tv_new = (TextView) layout.findViewById(R.id.mailitem_new_title_tv);
		str_new = getResources().getString(R.string.mail_item_new);
		tv_new.setText(str_new);
		tv_draft = (TextView) layout.findViewById(R.id.mailitem_draft_title_tv);
		str_draft = getResources().getString(R.string.mail_item_draft);
		tv_draft.setText(str_draft);
		tv_rec = (TextView) layout.findViewById(R.id.mailitem_recycle_title_tv);
		str_rec = getResources().getString(R.string.mail_item_recycle);
		tv_rec.setText(str_rec);

		count_send = 0;
		count_rev = 0;
		count_new = 0;
		count_draft = 0;
		count_rec = 0;
		
		ll_send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				count_send++;
				tv_send.setText(str_send + " (" + String.valueOf(count_send) + ")");
			}
		});
		
		ll_rev.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				count_rev++;
				tv_rev.setText(str_rev + " (" + String.valueOf(count_rev) + ")");
			}
		});
		
		ll_new.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				count_new++;
				tv_new.setText(str_new + " (" + String.valueOf(count_new) + ")");
			}
		});
		
		ll_draft.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				count_draft++;
				tv_draft.setText(str_draft + " (" + String.valueOf(count_draft) + ")");
			}
		});
		
		ll_rec.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				count_rec++;
				tv_rec.setText(str_rec + " (" + String.valueOf(count_rec) + ")");
			}
		});
	}
}
