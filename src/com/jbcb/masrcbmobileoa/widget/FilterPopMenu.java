package com.jbcb.masrcbmobileoa.widget;

import java.util.ArrayList;

import com.jbcb.masrcbmobileoa.R;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

/**
 * �޸��ڣ�2013-2-28 17:03:35
 * 	���� ListView item �����Ӧʧ�ܣ�
 * 
 * @author Yichou
 *
 */
public class FilterPopMenu implements OnItemClickListener {
	public interface OnItemClickListener {
		public void onItemClick(int index);
	}
	public interface OnPopMenuDismissListener {
		public void onDismiss();
	}
	
	private ArrayList<String> itemList;
	private PopupWindow popupWindow;
	private ListView listView;
	private OnItemClickListener clickListener;
	private OnPopMenuDismissListener dismissListener;
	private LayoutInflater inflater;

	
	public FilterPopMenu(Context context) {

		itemList = new ArrayList<String>(5);

		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.filter_popmenu, null);

		listView = (ListView) view.findViewById(R.id.header_filter_listView);
		listView.setAdapter(new PopAdapter());
		listView.setOnItemClickListener(this);

		popupWindow = new PopupWindow(view, 230,  //��������Ҫ�Լ�ָ����ʹ�� WRAP_CONTENT ��ܴ�
				LayoutParams.WRAP_CONTENT);
		// �����Ϊ�˵��������Back��Ҳ��ʹ����ʧ�����Ҳ�����Ӱ����ı�����������ģ�
		popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		
		popupWindow.setOnDismissListener(new OnDismissListener() {
			
			@Override
			public void onDismiss() {
				if (dismissListener != null) {
					dismissListener.onDismiss();
				}
			}
		});
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		if (clickListener != null) {
			clickListener.onItemClick(position);
		}
		dismiss();
	}

	// ���ò˵�����������
	public void setOnItemClickListener(OnItemClickListener clickListener) {
		 this.clickListener = clickListener;
	}

	// ���ò˵����ؼ�����
	public void setOnDismissListener(OnPopMenuDismissListener dismissListener) {
		 this.dismissListener = dismissListener;
	}

	// ������Ӳ˵���
	public void addItems(String[] items) {
		for (String s : items)
			itemList.add(s);
	}

	// ������Ӳ˵���
	public void addItem(String item) {
		itemList.add(item);
	}

	// ����ʽ ���� pop�˵� parent ���½�
	public void showAsDropDown(View parent) {
		popupWindow.showAsDropDown(parent, 10, 5);

		// ʹ��ۼ�
		popupWindow.setFocusable(true);
		// ����������������ʧ
		popupWindow.setOutsideTouchable(true);
		// ˢ��״̬
		popupWindow.update();
	}

	// ���ز˵�
	public void dismiss() {
		popupWindow.dismiss();
	}

	// ������
	private final class PopAdapter extends BaseAdapter {
		@Override
		public int getCount() {
			return itemList.size();
		}

		@Override
		public Object getItem(int position) {
			return itemList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.filter_popmenu_item, null);
				holder = new ViewHolder();
				convertView.setTag(holder);
				holder.groupItem = (TextView) convertView.findViewById(R.id.filter_popmenu_item_tv);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.groupItem.setText(itemList.get(position));

			return convertView;
		}

		private final class ViewHolder {
			TextView groupItem;
		}
	}
}
