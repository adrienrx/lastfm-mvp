package com.application.lastfm_lloyds.search;

import com.application.lastfm_lloyds.data.model.LightSearchResult;
import com.application.lastfm_lloyds.base.schedulers.BaseSchedulerProvider;
import com.application.lastfm_lloyds.base.schedulers.ImmediateSchedulerProvider;
import com.application.lastfm_lloyds.data.repo.LFMRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Flowable;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SearchPresenterTest {

    public static final String ITEM_MBID = "31623cce-9717-4513-9d83-1b5d04e44f9b";
    private static final String DEFAULT_SEARCH_VALUE = "albumname";
    public static final int LIMIT = 10;
    public static final String ITEM_HEAD = "Album Head";
    public static final String ITEM_TYPE = "Album";
    public static final String ITEM_IMAGE_URL = "http://www.host.com/image.png";

    private SearchPresenter presenter;

    @Mock
    private LFMRepository mockLfmRepository;

    @Mock
    private SearchContract.View mockView;

    @Mock
    private List<LightSearchResult> mockLightSearchResult;

    private BaseSchedulerProvider baseSchedulerProvider;

    @Before
    public void setupSearchPresenterTest() {
        MockitoAnnotations.initMocks(this);

        baseSchedulerProvider = new ImmediateSchedulerProvider();

        presenter = new SearchPresenter(mockLfmRepository, baseSchedulerProvider);
        presenter.takeView(mockView);

    }

    @Test
    public void shouldPerformCombinedSearchAndSucceed() {
        when(mockLfmRepository.combinedSearch(DEFAULT_SEARCH_VALUE, LIMIT)).thenReturn(Flowable.just(mockLightSearchResult));

        presenter.search(DEFAULT_SEARCH_VALUE);

        verify(mockLfmRepository, times(1)).combinedSearch(DEFAULT_SEARCH_VALUE, LIMIT);
        verify(mockView, times(1)).refreshResults(mockLightSearchResult);
        verify(mockView, times(0)).showError();
    }

    @Test
    public void shouldPerformCombinedSearchAndFail() {
        when(mockLfmRepository.combinedSearch(DEFAULT_SEARCH_VALUE, LIMIT)).thenReturn(Flowable.error(new Exception()));

        presenter.search(DEFAULT_SEARCH_VALUE);

        verify(mockLfmRepository, times(1)).combinedSearch(DEFAULT_SEARCH_VALUE, LIMIT);
        verify(mockView, times(0)).refreshResults(mockLightSearchResult);
        verify(mockView, times(1)).showError();
    }

    @Test
    public void shouldShowDetailViewOnClick() {
        final LightSearchResult item = new LightSearchResult(ITEM_HEAD,
                ITEM_TYPE,
                ITEM_IMAGE_URL,
                ITEM_MBID);
        final List<LightSearchResult> results = Arrays.asList(item);
        presenter.setLocalLightSearchResults(results);

        presenter.onSearchItemClicked(0);

        verify(mockView, times(1)).showDetailView(ITEM_MBID, ITEM_TYPE);
    }

    @Test
    public void shouldNotShowDetailViewOnClick() {
        final LightSearchResult item = new LightSearchResult(ITEM_HEAD,
                ITEM_TYPE,
                ITEM_IMAGE_URL,
                ITEM_MBID);
        final List<LightSearchResult> results = Arrays.asList(item);

        presenter.onSearchItemClicked(0);

        verify(mockView, times(0)).showDetailView(ITEM_MBID, ITEM_TYPE);
    }

    @Test
    public void dropView() {
    }

    @Test
    public void search() {
    }

    @Test
    public void onSearchItemClicked() {
    }
}