package com.jabber.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.jabber.R;
import com.jabber.models.Topic;

public class CreateTopicFragment extends FragmentActivity {

	private EditText titleET, descET;
	private Button postBtn;
	private ImageButton uploadImgBtn;

	@Override
	public View onCreateView(String name, Context context, AttributeSet attrs) {

//		setContentView(R.layout.tmp_create_topic);
//		titleET = (EditText) findViewById(R.id.titleET);
//		descET = (EditText) findViewById(R.id.descriptionET);
//		postBtn = (Button) findViewById(R.id.postBtn);
//		uploadImgBtn = (ImageButton) findViewById(R.id.upload_ib);
//
//		postBtn.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//
//				String title = titleET.getText().toString();
//				String description = descET.getText().toString();
//				Topic topic = new Topic(title, description, null, "none");
//
//				Bundle b = new Bundle();
//				b.putParcelable("topic", topic);
//
//				
//				
//			}
//			
//		});
//
//		uploadImgBtn.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//
//				Toast.makeText(getApplicationContext(), "Under Construction", Toast.LENGTH_LONG).show();
//			}
//		});

		return super.onCreateView(name, context, attrs);
	}

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		
		setContentView(R.layout.tmp_create_topic);
		titleET = (EditText) findViewById(R.id.titleET);
		descET = (EditText) findViewById(R.id.descriptionET);
		postBtn = (Button) findViewById(R.id.postBtn);
		uploadImgBtn = (ImageButton) findViewById(R.id.upload_ib);

		postBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String title = titleET.getText().toString();
				String description = descET.getText().toString();
				Topic topic = new Topic(title, description, null, "none");

				Bundle b = new Bundle();
				b.putParcelable("topic", topic);

				
				
			}
			
		});

		uploadImgBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast.makeText(getApplicationContext(), "Under Construction", Toast.LENGTH_LONG).show();
			}
		});

		
	}
	
	

}
