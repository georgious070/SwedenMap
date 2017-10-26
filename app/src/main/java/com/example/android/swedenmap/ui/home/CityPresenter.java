package com.example.android.swedenmap.ui.home;

import com.arellomobile.mvp.InjectViewState;
import com.example.android.swedenmap.App;
import com.example.android.swedenmap.business.interactor.CityInteractor;
import com.example.android.swedenmap.ui.base.BasePresenter;

import javax.inject.Inject;

@InjectViewState
public class CityPresenter extends BasePresenter<CityView> {

    @Inject
    CityInteractor cityInteractor;

    public CityPresenter() {
        App.getApp().getAppComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().showData(cityInteractor.getData());
    }
}
