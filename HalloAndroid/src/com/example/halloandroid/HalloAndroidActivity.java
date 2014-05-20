package com.example.halloandroid;
import com.example.halloandroid.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HalloAndroidActivity extends Activity {

	private TextView txvMessages;
	private EditText etxEntry;
	private Button cmdNextFinish;
	
	private boolean bolFirstClick;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hallo_android);

//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
//        }
        
        txvMessages = (TextView) findViewById(R.id.message);
        etxEntry = (EditText) findViewById(R.id.entry);
        cmdNextFinish = (Button) findViewById(R.id.next_finish);
        
        txvMessages.setText(R.string.welcome);
        cmdNextFinish.setText(R.string.next);
        
        bolFirstClick = true;
        
        cmdNextFinish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (bolFirstClick) {
					txvMessages.setText(getString(R.string.hello, etxEntry.getText()));
					etxEntry.setVisibility(View.INVISIBLE);
					cmdNextFinish.setText(R.string.finish);
					bolFirstClick = false;
				} else {
					finish();
				}
				
			}
		});
    }
}