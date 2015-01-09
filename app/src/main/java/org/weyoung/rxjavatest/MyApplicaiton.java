package org.weyoung.rxjavatest;

import android.app.Application;

import org.weyoung.rxjavatest.model.InjectModule;
import org.weyoung.rxjavatest.model.Injection;

import java.util.Arrays;

import dagger.ObjectGraph;

public class MyApplicaiton extends Application implements Injection {

    private ObjectGraph objectGraph;
    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(Arrays.asList(new InjectModule()).toArray());
    }

    @Override
    public void inject(Object obj) {
        objectGraph.inject(obj);
    }
}
