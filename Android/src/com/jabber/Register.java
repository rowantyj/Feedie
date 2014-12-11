package com.jabber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.jabber.utils.Config;
import com.jabber.utils.JSONParser;

public class Register extends Activity implements OnClickListener {

	private ProgressDialog pDialog;
	private Button submitBtn;
	private EditText usernameET, passwordET, confirmPassET, emailET, nameET,
			dobET;

	private AutoCompleteTextView countryAutoTV;

	private RadioButton maleRB, femaleRB;

	private String dayStr, monthStr, yearStr;
	private String gender;
	private Spinner spinYear, spinMonth, spinDay;

	JSONParser jsonParser = new JSONParser();
	int dayIndex;

	// php login script location:

	// localhost :
	// testing on your device
	// put your local ip instead, on windows, run CMD > ipconfig
	// or in mac's terminal type ifconfig and look for the ip under en0 or en1

	// Jun's IP
	// private static final String LOGIN_URL =
	// "http://192.168.0.4/jabber/register.php";

	// Rowan's IP
	// private static final String LOGIN_URL =
	// "http://192.168.1.5/jabber/register.php";

	// testing on Emulator:
	// private static final String LOGIN_URL =
	// "http://10.0.2.2:1234/webservice/login.php";

	// testing from a real server:
	// private static final String LOGIN_URL =
	// "http://www.yourdomain.com/webservice/login.php";

