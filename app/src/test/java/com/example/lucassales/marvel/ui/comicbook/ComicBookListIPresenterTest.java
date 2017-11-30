package com.example.lucassales.marvel.ui.comicbook;

import com.example.lucassales.marvel.data.DataManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Maybe;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lucassales on 30/11/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class ComicBookListIPresenterTest {


    @Mock
    ComicBookListIView mockView;
    @Mock
    DataManager mockDataManager;

    private ComicBookListPresenter<ComicBookListIView> presenter;
    private TestScheduler testScheduler;

    @Before
    public void setUp() throws Exception {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        testScheduler = new TestScheduler();
        presenter = new ComicBookListPresenter<>(
                mockDataManager,
                compositeDisposable);
        presenter.onAttach(mockView);

        RxAndroidPlugins.initMainThreadScheduler(new Callable<Scheduler>() {
            @Override
            public Scheduler call() throws Exception {
                return Schedulers.trampoline();
            }
        });

        RxAndroidPlugins.setInitMainThreadSchedulerHandler(new Function<Callable<Scheduler>, Scheduler>() {
            @Override
            public Scheduler apply(Callable<Scheduler> schedulerCallable) throws Exception {
                return Schedulers.trampoline();
            }
        });

        RxJavaPlugins.initIoScheduler(new Callable<Scheduler>() {
            @Override
            public Scheduler call() throws Exception {
                return Schedulers.trampoline();
            }
        });
    }

    @Test
    public void testCalculate() {

        List<Float> list = new ArrayList<>();
        list.add(1f);
        list.add(1f);
        list.add(1f);
        list.add(1f);
        list.add(1f);
        list.add(10f);

        when(mockDataManager.getPricesDB())
                .thenReturn(Maybe.just(list));
        presenter.calculateWithBudget(10);
        verify(mockView).onBudgetCalculated(5);
    }

    @After
    public void stop() throws Exception {
        presenter.onDetach();
        RxJavaPlugins.reset();
        RxAndroidPlugins.reset();
    }

}