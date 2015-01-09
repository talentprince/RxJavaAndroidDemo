package org.weyoung.rxjavatest.model;

import org.weyoung.rxjavatest.MainActivity;
import org.weyoung.rxjavatest.net.WeatherDataFetcher;

import dagger.Module;
import dagger.Provides;

@Module(
    injects = MainActivity.class,
    library = true
)
public class InjectModule {
    @Provides
    WeatherDataFetcher provideWeatherDataFetcher() {
        return new WeatherDataFetcher();
    }
}
