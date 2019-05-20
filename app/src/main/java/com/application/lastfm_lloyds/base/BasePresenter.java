package com.application.lastfm_lloyds.base;

public interface BasePresenter<T> {

    void takeView(final T View);

    void dropView();
}
