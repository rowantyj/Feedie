package com.jabber.topicline;

import java.util.ArrayList;
import java.util.Calendar;

import com.jabber.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class EditProfileFragment extends Fragment
{

	private EditText	passwordET, confirmPassET, emailET, fullNameET,
			countryET;

	private RadioButton	maleRB, femaleRB;

	private String		dayStr, monthStr, yearStr;
	private Spinner		spinYear, spinMonth, spinDay;
	int					dayIndex;

	public EditProfileFragment()
	{
		
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//populateDOBSpinner();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.edit_profile, null, false);

		passwordET = (EditText) rootView.findViewById(R.id.passwordET);
		confirmPassET = (EditText) rootView
				.findViewById(R.id.confirmPasswordET);
		emailET = (EditText) rootView.findViewById(R.id.emailET);
		fullNameET = (EditText) rootView.findViewById(R.id.fullNameET);
		countryET = (EditText) rootView.findViewById(R.id.countryET);
		confirmPassET = (EditText) rootView
				.findViewById(R.id.confirmPasswordET);

		maleRB = (RadioButton) rootView.findViewById(R.id.radioMale);
		femaleRB = (RadioButton) rootView.findViewById(R.id.radioFemale);
		maleRB.setChecked(true);
		femaleRB.setChecked(false);
		spinYear = (Spinner) rootView.findViewById(R.id.yearSpinner);
		spinMonth = (Spinner) rootView.findViewById(R.id.monthSpinner);
		spinDay = (Spinner) rootView.findViewById(R.id.daySpinner);

		return rootView;
	}

	void populateDOBSpinner()
	{
		// Populate year Spinner
		ArrayList<String> years = new ArrayList<String>();

		int thisYear = Calendar.getInstance().get(Calendar.YEAR);

		for (int i = 1900; i <= thisYear; i++)
		{
			years.add(Integer.toString(i));
		}

		ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(
				this.getActivity(), android.R.layout.simple_spinner_item, years);

		spinYear.setAdapter(yearAdapter);

		// Populate month Spinner
		ArrayList<String> months = new ArrayList<String>();

		String monthArray[] = { "January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November",
				"December" };

		for (int i = 0; i < 12; i++)
		{
			months.add(monthArray[i]);
		}

		ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(
				this.getActivity(), android.R.layout.simple_spinner_item,
				months);

		spinMonth.setAdapter(monthAdapter);

		// Populate day Spinner
		final ArrayList<String> days = new ArrayList<String>();

		// If Months is changed
		spinMonth.setOnItemSelectedListener(new OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id)
			{
				days.clear();
				// Months with 31 days
				if (position == 0 || position == 2 || position == 4
						|| position == 8 || position == 9 || position == 11)
				{
					for (int i = 1; i < 32; i++)
					{
						days.add(Integer.toString(i));

						ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(
								getActivity(),
								android.R.layout.simple_spinner_item, days);

						spinDay.setAdapter(dayAdapter);
						spinDay.setSelection(dayIndex);
					}
				}
				// February
				else if (position == 1)

				{
					// Leap Year
					if (Integer.parseInt(spinYear.getSelectedItem().toString()) % 4 == 0)
					{
						for (int i = 1; i < 30; i++)
						{
							days.add(Integer.toString(i));

							ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(
									getActivity(),
									android.R.layout.simple_spinner_item, days);

							spinDay.setAdapter(dayAdapter);

							if (dayIndex > 28)
								spinDay.setSelection(28);
							else
								spinDay.setSelection(dayIndex);
						}
					}
					// Not Leap Year
					else
					{
						for (int i = 1; i < 29; i++)
						{
							days.add(Integer.toString(i));

							ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(
									getActivity(),
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
				else
				{
					for (int i = 1; i < 31; i++)
					{
						days.add(Integer.toString(i));

						ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(
								getActivity(),
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
			public void onNothingSelected(AdapterView<?> parent)
			{
			}

		});

		// If Year is changed
		spinYear.setOnItemSelectedListener(new OnItemSelectedListener()
		{

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id)
			{
				// Leap Year
				if (Integer.parseInt(spinYear.getItemAtPosition(position)
						.toString()) % 4 == 0)
				{
					// February
					if (spinMonth.getSelectedItemPosition() == 1)
					{
						days.clear();
						for (int i = 1; i < 30; i++)
						{
							days.add(Integer.toString(i));

							ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(
									getActivity(),
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
				else
				{
					// February
					if (spinMonth.getSelectedItemPosition() == 1)
					{
						days.clear();
						for (int i = 1; i < 29; i++)
						{
							days.add(Integer.toString(i));

							ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(
									getActivity(),
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
			public void onNothingSelected(AdapterView<?> parent)
			{
			}

		});
		spinDay.setOnItemSelectedListener(new OnItemSelectedListener()
		{

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id)
			{
				dayIndex = position;
				dayStr = position + 1 + "";
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0)
			{
			}
		});
	}

}
