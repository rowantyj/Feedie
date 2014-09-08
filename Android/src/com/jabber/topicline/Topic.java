package com.jabber.topicline;



/*
 *  An abstract parent class of LocationTopic, ProductTopic & etc...
 */
public class Topic {

	private String	title;
	private String	desc;
	private int			indicator;
	private String	category;
	
	/* Future Expansion... */
	// private int topicPic;
	// private Date creationDate, lastUpdate, expireDate;
	// private boolean isVerified;
	// private ArrayList<String> labels;
	

	public Topic(String title, String desc, int indicator, String category)
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

	public int getIndicator()
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

	public void setIndicator(int indicator)
		{
		this.indicator = indicator;
		}

	public void setCategory(String category)
		{
		this.category = category;
		}

}
