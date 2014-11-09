package org.jLeta.myfirstandroidapp;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity implements View.OnClickListener {

	ImageButton ib;
	Button b;
	ImageView iv;

	Intent intent;
	final static int cameraData = 0;
	Bitmap bmp;

	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.photo);
		initialiseComponents();
	}
	/**
	 * 
	 */
	private void initialiseComponents() {
		iv = (ImageView) findViewById(R.id.ivreturnPic);
		ib = (ImageButton) findViewById(R.id.ibTakepic);
		b = (Button) findViewById(R.id.bSetWall);
		ib.setOnClickListener(this);
		b.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.bSetWall :
				try {
					getApplicationContext().setWallpaper(bmp);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case R.id.ibTakepic :
				// target the camera Intent of the android phone.
				intent = new Intent(
						android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(intent, cameraData);
				break;
		}
	}

	/**
	 * NOTE call to startActivityForResult will propagated to those method.
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode == RESULT_OK) {
			Bundle extras = data.getExtras();
			bmp = (Bitmap) extras.get("data");
			iv.setImageBitmap(bmp);
		}

	}
}
