package ru.tikodvlp.spotifyclonemvvm.exoplayer

import android.support.v4.media.MediaMetadataCompat
import ru.tikodvlp.spotifyclonemvvm.data.entities.Song

fun MediaMetadataCompat.toSong(): Song? {
    return description?.let {
        Song(
            it.mediaId ?: "",
            it.title.toString(),
            it.subtitle.toString(),
            it.mediaUri.toString(),
            it.iconUri.toString()
        )
    }
}