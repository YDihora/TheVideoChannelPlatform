package model;

public class Subscriber extends Follower {
	
	private String[] videos;
	private int numberOfVideos;
	private int n_v;
	

	public Subscriber(String s_Name, int numberOfChannel, int numberOfVideos) {
		super(s_Name,numberOfChannel);
		this.numberOfVideos = numberOfVideos;
		this.videos = new String[numberOfVideos];
		this.n_v = 0;
		this.n_c =0;
		this.status=0;
	
	}
	
	public void recommendVideo(String name) {
		this.videos[this.n_v] = name;
		this.n_v++; 
		
	}
	
	public String toString() {
		String result=null;
		if(this.n_c==0&&this.n_v==0) {
		result= String.format("Subscriber %s follows no channels and has no recommended videos.",
    			this.f_Name);
		}
		else if(this.n_v==0&&this.n_c>0) {
			//Subscriber Alan follows [Cafe Music BGM] and has no recommended videos.
			String channel;
			channel="[";
			for(int i=0;i<this.n_c;i++) {
				channel+=this.channels[i];
				if(i<this.n_c-1) {
					channel+=", ";
				}
			}
			channel+="]";
			result=String.format("Subscriber %s follows %s and has no recommended videos.",
					this.f_Name,
					channel);
		
			
		}
		
		else if(this.n_c>0&&this.n_v>0) {
			// Subscriber Alan follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio>.
			String channel;
			channel="[";
			for(int i=0;i<this.n_c;i++) {
				channel+=this.channels[i];
				if(i<this.n_c-1) {
					channel+=", ";
				}
			}
			channel+="]";
			
			String videos;
			videos="<";
			for(int i=0;i<this.n_v;i++) {
				videos+=this.videos[i];
				if(i<this.n_v-1) {
					videos+=", ";
				}
			}
			videos+=">";
			
			
			result=String.format("Subscriber %s follows %s and is recommended %s.",
					this.f_Name,
					channel,
					videos);
		
			
			
			
		}
		return result;
		
	}
	


}
