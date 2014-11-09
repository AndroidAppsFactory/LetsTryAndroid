package org.jLeta.myfirstandroidapp;

import static org.jLeta.myfirstandroidapp.Constants.BREAD;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends Activity implements OnClickListener {

	TextView tvGot;
	Button bSA, bSAFR;
	EditText etSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get);
		initializeComponents();
	}

	private void initializeComponents() {
		tvGot = (TextView) findViewById(R.id.tvGot);
		bSA = (Button) findViewById(R.id.bSA);
		bSAFR = (Button) findViewById(R.id.bSAFR);
		etSend = (EditText) findViewById(R.id.etSend);
		bSAFR.setOnClickListener(this);
		bSA.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bSA:
			String bread = etSend.getText().toString();
			// use budle to send data.
			Bundle bundle = new Bundle();
			bundle.putString(BREAD, bread);
			// way to pass data to openedClass
			Intent intent = new Intent(Data.this, OpenedClass.class);
			// fill the data.
			intent.putExtras(bundle);
			startActivity(intent);
			break;

		// this is how you can start another activity
		// and expect result from it.
		case R.id.bSAFR:
			Intent intent2 = new Intent(Data.this, OpenedClass.class);
			// collect you result here, look at 'onActivityResult' to understand
			// what to expect.
			startActivityForResult(intent2, 0);
			break;
		}
	}

	/**
	 * resultCode = indicates if the operation was successful.
	 * 
	 * data = is the intent data that is sent back.
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle resultBundle = data.getExtras();
			String s = resultBundle.getString(Constants.ANSWER);
			tvGot.setText(s);
		}
	}
}
