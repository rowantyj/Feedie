package com.feedie;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.feedie.utils.JSONParser;

public class LoginPage extends Activity implements OnClickListener
{

	Button											signUpBtn, signInBtn;
	EditText										emailET, passwordET;
	ProgressDialog							pDialog;

	// JSON parser class
	JSONParser									jsonParser	= new JSONParser();

	// php login script location:

	// localhost :
	// testing on your device
	// put your local ip instead, on windows, run CMD > ipconfig
	// or in mac's terminal type ifconfig and look for the ip under en0 or en1
	private static final String	LOGIN_URL		= "http://192.168.1.5:80/feedie/login.php";

	// testing on Emulator:
	// private static final String LOGIN_URL = "http://10.0.2.2:1234/webservice/login.php";

	// testing from a real server:
	// private static final String LOGIN_URL = "http://www.yourdomain.com/webservice/login.php";

	// JSON element ids from response of php script:
	private static final String	TAG_SUCCESS	= "success";
	private static final String	TAG_MESSAGE	= "message";

	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_page);

		ActionBar actionBar = getActionBar();

		actionBar.setDisplayHomeAsUpEnabled(true);

		signUpBtn = (Button) findViewById(R.id.SUBtn);
		signInBtn = (Button) findViewById(R.id.SIBtn);
		emailET = (EditText) findViewById(R.id.emailET);
		passwordET = (EditText) findViewById(R.id.passwordET);

		signInBtn.setOnClickListener(this);
		signUpBtn.setOnClickListener(this);

		}

	public void onClick(View v)
		{
		if (v.getId() == R.id.SUBtn)
			{
			Intent i = new Intent(this, RegisterPage.class);
			startActivity(i);
			}
		if (v.getId() == R.id.SIBtn)
			{
			new AttemptLogin().execute();
			}
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
		{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		}

	// -----------------------------------------------------------------------------------------------------
	// AsyncTask is a separate thread than the thread that runs the GUI
	// Any type of networking should be done with asynctask.

	class AttemptLogin extends AsyncTask<String, String, String> {

		// three methods get called, first preExecture, then do in background, and once do
		// in back ground is completed, the onPost execute method will be called.

		boolean	failure	= false;

		@Override
		protected void onPreExecute()
			{
			super.onPreExecute();
			pDialog = new ProgressDialog(LoginPage.this);
			pDialog.setMessage("Attempting login...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
			}

		@Override
		protected String doInBackground(String... args)
			{

			int status = 0;
			String username = emailET.getText().toString();
			String password = passwordET.getText().toString();

			try
				{

				// Building Parameters
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("username", username));
				params.add(new BasicNameValuePair("password", password));

				Log.d("Request", "STARTING");
				// Getting product details by making HTTP Request
				JSONObject json = jsonParser.makeHttpRequest(LOGIN_URL, "POST", params);

				// check your log for json response
//				Log.d("Login attempt", json.toString());

				// json success tag
				status = json.getInt(TAG_SUCCESS);
				if (status == 1)
					{
					Log.d("Login Successful!", json.toString());
					Intent i = new Intent(LoginPage.this, Home.class);
					finish();
					startActivity(i);
					return json.getString(TAG_MESSAGE);
					}
				else if(status == 0)
					{
					Log.d("Login Failure!", json.getString(TAG_MESSAGE));
					return json.getString(TAG_MESSAGE);

					}
				} catch (JSONException e)
				{
				e.printStackTrace();
				}

			return null;

			}

		/** After completing background task Dismiss the progress dialog **/
		protected void onPostExecute(String file_url)
			{
			// dismiss the dialog once product deleted
			pDialog.dismiss();
			if (file_url != null)
				{
				Toast.makeText(LoginPage.this, file_url, Toast.LENGTH_LONG).show();
				}

			}

	}
}
