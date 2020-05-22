package com.doku.android.sdk.ui.resultpage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nudi.bkn.sapk.R;
import com.nudi.bkn.sapk.adapter.RecycleViewAkunTentangAdapter;
import com.nudi.bkn.sapk.model.AkunResponse;
import com.nudi.bkn.sapk.ui.base.BaseActivity;
import com.nudi.bkn.sapk.ui.login.LoginActivity;
import com.nudi.bkn.sapk.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultPageActivity extends BaseActivity implements ResultPageMvpView {

    @Inject
    ResultPageMvpPresenter<ResultPageMvpView, ResultPageMvpInteractor> mPresenter;

    @BindView(R.id.recyclerview_tentang_info)
    RecyclerView recyclerviewTentangInfo;

    @BindView(R.id.textview_title_mysapk)
    TextView textviewTitleMysapk;

    private RecycleViewAkunTentangAdapter mAdapter2;

    private List<AkunResponse> akunLainnyaList = new ArrayList<>();

    @BindView(R.id.imageview_tentang_back)
    ImageView imageviewTentangBack;


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, ResultPageActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(ResultPageActivity.this);
        setUp();
    }

    @Override
    protected void setUp() {
        String str = "<b>MySAPK</b> dikembangkan oleh tim Pranata Komputer Kedeputian SINKA Badan Kepegawaian Negara";
        textviewTitleMysapk.setText(Html.fromHtml(str));

        imageviewTentangBack.setOnClickListener(v -> finish());
        mAdapter2 = new RecycleViewAkunTentangAdapter(akunLainnyaList, ResultPageActivity.this);
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(ResultPageActivity.this);
        recyclerviewTentangInfo.setLayoutManager(mLayoutManager2);
        recyclerviewTentangInfo.setItemAnimator(new DefaultItemAnimator());
        recyclerviewTentangInfo.setAdapter(mAdapter2);

        prepareTentangData();
    }

    private void prepareTentangData() {
        AkunResponse item = new AkunResponse("Gedung 2 Lantai 12", R.mipmap.ico_address);
        akunLainnyaList.add(item);

        item = new AkunResponse("mysapk@bkn.go.id", R.mipmap.ico_email);
        akunLainnyaList.add(item);

        item = new AkunResponse("satgasmysapk.bkn@gmail.com", R.mipmap.ico_email);
        akunLainnyaList.add(item);

        mAdapter2.notifyDataSetChanged();
    }

    @Override
    public void openLoginActivity() {}

    @Override
    public void errorMessage(String titileError, String errorMessage) {
        if (titileError.equals("401")){
            CommonUtils.showDWAlertDialog(this,
                    "Session Expired",
                    "Logout", "OK", dialogClickListenerdash1);
        }else{
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    DialogInterface.OnClickListener dialogClickListenerdash1 = (dialog, which) -> {
        switch (which) {
            case DialogInterface.BUTTON_POSITIVE:
                mPresenter.getInteractor().updateUserInfo("","",
                        "","",
                        "","",
                        "","",
                        "","",
                        "","");
                mPresenter.getInteractor().updateReminderLogin("");
                mPresenter.getInteractor().doFCM("","");

                finish();
                Intent intent = LoginActivity.getStartIntent(this);
                startActivity(intent);
                break;
        }
    };

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onFragmentAttached() {}

    @Override
    public void onFragmentDetached(String tag) {}

    @Override
    public void onBackPressed() {
        finish();
    }
}
