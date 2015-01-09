package org.weyoung.rxjavatest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import org.weyoung.rxjavatest.data.Weather;
import org.weyoung.rxjavatest.data.WeatherData;
import org.weyoung.rxjavatest.model.Injection;
import org.weyoung.rxjavatest.net.WeatherDataFetcher;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import rx.Observable;
import rx.android.widget.OnTextChangeEvent;
import rx.android.widget.WidgetObservable;
import rx.functions.Action1;
import rx.functions.Func1;


public class MainActivity extends ActionBarActivity {

    @Inject
    WeatherDataFetcher weatherDataFetcher;
    @InjectView(R.id.query)
    EditText query;
    @InjectView(R.id.result)
    TextView result;

    Observable<String> queryObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Injection)getApplication()).inject(this);
        ButterKnife.inject(this);

        initQueryObservable();

        weatherDataFetcher.getWeather(queryObservable).subscribe(new Action1<Weather>() {
            @Override
            public void call(Weather weather) {
                dealwithResult(weather);
            }
        });

    }

    private void initQueryObservable() {
        queryObservable =  WidgetObservable.text(query).filter(new Func1<OnTextChangeEvent, Boolean>() {
                @Override
                public Boolean call(OnTextChangeEvent onTextChangeEvent) {
                    String query = onTextChangeEvent.text().toString();
                    if(TextUtils.isEmpty(query)) {
                        result.setText("");
                    }
                    return !TextUtils.isEmpty(query) && query.length() >= 2;
                }
            }).map(new Func1<OnTextChangeEvent, String>() {
            @Override
            public String call(OnTextChangeEvent onTextChangeEvent) {
                return onTextChangeEvent.text().toString();
            }
        }).debounce(500, TimeUnit.MILLISECONDS);
    }

    private void dealwithResult(Weather weather) {
        if(weather.getStatus().equals("success")) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(weather.getDate() + "\n");
            stringBuffer.append("PM2.5: " + weather.getResults().get(0).getPm25() + "\n");
            List<WeatherData> weatherData = weather.getResults().get(0).getWeatherData();
            stringBuffer.append("天气: " + "\n");
            for(WeatherData data : weatherData) {
                stringBuffer.append(data.getDate() + "\n");
                stringBuffer.append(data.getTemperature() + "\n");
                stringBuffer.append(data.getWeather() + "\n");
                stringBuffer.append(data.getWind() + "\n");
            }
            result.setText(stringBuffer);
        }else {
            result.setText("没有信息");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
