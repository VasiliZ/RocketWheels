package com.github.vasiliz.rocketswheel.userAuth.view;

import com.github.vasiliz.rokets.RocketView;

public interface WebClientView extends RocketView {

    void showProgress();
    void hideProgress();
    void saveToken(final String pToken);

}
