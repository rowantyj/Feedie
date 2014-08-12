package com.feedie;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class Splash extends Activity
{
	String				SHAREDPREFERENCES	= "SharedPreferences";
	SharedPreferences	sharedPreferences;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		sharedPreferences = getSharedPreferences(SHAREDPREFERENCES, 0);
		
		if(sharedPreferences.getBoolean("login", false) == true)
		{
			Intent i = new Intent(this,Home.class);
			startActivity(i);
		}
		else
		{
			Intent i = new Intent(this,Login.class);
			startActivity(i);
		}
	}

}
