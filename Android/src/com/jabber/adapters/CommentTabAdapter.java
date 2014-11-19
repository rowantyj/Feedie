package com.jabber.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jabber.R;
import com.jabber.models.Comment;

public class CommentTabAdapter extends ArrayAdapter<Comment> {

	List<Comment> commentList;
	
	public CommentTabAdapter(Context context, int resource, List<Comment> commentList) {
		super(context, resource, commentList);

		this.commentList = commentList;
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
			
		Comment currentItem = commentList.get(position);
		
		LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView = inflater.inflate(R.layout.custom_comment_list, parent, false);
		
		TextView commentTV = (TextView) convertView.findViewById(R.id.commentTV);
		TextView timestampTV = (TextView) convertView.findViewById(R.id.time_stampTV);
		
		
		
		commentTV.setText(currentItem.getContent());
		timestampTV.setText(currentItem.getTimestamp());
		
		
		return convertView;
	}

	
	
	
	
}
