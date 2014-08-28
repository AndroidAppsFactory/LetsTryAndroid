package org.jLeta.myfirstandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Splash screen
 * 
 * @author jLeta
 * 
 */
public class Splash extends Activity {

	MediaPlayer ourSong;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// display the splash activity
		setContentView(R.layout.splash);

		// Play music at background
		ourSong = MediaPlayer.create(Splash.this, R.raw.godisnotgead);
		ourSong.start();

		// Create thread to call the main activity after some sleep time
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(5000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				} finally {
					Intent openMainActivity = new Intent(
							"org.jLeta.myfirstandroidapp.MENU");
					startActivity(openMainActivity);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		super.onPause();
		ourSong.stop();
		finish();
	}
}
