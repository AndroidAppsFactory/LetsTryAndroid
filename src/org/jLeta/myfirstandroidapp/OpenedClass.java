package org.jLeta.myfirstandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener,
		OnCheckedChangeListener {

	TextView tvQuestion, tvText;
	Button bReturn;
	RadioGroup rgAnswers;
	String gotBread;
	String setData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		initializeComponents();

		// receive data when it starts
		Bundle gotBundle = getIntent().getExtras();
		if (gotBundle != null) {
			gotBread = gotBundle.getString(Constants.BREAD);
			tvQuestion.setText(gotBread);
		}
	}

	private void initializeComponents() {
		tvQuestion = (TextView) findViewById(R.id.tvQuestion);
		tvText = (TextView) findViewById(R.id.tvText);
		bReturn = (Button) findViewById(R.id.bReturn);
		rgAnswers = (RadioGroup) findViewById(R.id.rgAnswers);
		rgAnswers.setOnCheckedChangeListener(this);
		bReturn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent personIntent = new Intent();
		Bundle backbackBundle = new Bundle();
		backbackBundle.putString(Constants.ANSWER, setData);
		personIntent.putExtras(backbackBundle);
		// since we are giving data as a result of what already passed to us a
		// data, we will need to return back like this:
		setResult(RESULT_OK, personIntent);
		// we also need to finish.
		finish();
	}

	/**
	 * whenever a radio button is usedm this will tell us which radio group and
	 * which radio specifically is selected from the group.
	 */
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.rCrazy:
			setData = "not really!";
			break;
		case R.id.rSuper:
			setData = "yes!! ";
			break;
		case R.id.rBoth:
			setData = "grrr!!";
			break;
		}
		tvText.setText(setData);
	}

}
