package com.jbcb.masrcbmobileoa;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DiaryNewActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_new);
        
        final EditText title = (EditText)findViewById(R.id.activity_diarynew_et_content);

        Button back = (Button) findViewById(R.id.activity_diarynew_btn_back);
        back.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
            	DiaryNewActivity.this.finish();
            }
        });

        Button save = (Button) findViewById(R.id.activity_diarynew_btn_save);
        save.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
            	title.setFocusable(false);
            	DiaryNewActivity.this.finish();
            }
        });
	}

}
