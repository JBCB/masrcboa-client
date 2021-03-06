package com.jbcb.masrcbmobileoa.widget;

import java.util.ArrayList;
import java.util.List;

import com.jbcb.masrcbmobileoa.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * 将状态条单独封装起来
 * 
 * 这种封装方式和封装类似iPhone的SegmentBar不太一样，不是在代码中生成Button。
 * 这里与布局文件相结合。通过inflater布局文件，来得到每个Item。
 * 
 * @author MichaelYe
 * @since 2012-9-5
 * */
public class BottomBar extends LinearLayout implements OnClickListener
{

	private static final int TAG_0 = 0;
	private static final int TAG_1 = 1;
	private static final int TAG_2 = 2;
	private Context mContext;
	public BottomBar(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
		mContext = context;
		init();
	}

	public BottomBar(Context context) 
	{
		super(context);
		mContext = context;
		init();
	}

	private List<View> itemList;
	/**
	 * get the buttons from layout
	 * 
	 * 得到布局文件中的按钮
	 * 
	 * */
	private void init()
	{
		LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	    View layout = inflater.inflate(R.layout.bottom_bar, null);
	    layout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1.0f));
	    Button btnOne = (Button)layout.findViewById(R.id.btn_item_one);
	    Button btnTwo = (Button)layout.findViewById(R.id.btn_item_two);
	    Button btnThree = (Button)layout.findViewById(R.id.btn_item_three);
	    btnOne.setOnClickListener(this);
	    btnTwo.setOnClickListener(this);
	    btnThree.setOnClickListener(this);
	    btnOne.setTag(TAG_0);
	    btnTwo.setTag(TAG_1);
	    btnThree.setTag(TAG_2);
	    itemList = new ArrayList<View>();
	    itemList.add(btnOne);
	    itemList.add(btnTwo);
	    itemList.add(btnThree);
	    this.addView(layout);
	}
	
	@Override
	public void onClick(View v)
	{
		int tag = (Integer)v.getTag();
		onItemChangedListener.onItemChanged(tag);
	}
	
	/**
	 * set the default bar item of selected
	 * 
	 * 设置默认选中的Item
	 * 
	 * */
	public void setSelectedState(int index)
	{
		if(index != -1 && onItemChangedListener != null)
		{
			if(index > itemList.size())
			{
				throw new RuntimeException("the value of default bar item can not bigger than string array's length");
			}
			itemList.get(index).setSelected(true);
		}
	}
	
	/**
	 * set the normal state of the button by given index
	 * 
	 * 恢复未选中状态
	 * 
	 * */
	public void setNormalState(int index)
	{
		if(index != -1)
		{
			if(index > itemList.size())
			{
				throw new RuntimeException("the value of default bar item can not bigger than string array's length");
			}
			itemList.get(index).setSelected(false);
		}
	}
	
	public interface OnItemChangedListener
	{
		public void onItemChanged(int index);
	}
	
	private OnItemChangedListener onItemChangedListener;
	
	public void setOnItemChangedListener(OnItemChangedListener onItemChangedListener)
	{
	    this.onItemChangedListener = onItemChangedListener;
	}
}
