package com.feedie;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class Home extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
		{
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
		}

}
