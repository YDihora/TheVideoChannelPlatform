package model;

public class Monitor extends Follower {

	
	public Monitor(String f_Name, int maxNumberOfChannels) {
		super(f_Name,maxNumberOfChannels);
		this.status=1;
	
	}
	public String toString() {
		String result=null;
		
		
		if(this.n_c==0) {
		
		result = String.format("Monitor %s follows no channels.",
				this.f_Name);
		}
		else if(this.n_c>0){
			//Monitor Stat Sensor A follows [Cafe Music BGM].
			String channel;
			channel="[";
			for(int i=0;i<this.n_c;i++) {
				channel+=this.channels[i];
				if(i<this.n_c-1) {
					channel+=", ";
				}
			}
			channel+="]";
			result=String.format("Monitor %s follows %s.",
					this.f_Name,
					channel);
			
			
			
			
		}
		
		return result;
		
	}

}
