package org.jLeta.myfirstandroidapp;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity implements View.OnClickListener {

	Button checkCmd;
	ToggleButton passTog;
	EditText input;
	TextView display;

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.text);

		// init components from xml file.
		initComponents();

		// onClick method of interface View.OnClickListener is implemented in
		// this class
		// and setOnClickListener() is accepting that implementation as param
		passTog.setOnClickListener(this);
		checkCmd.setOnClickListener(this);
	}

	/**
	 * Initialise components
	 */
	private void initComponents() {
		checkCmd = (Button) findViewById(R.id.bResult);
		passTog = (ToggleButton) findViewById(R.id.tbPassword);
		input = (EditText) findViewById(R.id.etCommands);
		display = (TextView) findViewById(R.id.tvResults);
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.tbPassword) {
			togglePasswordView();
		} else if (id == R.id.bResult) {
			commandExecuter();
		} else if (id == R.id.etCommands) {

		} else if (id == R.id.tvResults) {

		}
	}
	private void togglePasswordView() {
		if (passTog.isChecked()) {
			input.setInputType(InputType.TYPE_CLASS_TEXT
					| InputType.TYPE_TEXT_VARIATION_PASSWORD);
		} else {
			input.setInputType(InputType.TYPE_CLASS_TEXT);
		}
	}

	private void commandExecuter() {

		String check = input.getText().toString();
		display.setText(check);
		if (check.contentEquals("left")) {
			display.setGravity(Gravity.LEFT);
		} else if (check.contentEquals("center")) {
			display.setGravity(Gravity.CENTER);
		} else if (check.contentEquals("right")) {
			display.setGravity(Gravity.RIGHT);
		} else if (check.contentEquals("blue")) {
			display.setTextColor(Color.BLUE);
		} else if (check.contentEquals("random")) {
			Random random = new Random();
			display.setText("random !!");
			display.setTextSize(random.nextInt(75));
			display.setTextColor(Color.rgb(random.nextInt(265),
					random.nextInt(265), random.nextInt(265)));
			switch (random.nextInt(3)) {
				case 0 :
					display.setGravity(Gravity.LEFT);
					break;
				case 1 :
					display.setGravity(Gravity.CENTER);
					break;
				case 2 :
					display.setGravity(Gravity.RIGHT);
					break;
				default :
					display.setGravity(Gravity.CENTER);

			}
		} else {
			display.setText("invalid");
			display.setGravity(Gravity.CENTER);
			display.setTextColor(Color.WHITE);
		}

	}
}
