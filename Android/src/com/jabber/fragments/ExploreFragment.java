package com.jabber.fragments;

import com.jabber.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class ExploreFragment extends FragmentActivity {

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.fragment_explore);
		
		Toast.makeText(getApplicationContext(), "Wait la, Not yet", Toast.LENGTH_SHORT).show();
		
		
	}

	@Override
	public View onCreateView(String name, Context context, AttributeSet attrs) {

		
		
		
		
		
		
		
		return super.onCreateView(name, context, attrs);
	}
	
	
	
	
	

}
