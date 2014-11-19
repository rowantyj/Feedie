package com.jabber.fragments;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.jabber.R;
import com.jabber.adapters.CommentTabAdapter;
import com.jabber.models.Comment;

/**
 * Created by rowantan on 10/6/14.
 */
public class CommentFragment extends Fragment implements View.OnClickListener {

	private static final String ERROR_MSG = "Silence is NOT golden here! Comment something.";
	private ListView commentList;
	private Button sendBtn;
	private EditText commentET;

	private ArrayList<Comment> tmpList;
	private CommentTabAdapter mAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_comment_tab, container, false);

		sendBtn = (Button) rootView.findViewById(R.id.sendBtn);
		commentET = (EditText) rootView.findViewById(R.id.commentET);

		sendBtn.setOnClickListener(this);

		tmpList = new ArrayList<Comment>();
		tmpList.add(new Comment(
				"Wow, The comment actually works! I'm giving this app 5 stars rating! It made my day!(Miserable)",
				"1234"));

		mAdapter = new CommentTabAdapter(getActivity(), 0, tmpList);

		commentList = (ListView) rootView.findViewById(R.id.comment_listView);
		commentList.setAdapter(mAdapter);

		return rootView;

	}

	@Override
	public void onClick(View v) {

		if (v.getId() == R.id.sendBtn) {

			String content = commentET.getText().toString();
			String timestamp = System.currentTimeMillis() + "";

			AlertDialog.Builder adb = new Builder(getActivity());
			adb.setTitle("Don't Panic!");
			adb.setMessage("The comment WILL be gone when you exit here. It's very normal.");
			adb.setNegativeButton("No! I don't allow that!", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {

					Toast.makeText(getActivity(), "LOL, WHO CARES", Toast.LENGTH_LONG).show();
				}
			});
			adb.setPositiveButton("Got it!", null);
			

			if (!content.equals("")) {

				try {
					tmpList.add(new Comment(content, timestamp));

					commentList.invalidateViews();
				} catch (Exception e) {
					// TODO: handle exception
				}

//				Toast.makeText(getActivity(), "Comment Posted", Toast.LENGTH_SHORT).show();
				commentET.setText("");
				adb.show();

			} else {
				Toast.makeText(getActivity(), ERROR_MSG, Toast.LENGTH_LONG).show();
			}
		}
	}
}
