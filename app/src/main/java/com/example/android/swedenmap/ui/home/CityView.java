package com.example.android.swedenmap.ui.home;

import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.android.swedenmap.ui.base.BaseView;

import java.util.List;

@StateStrategyType(SingleStateStrategy.class)
public interface CityView extends BaseView {

    void showData(List<String> cityNames);
}
