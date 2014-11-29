package com.jabber.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.jabber.R;

public class CustomCreateTopicDialogFragment extends DialogFragment{

	private EditText titleET, descET;
	private Button postBtn;
	private ImageButton uploadImgBtn;
	
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		
		
		return super.onCreateDialog(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
	View rootView =  inflater.inflate(R.layout.tmp_create_topic, container, false);
	
	titleET = (EditText) rootView.findViewById(R.id.titleET);
	descET = (EditText) rootView.findViewById(R.id.descriptionET);
	postBtn = (Button) rootView.findViewById(R.id.postBtn);
	uploadImgBtn = (ImageButton) rootView.findViewById(R.id.upload_ib);
	
	postBtn.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {

			String title = titleET.getText().toString();
			String description = descET.getText().toString();
			
			
			
		}
	});
	
	uploadImgBtn.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {

			Toast.makeText(getActivity(), "Under Construction", Toast.LENGTH_LONG).show();
		}
	});
	
	
	
	
	
	
	return rootView;
	}
	
	
	
	

}
