package com.jabber.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jabber.R;
import com.jabber.models.Topic;

public class TopicLineAdapter extends ArrayAdapter<Topic> {

    private final Context context;
    private final ArrayList<Topic> topicList;
    private TextView title;
    private TextView desc;
    private ImageView indicator;

    public TopicLineAdapter(Context context, ArrayList<Topic> topicList) {
        super(context, R.layout.custom_topicline_list, topicList);
        this.context = context;
        this.topicList = topicList;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rowView = inflater.inflate(R.layout.custom_topicline_list, parent,
                false);
        title = (TextView) rowView.findViewById(R.id.titleTV);
        desc = (TextView) rowView.findViewById(R.id.descTV);
        indicator = (ImageView) rowView.findViewById(R.id.indicatorIV);

        // Setting Values...
        title.setText(topicList.get(position).getTitle());
        desc.setText(topicList.get(position).getDesc());
        
        if(topicList.get(position).getIndicator().equalsIgnoreCase("red"))
        {
        	indicator.setImageResource(R.drawable.indicator_red);
        	title.setTypeface(null, Typeface.NORMAL);
        }
        else if(topicList.get(position).getIndicator().equalsIgnoreCase("yellow"))
        {
        	indicator.setImageResource(R.drawable.indicator_yellow);
        }
        else if(topicList.get(position).getIndicator().equalsIgnoreCase("green"))
        {
        	indicator.setImageResource(R.drawable.indicator_green);
        	title.setTypeface(null, Typeface.BOLD);
        }

        return rowView;

    }

}