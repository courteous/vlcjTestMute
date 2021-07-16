/**
 * 
 */
package org.helper;




import uk.co.caprica.vlcj.media.MediaRef;
import uk.co.caprica.vlcj.media.TrackType;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventListener;


public class MediaPlayerEventAdapterHelper implements MediaPlayerEventListener {

	
	@Override
	public void muted(MediaPlayer mediaPlayerObj, boolean muted) {
		System.out.println("embeddedMediaPlayer mute event called ");
		mediaPlayerObj.audio().setMute(muted);


	}

	@Override
	public void volumeChanged(MediaPlayer mediaPlayerObj, float delta) {
		System.out.println("embeddedMediaPlayer volumeChanged event called delta." + delta);
		
	}

	@Override
	public void finished(MediaPlayer mediaPlayerObj) {
		System.out.printf("finished(mediaPlayer=%s%n", mediaPlayerObj);

	}

	

    @Override
    public void mediaChanged(MediaPlayer mediaPlayer, MediaRef media) {
    }

    @Override
    public void opening(MediaPlayer mediaPlayer) {
    }

    @Override
    public void buffering(MediaPlayer mediaPlayer, float newCache) {
    }

    @Override
    public void playing(MediaPlayer mediaPlayer) {
    }

    @Override
    public void paused(MediaPlayer mediaPlayer) {
    }

    @Override
    public void stopped(MediaPlayer mediaPlayer) {
    }

    @Override
    public void forward(MediaPlayer mediaPlayer) {
    }

    @Override
    public void backward(MediaPlayer mediaPlayer) {
    }


    @Override
    public void timeChanged(MediaPlayer mediaPlayer, long newTime) {
    }

    @Override
    public void positionChanged(MediaPlayer mediaPlayer, float newPosition) {
    }

    @Override
    public void seekableChanged(MediaPlayer mediaPlayer, int newSeekable) {
    }

    @Override
    public void pausableChanged(MediaPlayer mediaPlayer, int newPausable) {
    }



    @Override
    public void snapshotTaken(MediaPlayer mediaPlayer, String filename) {
    }

    @Override
    public void lengthChanged(MediaPlayer mediaPlayer, long newLength) {
    }

    @Override
    public void videoOutput(MediaPlayer mediaPlayer, int newCount) {
    }

    @Override
    public void scrambledChanged(MediaPlayer mediaPlayer, int newScrambled) {
    }


    
    
    
    @Override
    public void corked(MediaPlayer mediaPlayer, boolean corked) {
    }



    @Override
    public void audioDeviceChanged(MediaPlayer mediaPlayer, String audioDevice) {
    }

    @Override
    public void chapterChanged(MediaPlayer mediaPlayer, int newChapter) {
    }

    @Override
    public void error(MediaPlayer mediaPlayer) {
    }

    @Override
    public void mediaPlayerReady(MediaPlayer mediaPlayer) {
    }

    
    
    
    
    
    
    
	@Override
	public void titleChanged(MediaPlayer mediaPlayer, int newTitle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elementaryStreamAdded(MediaPlayer mediaPlayer, TrackType type, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elementaryStreamDeleted(MediaPlayer mediaPlayer, TrackType type, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elementaryStreamSelected(MediaPlayer mediaPlayer, TrackType type, int id) {
		// TODO Auto-generated method stub
		
	}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
	

