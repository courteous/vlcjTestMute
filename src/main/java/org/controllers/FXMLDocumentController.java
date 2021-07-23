package org.controllers;



import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.base.AudioApi;
import uk.co.caprica.vlcj.player.base.MediaApi;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;


public class FXMLDocumentController implements Initializable {

	
	@FXML
	private Button buttonPlayID;
    
	@FXML
	private Button buttonMuteId;
    
	
	@FXML
	private Button buttonUnmuteId;
    	
    
	MediaPlayerFactory mediaPlayerFactory;
    private EmbeddedMediaPlayer embeddedMediaPlayer;
    private MediaPlayerEventAdapter embeddedMediaPlayerAdapter;
       

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		this.mediaPlayerFactory = new MediaPlayerFactory("-vvv");
		this.embeddedMediaPlayer = mediaPlayerFactory.mediaPlayers().newEmbeddedMediaPlayer();
		
		
		
		this.embeddedMediaPlayerAdapter = new MediaPlayerEventAdapter() {

            
            @Override
            public void muted(MediaPlayer mediaPlayerObj, boolean muted) {
            	System.out.println("Muted event called ." + muted);
//            	mediaPlayerObj.audio().setMute(muted);
            	
            }
            
            
            @Override
            public void volumeChanged(MediaPlayer mediaPlayerObj, float volume) {
            	System.out.println("volume event called.");
//            	mediaPlayerObj.audio().setVolume(0);
            }
      
            
        };
    
		
		embeddedMediaPlayer.events().addMediaPlayerEventListener(embeddedMediaPlayerAdapter);
		
	}
 
    
	
	@FXML
	private void playButtonAction(ActionEvent event) {

        MediaApi mediaApi =  this.embeddedMediaPlayer.media();
        String sourceOfMedia = "dshow://" ;
	    
	    String cameraDevice = "Logitech Webcam C930e";
	    String microfonDevice = "Mikrofon (2- Logitech Webcam C930e)";
	   
	    String[] options = { 	
	    						
	    						":dshow-vdev=" + cameraDevice,    
	    						":dshow-adev=" + microfonDevice,  
	    						":sout=#transcode{vcodec=h264,fps=24,vb=750,scale=Auto,width=640,height=360,acodec=mp4a,ab=128,channels=2,samplerate=44100,threads=8,scodec=none}"
	    						+ ":duplicate{"
	    						+ "dst=standard{access=udp,mux=ts,dst=172.26.15.107:5555},"
	    						+ "dst=display"
	    						+ "}"
	    						
	    						};
	  	    
		Boolean prepared = mediaApi.prepare(sourceOfMedia, options);
		System.out.println("Is prepared " + prepared);
		

		embeddedMediaPlayer.controls().play();
		Boolean isPlaying  = this.embeddedMediaPlayer.status().isPlaying();
		
		System.out.println("Is audio playing  " + isPlaying);	
	    System.out.println(Arrays.toString(options) );
		
		
	}
    
    
	
	@FXML
	private void muteButtonAction(ActionEvent event) {
		try {
			
			AudioApi audioApi = this.embeddedMediaPlayer.audio();
			audioApi.setMute(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
    

	
	
	@FXML
	private void unmuteButtonAction(ActionEvent event) {
		try {
			
			AudioApi audioApi = this.embeddedMediaPlayer.audio();
			audioApi.setMute(false);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
