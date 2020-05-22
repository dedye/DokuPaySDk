package com.doku.android.sdk.di.module;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.doku.android.sdk.di.ActivityContext;
import com.doku.android.sdk.di.PerActivity;
import com.doku.android.sdk.rx.AppSchedulerProvider;
import com.doku.android.sdk.rx.SchedulerProvider;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by dedyeirawan on 21,May,2020
 */
@Module
public class ActivityModule {

    private AppCompatActivity appCompatActivity;
    public ActivityModule(AppCompatActivity appCompatActivity) {this.appCompatActivity = appCompatActivity;}

    @Provides
    @ActivityContext
    Context provideContext() {return appCompatActivity;}

    @Provides
    AppCompatActivity provideActivity() { return appCompatActivity;}

    @Provides
    CompositeDisposable provideCompositeDisposable() { return new CompositeDisposable();}

    @Provides
    SchedulerProvider provideSchedulerProvider() {return new AppSchedulerProvider();}
}
