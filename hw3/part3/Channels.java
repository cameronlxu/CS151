package part3;

public enum Channels {
	NICKELODEAN(53), 
	CARTOONNETWORK(54), 
	DISNEY(55), 
	NBA(1), 
	TNT(2);
	
	private final int channelNumber;
	
	private Channels(int channelNumber) {
		this.channelNumber = channelNumber;
	}
	
	public int getChannelNumber() {
		return channelNumber;
	}
	
}
