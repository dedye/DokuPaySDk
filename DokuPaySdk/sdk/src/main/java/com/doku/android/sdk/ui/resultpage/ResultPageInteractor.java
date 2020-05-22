package com.doku.android.sdk.ui.resultpage;

import com.nudi.bkn.sapk.network.SapkApiService;
import com.nudi.bkn.sapk.prefs.PreferencesHelper;
import com.nudi.bkn.sapk.ui.base.BaseInteractor;

import javax.inject.Inject;

public class ResultPageInteractor extends BaseInteractor implements ResultPageMvpInteractor {

    @Inject
    public ResultPageInteractor(PreferencesHelper preferencesHelper, SapkApiService SapkApiService) {
        super(preferencesHelper, SapkApiService);
    }
}