	// JSON element ids from response of php script:
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_MESSAGE = "message";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_page);

		dayIndex = 0;

		initView();

		populateCountry();
	}

	void initView() {
		usernameET = (EditText) findViewById(R.id.usernameET);
		passwordET = (EditText) findViewById(R.id.passwordET);
		confirmPassET = (EditText) findViewById(R.id.confirmPasswordET);
		emailET = (EditText) findViewById(R.id.emailET);
		nameET = (EditText) findViewById(R.id.nameET);
		dobET = (EditText) findViewById(R.id.dobET);
		dobET.setOnClickListener(this);
		countryAutoTV = (AutoCompleteTextView) findViewById(R.id.countryAutoTV);

		maleRB = (RadioButton) findViewById(R.id.radioMale);
		femaleRB = (RadioButton) findViewById(R.id.radioFemale);
		maleRB.setChecked(true);
		femaleRB.setChecked(false);
		gender = "M";

		submitBtn = (Button) findViewById(R.id.submitBtn);

		submitBtn.setOnClickListener(this);
	}

	void populateDOBSpinner() {
		// Populate year Spinner
		ArrayList<String> years = new ArrayList<String>();

		int thisYear = Calendar.getInstance().get(Calendar.YEAR);

		for (int i = 1900; i <= thisYear; i++) {
			years.add(Integer.toString(i));
		}

		ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, years);

		spinYear.setAdapter(yearAdapter);

		// Populate month Spinner
		ArrayList<String> months = new ArrayList<String>();

		String monthArray[] = { "January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November",
				"December" };

		for (int i = 0; i < 12; i++) {
			months.add(monthArray[i]);
		}

		ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, months);

		spinMonth.setAdapter(monthAdapter);

		// Populate day Spinner
		final ArrayList<String> days = new ArrayList<String>();

		// If Months is changed
		spinMonth.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				days.clear();
				// Months with 31 days
				if (position == 0 || position == 2 || position == 4
						|| position == 8 || position == 9 || position == 11) {
					for (int i = 1; i < 32; i++) {
						days.add(Integer.toString(i));

						ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(
								Register.this,
								android.R.layout.simple_spinner_item, days);

						spinDay.setAdapter(dayAdapter);
						spinDay.setSelection(dayIndex);
					}
				}
				// February
				else if (position == 1)

				{
					// Leap Year
					if (Integer.parseInt(spinYear.getSelectedItem().toString()) % 4 == 0) {
						for (int i = 1; i < 30; i++) {
							days.add(Integer.toString(i));

							ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(
									Register.this,
									android.R.layout.simple_spinner_item, days);

							spinDay.setAdapter(dayAdapter);

							if (dayIndex > 28)
								spinDay.setSelection(28);
							else
								spinDay.setSelection(dayIndex);
						}
					}
					// Not Leap Year
					else {
						for (int i = 1; i < 29; i++) {
							days.add(Integer.toString(i));

							ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(
									Register.this,
									android.R.layout.simple_spinner_item, days);

							spinDay.setAdapter(dayAdapter);

							if (dayIndex > 27)
								spinDay.setSelection(27);
							else
								spinDay.setSelection(dayIndex);
						}
					}
				}
				// Months with 30 days
				else {
					for (int i = 1; i < 31; i++) {
						days.add(Integer.toString(i));

						ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(
								Register.this,
								android.R.layout.simple_spinner_item, days);

						spinDay.setAdapter(dayAdapter);

						if (dayIndex > 29)
							spinDay.setSelection(29);
						else
							spinDay.setSelection(dayIndex);
					}
				}

				monthStr = position + 1 + "";

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}

		});

		// If Year is changed
		spinYear.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// Leap Year
				if (Integer.parseInt(spinYear.getItemAtPosition(position)
						.toString()) % 4 == 0) {
					// February
					if (spinMonth.getSelectedItemPosition() == 1) {
						days.clear();
						for (int i = 1; i < 30; i++) {
							days.add(Integer.toString(i));

							ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(
									Register.this,
									android.R.layout.simple_spinner_item, days);

							spinDay.setAdapter(dayAdapter);

							if (dayIndex > 28)
								spinDay.setSelection(28);
							else
								spinDay.setSelection(dayIndex);
						}
					}
				}
				// Not Leap Year
				else {
					// February
					if (spinMonth.getSelectedItemPosition() == 1) {
						days.clear();
						for (int i = 1; i < 29; i++) {
							days.add(Integer.toString(i));

							ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(
									Register.this,
									android.R.layout.simple_spinner_item, days);

							spinDay.setAdapter(dayAdapter);

							if (dayIndex > 27)
								spinDay.setSelection(27);
							else
								spinDay.setSelection(dayIndex);
						}
					}
				}

				yearStr = spinYear.getItemAtPosition(position) + "";

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}

		});
		spinDay.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				dayIndex = position;
				dayStr = position + 1 + "";
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
	}

	void populateCountry() {
		List<String> countries = Arrays.asList(getResources().getStringArray(
				R.array.countries_list));

		Collections.sort(countries, String.CASE_INSENSITIVE_ORDER);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, countries);
		countryAutoTV.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {

		if (v.getId() == R.id.submitBtn) {
			// new CreateUser().execute();

			Toast t = Toast.makeText(getBaseContext(), "Account Registered",
					Toast.LENGTH_SHORT);

			t.setGravity(Gravity.CENTER, 0, 0);
			t.show();

			onBackPressed();

		} else if (v.getId() == R.id.dobET) {
			Toast.makeText(this, "DOB", Toast.LENGTH_SHORT).show();
			AlertDialog.Builder dialog = new AlertDialog.Builder(this);
			dialog.setTitle("Date of Birth");
			LayoutInflater inflater = getLayoutInflater();
			View view = inflater.inflate(R.layout.dialog_dob, null);
			dialog.setView(view);
			spinYear = (Spinner) view.findViewById(R.id.yearSpinner);
			spinMonth = (Spinner) view.findViewById(R.id.monthSpinner);
			spinDay = (Spinner) view.findViewById(R.id.daySpinner);
			populateDOBSpinner();
			dialog.setPositiveButton("Confirm Change",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							dayStr = spinDay.getSelectedItem().toString();
							monthStr = (spinMonth.getSelectedItemPosition() + 1)
									+ "";
							yearStr = spinYear.getSelectedItem().toString();

							dobET.setText(dayStr + " / " + "0" + monthStr
									+ " / " + yearStr);
						}
					});
			dialog.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
						}
					});

			dialog.create();
			dialog.show();
		}

	}

	public void onRadioButtonClicked(View view) {

		boolean checked = ((RadioButton) view).isChecked();

		switch (view.getId()) {
		case R.id.radioMale:
			if (checked)
				gender = "M";
			break;
		case R.id.radioFemale:
			if (checked)
				gender = "F";
			break;
		}
	}

	class CreateUser extends AsyncTask<String, String, String> {

		/** Before starting background thread Show Progress Dialog */
		boolean failure = false;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(Register.this);
			pDialog.setMessage("Creating User...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... args) {
			// Check for success tag
			int success;
			String username = usernameET.getText().toString();
			String password = passwordET.getText().toString();
			String email = emailET.getText().toString();
			String name = nameET.getText().toString();
			// Gender is already at the top
			String date_of_birth = yearStr + "-" + monthStr + "-" + dayStr;
			String country = countryAutoTV.getText().toString();

			try {
				// Building Parameters
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("username", username));
				params.add(new BasicNameValuePair("password", password));
				params.add(new BasicNameValuePair("email", email));
				params.add(new BasicNameValuePair("name", name));
				params.add(new BasicNameValuePair("gender", gender));
				params.add(new BasicNameValuePair("date_of_birth",
						date_of_birth));
				params.add(new BasicNameValuePair("country", country));

				Log.d("request!", "starting");

				// Posting user data to script
				JSONObject json = jsonParser.makeHttpRequest(
						Config.REGISTER_URL, "POST", params);

				// full json response
				Log.d("Login attempt", json.toString());

				// json success element
				success = json.getInt(TAG_SUCCESS);
				if (success == 1) {
					Log.d("Account Created!", json.toString());
					finish();
					// Intent i = new Intent(RegisterPage.this,
					// LoginPage.class);
					// startActivity(i);
					return json.getString(TAG_MESSAGE);
				} else {
					Log.d("Login Failure!", json.getString(TAG_MESSAGE));
					return json.getString(TAG_MESSAGE);

				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

			return null;

		}

		/** After completing background task Dismiss the progress dialog **/
		protected void onPostExecute(String file_url) {
			// dismiss the dialog once product deleted
			pDialog.dismiss();
			if (file_url != null) {
				Toast.makeText(Register.this, file_url, Toast.LENGTH_LONG)
						.show();
			}

		}

	}

}
