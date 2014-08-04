package com.feedie;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RegisterPage extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_page);
		
		//Populate year Spinner
		ArrayList<String> years = new ArrayList<String>();
	   
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
	    
		for (int i = 1900; i <= thisYear; i++)
	    {
	        years.add(Integer.toString(i));
	    }
	   
		ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(this,
	            android.R.layout.simple_spinner_item, years);

	    final Spinner spinYear = (Spinner) findViewById(R.id.yearSpinner);
	    spinYear.setAdapter(yearAdapter);
	    
	    //Populate month Spinner
	    ArrayList<String> months = new ArrayList<String>();
	    
	    String monthArray [] = {"January", "February", "March", "April", "May", "June", 
	    		"July", "August", "September", "October", "November", "December"}; 
	    
	    for (int i = 0; i < 12; i++)
	    {
	    	months.add(monthArray[i]);
	    }
	    
	    ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(this,
	            android.R.layout.simple_spinner_item, months);

	    Spinner spinMonth = (Spinner) findViewById(R.id.monthSpinner);
	    spinMonth.setAdapter(monthAdapter);
	    
	    //Populate day Spinner
	    final ArrayList<String> days = new ArrayList<String>();
	    	    
	    spinMonth.setOnItemSelectedListener(new OnItemSelectedListener()
	    {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id)
			{
				days.clear();
				//Months with 31 days
				if (position == 0 || position == 2 || position == 4 || position == 8 || position == 9
	                    || position == 11)
				{
					for (int i = 1; i < 32; i++)
				    {
				    	days.add(Integer.toString(i));
				    }
				}
				//February
				else if(position == 1)
					
				{
					if(Integer.parseInt(spinYear.getSelectedItem().toString()) % 4 == 0)
					{
						for (int i = 1; i < 30; i++)
					    {
					    	days.add(Integer.toString(i));
					    }
					}
					else
					{
						for (int i = 1; i < 29; i++)
					    {
					    	days.add(Integer.toString(i));
					    }
					}
				}
				//Months with 30 days
				else
				{
					for (int i = 1; i < 31; i++)
				    {
				    	days.add(Integer.toString(i));
				    }
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent)
			{
			}
	    
	    });
	    
	    /*for (int i = 1; i < 32; i++)
	    {
	    	days.add(Integer.toString(i));
	    }*/
	    
	    if (spinMonth.getSelectedItemPosition() == 0 || spinMonth.getSelectedItemPosition() == 2 
	    		|| spinMonth.getSelectedItemPosition() == 4 || spinMonth.getSelectedItemPosition() == 8 
	    		|| spinMonth.getSelectedItemPosition() == 9 || spinMonth.getSelectedItemPosition() == 11)
	    {
	    	Log.e("MONTH", Integer.toString(spinMonth.getSelectedItemPosition()));
	    	/*for (int i = 1; i < 32; i++)
		    {
		    	days.add(Integer.toString(i));
		    }*/
	    }
	    else if(spinMonth.getSelectedItemPosition() == 1)
	    {
	    	Log.e("MONTH", Integer.toString(spinMonth.getSelectedItemPosition()));
	    	/*for (int i = 1; i < 29; i++)
		    {
		    	days.add(Integer.toString(i));
		    }*/
	    }
	    else
	    {
	    	Log.e("MONTH", Integer.toString(spinMonth.getSelectedItemPosition()));
	    	/*for (int i = 1; i < 31; i++)
		    {
		    	days.add(Integer.toString(i));
		    }*/
	    }

	    ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(this, 
	    		android.R.layout.simple_spinner_item, days);
	    
	    Spinner spinDay = (Spinner) findViewById(R.id.daySpinner);
	    spinDay.setAdapter(dayAdapter);

	}

}
