package com.feedie;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginPage extends Activity
{

	Button signUpBtn, signInBtn;
	EditText emailET, passwordET;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_page);

		ActionBar actionBar = getActionBar();

		actionBar.setDisplayHomeAsUpEnabled(true);
		
		signUpBtn = (Button) findViewById(R.id.SIBtn);
		signInBtn = (Button) findViewById(R.id.SUBtn);
	}

	public void onClick(View v)
	{
		if(v.getId() == R.id.SUBtn)
		{
			Intent i = new Intent(this, RegisterPage.class);
			startActivity(i);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
