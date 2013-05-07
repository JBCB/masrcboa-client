package com.jbcb.masrcbmobileoa.widget;

import com.jbcb.masrcbmobileoa.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FilterImageButton extends LinearLayout {

	private TextView tv;
	private ImageView iv;
	
	public FilterImageButton(Context context) {
		this(context, null);
	}
	
	public FilterImageButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		LayoutInflater.from(context).inflate(R.layout.filter_imagebutton, this, true);
		tv = (TextView)findViewById(R.id.filter_tv_item);
		iv = (ImageView)findViewById(R.id.filter_iv_item);
	}

	public void setTextView(String filterValue) {
		tv.setText(filterValue);
	}

	public void setImageView(int resId) {
		iv.setImageResource(resId);
	}
}
