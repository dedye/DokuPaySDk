package com.doku.android.sdk.di.component;

import com.doku.android.sdk.di.PerActivity;
import com.doku.android.sdk.di.module.ActivityModule;
import dagger.Component;

/**
 * Created by dedyeirawan on 21,May,2020
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {

}