package com.jabber.fragments;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jabber.R;
import com.jabber.adapters.CommentTabAdapter;
import com.jabber.models.Comment;

/**
 * Created by rowantan on 10/6/14.
 */
public class CommentFragment extends Fragment implements View.OnClickListener {

	private ListView commentList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_comment_tab, container, false);

		
		ArrayList<Comment> tmpList = new ArrayList<Comment>();
		tmpList.add(new Comment("Rowan is tired", "1234"));
		tmpList.add(new Comment("Rowan is a bit tired", "1234"));
		tmpList.add(new Comment("Rowan is slightly tired", "1234"));
		tmpList.add(new Comment("Rowan is quite tired", "1234"));
		tmpList.add(new Comment("Rowan is very tired", "1234"));
		tmpList.add(new Comment("Rowan is super tired", "1234"));
		tmpList.add(new Comment("Rowan is super super tired", "1234"));
		//Stopped here...
		
		
		CommentTabAdapter cta = new CommentTabAdapter(getActivity(), 0, tmpList);
		
		commentList = (ListView) rootView.findViewById(R.id.comment_listView);
		commentList.setAdapter(cta);
		
		return rootView;

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}
}
