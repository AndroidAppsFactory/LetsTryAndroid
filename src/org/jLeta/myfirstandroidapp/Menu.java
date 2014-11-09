package org.jLeta.myfirstandroidapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String classes[] = { "Starter", "TextPlay", "Email", "Camera", "Data" };

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_list_item_1, classes));

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		// get the selected Item from the list (the one selected will be the one
		// at position).
		String selectedClass = classes[position];

		// start activity on List Item click

		try {
			// a different way of calling an intent instead of using the action
			// name in menifest.xml file
			@SuppressWarnings("rawtypes")
			Class classQualifierName = Class
					.forName("org.jLeta.myfirstandroidapp." + selectedClass);
			Intent intent = new Intent(Menu.this, classQualifierName);
			startActivity(intent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * MENU Inflater : this help is to defined what activity to display when
	 * menu button of a phone is pressed - while our application is running.
	 */
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater blowup = getMenuInflater();
		blowup.inflate(R.menu.coolmenu, menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case R.id.aboutUs:
			Intent a = new Intent("org.jLeta.myfirstandroidapp.ABOUT");
			startActivity(a);
			break;
		case R.id.preferences:
			Intent p = new Intent("org.jLeta.myfirstandroidapp.PREF");
			startActivity(p);
			break;
		case R.id.Exit:
			// exit application
			finish();
			break;
		}
		return false;

	}
}
