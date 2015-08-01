package com.android.bignerdranc.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by YamadouTraore on 7/22/15.
 */
public class AudioPlayer {

    private int mPlaybackPosition;
    private MediaPlayer mPlayer;

    public void stop() {
        if(mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c) {

        if(mPlayer == null){

            stop();
            mPlayer = MediaPlayer.create(c, R.raw.one_small_step);

            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                public void onCompletion(MediaPlayer mp) {
                    stop();
                }
            });

        }else
            mPlayer.seekTo(mPlaybackPosition);
        mPlayer.start();
    }

    public void pause() {

        mPlayer.pause();
        mPlaybackPosition = mPlayer.getCurrentPosition();
    }
}
