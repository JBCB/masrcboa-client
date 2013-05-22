package com.jbcb.masrcbmobileoa;

import com.jbcb.masrcbmobileoa.datamodel.AnnounceItem;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AnnounceDetailActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announce_detail);
        
        AnnounceItem announce = (AnnounceItem)getIntent().getSerializableExtra("AnnounceItem");
        
        TextView title = (TextView)findViewById(R.id.activity_announcedetail_tv_detail);
        title.setText(announce.getContent());

        Button back = (Button) findViewById(R.id.activity_announcedetail_btn_back);
        back.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                AnnounceDetailActivity.this.finish();
            }
        });
	}

}
