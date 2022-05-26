package model;

public class Channel {
	private String name;
	private String[] videos;
	private Follower[] followers;
	private int nov;
	private int nof;
	private int numberOfFollowers;
	private int numberOfVideos;
	public Channel() {
		
	}

	public Channel(String name,int numberOfFollowers, int numberOfVideos) {
		this.name =name;
		this.numberOfFollowers = numberOfFollowers;
		this.numberOfVideos = numberOfVideos;
		this.videos = new String[numberOfVideos];
		this.nov=0;
		this.followers = new Follower[numberOfFollowers];
		this.nof=0;
		
	}
	public String toString() {
		String result=null;
		if(this.nov==0&&this.nof==0) {
			result = String.format("%s released no videos and has no followers.",
					this.name);
		}
		else if(this.nov>0&&this.nof==0){
			
			String videos;
			videos="<";
			for(int i=0;i<this.nov;i++) {
				videos+=this.videos[i];
				if(i<this.nov-1) {
					videos+=", ";
				}
			}
			videos+=">";
			//Cafe Music BGM released <Monday Jazz> and has no followers.
			
			
			result = String.format("%s released %s and has no followers.",
					this.name,
					videos);
			
		}
		else if(this.nov==0&&this.nof>0) {
			//Cafe Music BGM released no videos and is followed by [Subscriber Alan].
			
			String followers;
			followers="[";
			for(int i=0;i<this.nof;i++) {
				Follower f = this.followers[i];
				if(f instanceof Subscriber ) {
					followers+="Subscriber ";
				}
				else {
					followers+="Monitor ";
				}
				followers+=this.followers[i].f_Name;
				if(i<this.nof-1) {
					followers+=", ";
				}
			}
			followers+="]";
			
			result = String.format("%s released no videos and is followed by %s.",
					this.name,
					followers);
			
			
		}
		else if(this.nov>0&&this.nof>0) {
			//Cafe Music BGM released <Jazz Piano Radio, Starbucks Music Playlist 2021> and is followed by [Subscriber Alan].
			String followers;
			followers="[";
			for(int i=0;i<this.nof;i++) {
				Follower f = this.followers[i];
				if(f instanceof Subscriber ) {
					followers+="Subscriber ";
				}
				else {
					followers+="Monitor ";
				}
				followers+=this.followers[i].f_Name;
				if(i<this.nof-1) {
					followers+=", ";
				}
			}
			followers+="]";
			
			
			
			String videos;
			videos="<";
			for(int i=0;i<this.nov;i++) {
				videos+=this.videos[i];
				if(i<this.nov-1) {
					videos+=", ";
				}
			}
			videos+=">";
			
			
			
			result = String.format("%s released %s and is followed by %s.",
					this.name,
					videos
					,followers);
			
		}
		
		return result;
	}
	public void releaseANewVideo(String nameOfVideo) {
		this.videos[this.nov] = nameOfVideo;
		this.nov++;
		for(int i=0;i<this.nof;i++) {
			Follower f = this.followers[i];
			if(f instanceof Subscriber) {
				((Subscriber) f).recommendVideo(nameOfVideo);
				
			}
		}
	}

	public void follow(Follower f1) {
		if(f1.status==0) {
		this.followers[this.nof] = f1;
		this.nof++;
		int c=f1.n_c;
		f1.channels[c] = this.name;
		f1.n_c++;
		}
		else if(f1.status==1) {
			this.followers[this.nof] = f1;
			this.nof++;
			int c=f1.n_c;
			f1.channels[c] = this.name;
			f1.n_c++;
		}
		
	}

	public void unfollow(Follower f1) {
		
		if(f1.status==0) {
		for(int i=0;i<this.nof;i++) {
			if(this.followers[i].f_Name.equals(String.format(f1.f_Name))) {
				Follower temp;
				for(int j=i;j<this.nof;j++) {
					temp = this.followers[j];
					this.followers[j] = this.followers[j+1];
					this.followers[j+1]=temp;
					
					
				}
				this.followers[this.nof]=null;
				this.nof--;
				break;
				
				
						
				}
			
			}
		
		}
		else if(f1.status==1) {
			for(int i=0;i<this.nof;i++) {
				if(this.followers[i].f_Name.equals(String.format(f1.f_Name))) {
					Follower temp;
					for(int j=i;j<this.nof;j++) {
						temp = this.followers[j];
						this.followers[j] = this.followers[j+1];
						this.followers[j+1]=temp;
						
						
					}
					this.followers[this.nof]=null;
					this.nof--;
					break;
					
					
							
					}
				
				}
			
		}
		
		int n = f1.n_c;
		for(int i=0;i<n;i++) {
			if(f1.channels[i].equals(this.name)) {
				String temp;
				for(int j=i;j<n;j++) {
					temp = f1.channels[j];
					f1.channels[j] = f1.channels[j+1];
					f1.channels[j+1]=temp;
					
					
				}
				f1.channels[n]=null;
				f1.n_c--;
				break;
			}
			
		}
		
	}
	
}
