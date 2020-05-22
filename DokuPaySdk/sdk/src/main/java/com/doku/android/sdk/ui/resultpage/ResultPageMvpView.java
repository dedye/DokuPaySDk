package com.doku.android.sdk.ui.resultpage;

import com.nudi.bkn.sapk.ui.base.MvpView;

public interface ResultPageMvpView extends MvpView {
    void openLoginActivity();
    void errorMessage(String titileError, String errorMessage);
}
