package org.jLeta.myfirstandroidapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity {

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.text);

		Button checkCmd = (Button) findViewById(R.id.bResult);
		final ToggleButton passTog = (ToggleButton) findViewById(R.id.tbPassword);
		EditText input = (EditText) findViewById(R.id.etCommands);
		TextView display = (TextView) findViewById(R.id.tvispaly);

		passTog.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// passTog.setActivated(false);
				if (passTog.isChecked()) {

				} else {

				}
			}
		});
	}
}
