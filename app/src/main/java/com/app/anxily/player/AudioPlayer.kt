package com.app.anxily.player

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource


class AudioPlayer {
    lateinit var mcontext: Context
    val mediaplayerlist = ArrayList<MediaPlayer>()
    lateinit var player: ExoPlayer
    fun initialise( context: Context) {
        this.mcontext = context
        player = ExoPlayer.Builder(context).build()
        load("")

    }


    fun play() {
        player.setPlayWhenReady(true)

    }

    fun load(musicUrl: String) {
        // Load music from network
        // Create a data source factory.
        // Create a data source factory.
        val dataSourceFactory: DataSource.Factory = DefaultHttpDataSource.Factory()
// Create a progressive media source pointing to a stream uri.
// Create a progressive media source pointing to a stream uri.
        val mediaSource: MediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(MediaItem.fromUri(Uri.parse(musicUrl)))

        player.setMediaSource(mediaSource)
        player.prepare()


    }

    fun pause() {
        player.setPlayWhenReady(false)
    }

    fun release() {

        player.release()
    }

}