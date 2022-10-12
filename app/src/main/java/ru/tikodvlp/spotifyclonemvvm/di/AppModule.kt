package ru.tikodvlp.spotifyclonemvvm.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.tikodvlp.spotifyclonemvvm.R
import ru.tikodvlp.spotifyclonemvvm.adapters.SwipeSongAdapter
import ru.tikodvlp.spotifyclonemvvm.exoplayer.MusicServiceConnection
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMusicServiceConnection(
        @ApplicationContext context: Context
    ) = MusicServiceConnection(context)

    @Singleton
    @Provides
    fun provideSwipeSongAdapter() = SwipeSongAdapter()

    @Singleton
    @Provides
    fun provideGlideInstance(
        @ApplicationContext context: Context
    ) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions()
            .placeholder(R.drawable.ic_launcher_background) // если картинка не загрузилась отображать данный image
            .error(R.drawable.ic_launcher_background)       // если случилась ошибка отображать данный image
            .diskCacheStrategy(DiskCacheStrategy.DATA)     // чтобы картинки кешировались с Glide
    )
}