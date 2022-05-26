package model;

public class Follower{
	protected int status;
	protected String f_Name;
	protected String[] channels;
	protected int numberOfChannel;
	protected int n_c;
	
	public Follower(String name,int numberOfChannel) {
		this.f_Name = name;
		this.channels = new String[numberOfChannel];
		this.numberOfChannel = numberOfChannel;
		this.n_c = 0;
	}
	
}
