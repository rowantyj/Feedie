package com.jabber.models;

import android.os.Parcel;
import android.os.Parcelable;

/*
 *  An abstract parent class of LocationTopic, ProductTopic & etc...
 */
public class Topic implements Parcelable
{

	private String	title;
	private String	desc;
	private String	indicator;
	private String	category;

	/* Future Expansion... */
	// private int topicPic;
	// private Date creationDate, lastUpdate, expireDate;
	// private boolean isVerified;
	// private ArrayList<String> labels;

	public Topic(String title, String desc, String indicator, String category)
	{
		this.title = title;
		this.desc = desc;
		this.indicator = indicator;
		this.category = category;
	}

	public String getTitle()
	{
		return title;
	}

	public String getDesc()
	{
		return desc;
	}

	public String getIndicator()
	{
		return indicator;
	}

	public String getCategory()
	{
		return category;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public void setIndicator(String indicator)
	{
		this.indicator = indicator;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public Topic(Parcel in)
	{
		String[] data = new String[3];

		in.readStringArray(data);
		this.title = data[0];
		this.desc = data[1];
		this.indicator = data[2];
		this.category = data[3];
	}

	@Override
	public int describeContents()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		// TODO Auto-generated method stub
		dest.writeStringArray(new String[] { this.title, this.desc,
				this.indicator, this.category });
	}

	public static final Parcelable.Creator	CREATOR	= new Parcelable.Creator()
													{
														public Topic createFromParcel(
																Parcel in)
														{
															return new Topic(in);
														}

														public Topic[] newArray(
																int size)
														{
															return new Topic[size];
														}
													};

}
