package com.jabber.adapters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.R.anim;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.jabber.R;
import com.jabber.fragments.ExploreFragment;

public class GridViewAdapter extends ArrayAdapter<String> {

	private Context context;
	private ArrayList<String> categoryList;
	
	// load gradient for better looks
	private final List<Integer> colorList = Arrays.asList(Color.YELLOW, Color.CYAN, Color.GREEN, Color.GRAY, Color.RED, Color.MAGENTA);
	private Button category_btn;

	public GridViewAdapter(Context context, ArrayList<String> categoryList) {
		super(context, R.layout.childview_category, categoryList);
		this.context = context;
		this.categoryList = categoryList;

	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View rowView = convertView;
		
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rowView = inflater.inflate(R.layout.childview_category, parent,
                false);
		
        category_btn = (Button) rowView.findViewById(R.id.categoryBtn);
        
        category_btn.setText(categoryList.get(position));
        category_btn.setBackgroundColor(colorList.get(position));
        
        category_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				String toastMsg = categoryList.get(position) + " is clicked!";

				Toast t = Toast.makeText(getContext(), toastMsg, Toast.LENGTH_SHORT);
				t.setGravity(Gravity.CENTER, 0, 0);
				t.show();
				
				//The selection will determine the Filter parameter then pass to next screen

				context.startActivity(new Intent(context, ExploreFragment.class));
				
				
				
				

			}
		});
        		
		return rowView;
	}

}