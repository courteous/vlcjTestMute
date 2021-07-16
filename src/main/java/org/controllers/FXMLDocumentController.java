package org.controllers;



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventListener;
import uk.co.caprica.vlcj.player.base.events.MediaPlayerEvent;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;





final class MediaPlayerMutedEvent extends MediaPlayerEvent {

    MediaPlayerMutedEvent(MediaPlayer mediaPlayer) {
        super(mediaPlayer);
    }

    @Override
    public void notify(MediaPlayerEventListener listener) {
        listener.muted(mediaPlayer, true);
    }

}



final class MediaPlayerUnMutedEvent extends MediaPlayerEvent {

	MediaPlayerUnMutedEvent(MediaPlayer mediaPlayer) {
        super(mediaPlayer);
    }

    @Override
    public void notify(MediaPlayerEventListener listener) {
        listener.muted(mediaPlayer, false);
    }

}


public class FXMLDocumentController implements Initializable {

	
	@FXML
	private Button buttonPlayID;
    
	@FXML
	private Button buttonMuteId;
    
	
	
    
    
    private EmbeddedMediaPlayer embeddedMediaPlayer;
    private MediaPlayerEventAdapter embeddedMediaPlayerAdapter;
       

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		
	}
 
    
	
	@FXML
	private void playButtonAction(ActionEvent event) {

		
		System.out.println("Start playing some stuff ..");
		
		
		String file = "file:///C:/Users/courteous/Downloads/sound.wav";
		
		MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory("-vvv");
		EmbeddedMediaPlayer embeddedMediaPlayer = mediaPlayerFactory.mediaPlayers().newEmbeddedMediaPlayer();
		
		uk.co.caprica.vlcj.player.base.MediaApi mediaApi = embeddedMediaPlayer.media();
		

		this.embeddedMediaPlayerAdapter = new MediaPlayerEventAdapter() {

            
            @Override
            public void muted(MediaPlayer mediaPlayerObj, boolean muted) {
            	System.out.println("Muted event called ." + muted);
            	mediaPlayerObj.audio().setMute(muted);
            	
            }
            
            
            @Override
            public void volumeChanged(MediaPlayer mediaPlayerObj, float volume) {
            	System.out.println("volume event called.");
//            	mediaPlayerObj.audio().setVolume(0);
            }
      
            
        };
    
		
		embeddedMediaPlayer.events().addMediaPlayerEventListener(embeddedMediaPlayerAdapter);

		
		
		
		Boolean prepared = mediaApi.prepare(file);
		System.out.println("Is correctly prepared " + prepared);
		Boolean isPlaying  = mediaApi.play(file);
		System.out.println("Is playing  " + isPlaying);
		
		if (isPlaying) {
			
			uk.co.caprica.vlcj.player.base.EventApi eventApi = embeddedMediaPlayer.events();
			
		}
		
		boolean isPlayingClip = embeddedMediaPlayer.status().isPlaying();
		if (isPlayingClip) {

			
			


			
		}

		
		
        System.out.println("end");
		
	}
    
    
	
	@FXML
	private void muteButtonAction(ActionEvent event) {
		try {
		
			MediaPlayerMutedEvent mutedEvent = new MediaPlayerMutedEvent(embeddedMediaPlayer);
			mutedEvent.notify(this.embeddedMediaPlayerAdapter);
			Thread.sleep(3000);
			MediaPlayerUnMutedEvent unMutedEvent = new MediaPlayerUnMutedEvent(embeddedMediaPlayer);
			unMutedEvent.notify(this.embeddedMediaPlayerAdapter);

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
    

}
