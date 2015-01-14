package org.weyoung.rxjavatest.net;

import org.weyoung.rxjavatest.data.Weather;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class WeatherDataFetcher {

    public Observable<Weather> getWeather(final Observable<String> location) {
        return location.flatMap(new Func1<String, Observable<Weather>>() {
            @Override
            public Observable<Weather> call(final String s) {

                return Observable.create(new Observable.OnSubscribe<Weather>() {
                    @Override
                    public void call(Subscriber<? super Weather> subscriber) {
                        try {
                            RestAdapter restAdapter = new RestAdapter.Builder()
                                    .setEndpoint("http://api.map.baidu.com/telematics/v3")
                                    .setRequestInterceptor(new RequestInterceptor() {
                                        @Override
                                        public void intercept(RequestFacade request) {
                                            request.addQueryParam("output", "json");
                                            request.addQueryParam("ak", "A72e372de05e63c8740b2622d0ed8ab1");
                                        }
                                    }).build();
                            subscriber.onNext(restAdapter.create(WeatherRequestAPI.class).getWeather(s));
                        }catch (Exception e) {
                            subscriber.onError(e);
                        }
                        }
                    }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry();}
            });
    }
}
