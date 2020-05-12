package part3;

public class Television {
	
	public static void changeChannel(Channels channel) {
		switch(channel) {
			case NICKELODEAN: 
				System.out.println("Channel " + Integer.toString(channel.getChannelNumber()));
				break;
				
			case CARTOONNETWORK: 
				System.out.println("Channel " + Integer.toString(channel.getChannelNumber()));
				break;
				
			case DISNEY: 
				System.out.println("Channel " + Integer.toString(channel.getChannelNumber()));
				break;
				
			case NBA: 
				System.out.println("Channel " + Integer.toString(channel.getChannelNumber()));
				break;
				
			case TNT: 
				System.out.println("Channel " + Integer.toString(channel.getChannelNumber()));
				break;
		}
	}
	
	public static void main(String args[]) {
		Channels disney = Channels.DISNEY;
		changeChannel(disney);
	}
}
