package com.jbcb.masrcbmobileoa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = (Button) findViewById(R.id.login_btn);
        login.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent mainGroupIntent = new Intent();
                mainGroupIntent.setClass(LoginActivity.this, MainActivity.class);
                startActivity(mainGroupIntent);
                LoginActivity.this.finish();
            }
        });
	}

}
