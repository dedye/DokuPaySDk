package com.doku.android.sdk.ui.resultpage;

import com.nudi.bkn.sapk.rx.SchedulerProvider;
import com.nudi.bkn.sapk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class ResultPagePresenter<V extends ResultPageMvpView, I extends ResultPageMvpInteractor> extends BasePresenter<V, I> implements ResultPageMvpPresenter<V, I> {

    @Inject
    public ResultPagePresenter(I mvpInteractor, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(mvpInteractor, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        decideNextActivity();
    }

    private void decideNextActivity() {
        getMvpView().openLoginActivity();
    }
}
