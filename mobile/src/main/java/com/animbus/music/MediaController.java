package com.animbus.music;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.animbus.music.data.dataModels.Song;

import java.util.List;

public class MediaController {
    MusicService musicService;

    public MediaController(Context context) {
        musicService = new MusicService(context);
        /*context.startService();*/
    }

    //This is where the song is set and the playback begins
    public void startPlayback(Song song) {
        musicService.setCurrentSongPos(song);
        musicService.playSong(song);
    }

    public void startPlayback(List<Song> data, int position) {
        musicService.setCurrentSongPos(position);
        musicService.playSong(data, position);
    }

    //The Controls
    public void pausePlayback() {
        musicService.pause();
    }

    public void resumePlayback() {
        musicService.resume();
    }

    public void togglePlayback(){
        musicService.togglePlayback();
    }

    public void playNextSong() {
        musicService.playNext();
    }

    public void playPrevSong() {
        musicService.playPrev();
    }

    //Misc.
    public void setQueue(List<Song> list) {
        musicService.setQueue(list);
    }

    public List<Song> getQueue() {
        return musicService.getQueue();
    }

    public void addToQueue(Song song) {
        musicService.addToQueue(song);
    }

    public void removeFromQueue(int position) {
        musicService.removeFromQueue(position);
    }

    public void setRepeat(Boolean doRepeat) {
        musicService.setRepeat(doRepeat);
    }

    public boolean getShowToolbar(){
        return musicService.getShowQuickToolbar();
    }
}
