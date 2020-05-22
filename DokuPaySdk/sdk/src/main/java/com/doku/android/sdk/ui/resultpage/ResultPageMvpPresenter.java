package com.doku.android.sdk.ui.resultpage;

import com.nudi.bkn.sapk.di.PerActivity;
import com.nudi.bkn.sapk.ui.base.MvpPresenter;

@PerActivity
public interface ResultPageMvpPresenter<V extends ResultPageMvpView, I extends ResultPageMvpInteractor> extends MvpPresenter<V, I> {}
