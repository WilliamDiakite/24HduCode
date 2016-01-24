import java.io.*;

import sun.audio.*;

public class Musique {
	
	AudioPlayer ap;
	AudioData ad;
	AudioStream as;
	
	public Musique(){
		ContinuousAudioDataStream loop;
		ap = AudioPlayer.player;
		try {
			InputStream is = new FileInputStream("C:\\Users\\William.DESKTOP-F17CGCG\\Desktop\\musique.mp3");
			as = new AudioStream(is);
			ad = as.getData();
			loop = new ContinuousAudioDataStream(ad);
			ap.start(loop);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
