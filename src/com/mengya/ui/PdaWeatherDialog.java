package com.mengya.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.mengya.gzcwt.R;


/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 3/30/13
 * Time: 12:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class PdaWeatherDialog {

    Activity ctx;
    AlertDialog.Builder builder;
    AlertDialog dialog;
    private String weather;
    View pda_weather_layout;
    View pda_base_info_layout;
    ImageView img_weather;

    PdaWeatherDialog(Activity ctx) {
        this.ctx = ctx;
    }

    public void showWeatherDialog(ImageView img_weather) {
        // layout
        pda_weather_layout = View.inflate(ctx, R.layout.pda_weather, null);
        this.img_weather = img_weather;
        // 设置具有两行EditText的dialog

        final ImageView img_weather_1 = (ImageView) pda_weather_layout.findViewById(R.id.img_weather_1);
        final ImageView img_weather_2 = (ImageView) pda_weather_layout.findViewById(R.id.img_weather_2);
        final ImageView img_weather_3 = (ImageView) pda_weather_layout.findViewById(R.id.img_weather_3);
        final ImageView img_weather_4 = (ImageView) pda_weather_layout.findViewById(R.id.img_weather_4);
        final ImageView img_weather_5 = (ImageView) pda_weather_layout.findViewById(R.id.img_weather_5);
        final ImageView img_weather_6 = (ImageView) pda_weather_layout.findViewById(R.id.img_weather_6);
        final ImageView img_weather_7 = (ImageView) pda_weather_layout.findViewById(R.id.img_weather_7);
        final ImageView img_weather_8 = (ImageView) pda_weather_layout.findViewById(R.id.img_weather_8);

        WeatherListener weatherListener = new WeatherListener();
        img_weather_1.setOnClickListener(weatherListener);
        img_weather_2.setOnClickListener(weatherListener);
        img_weather_3.setOnClickListener(weatherListener);
        img_weather_4.setOnClickListener(weatherListener);
        img_weather_5.setOnClickListener(weatherListener);
        img_weather_6.setOnClickListener(weatherListener);
        img_weather_7.setOnClickListener(weatherListener);
        img_weather_8.setOnClickListener(weatherListener);

        builder = new AlertDialog.Builder(ctx);
        // dialog
        builder.setTitle("单击选择天气状况");
        builder.setView(pda_weather_layout);
        dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    class WeatherListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //To change body of implemented methods use File | Settings | File Templates.
            switch (v.getId()) {
                case R.id.img_weather_1:
                    img_weather.setImageDrawable(ctx.getResources().getDrawable(R.drawable.weather_1));
                    setWeather("晴");
                    break;
                case R.id.img_weather_2:
                    img_weather.setImageDrawable(ctx.getResources().getDrawable(R.drawable.weather_2));
                    setWeather("多云");
                    break;
                case R.id.img_weather_3:
                    img_weather.setImageDrawable(ctx.getResources().getDrawable(R.drawable.weather_3));
                    setWeather("阴");
                    break;
                case R.id.img_weather_4:
                    img_weather.setImageDrawable(ctx.getResources().getDrawable(R.drawable.weather_4));
                    setWeather("大雨");
                    break;
                case R.id.img_weather_5:
                    img_weather.setImageDrawable(ctx.getResources().getDrawable(R.drawable.weather_5));
                    setWeather("中雨");
                    break;
                case R.id.img_weather_6:
                    img_weather.setImageDrawable(ctx.getResources().getDrawable(R.drawable.weather_6));
                    setWeather("阵雨");
                    break;
                case R.id.img_weather_7:
                    img_weather.setImageDrawable(ctx.getResources().getDrawable(R.drawable.weather_7));
                    setWeather("雷阵雨");
                    break;
                case R.id.img_weather_8:
                    img_weather.setImageDrawable(ctx.getResources().getDrawable(R.drawable.weather_8));
                    setWeather("小雨");
                    break;
                default:
                    break;
            }
        }
    }

    public void setWeather(String option) {
        this.weather = option;
        dialog.dismiss();
    }

    public String getWeather() {
        return weather;
    }

    public void setWeatherImg(String option) {
        if (option.equals("晴"))
            img_weather.setImageDrawable(ctx.getResources().getDrawable(R.drawable.weather_1));
        if (option.equals("多云"))
            img_weather.setImageDrawable(ctx.getResources().getDrawable(R.drawable.weather_2));
        if (option.equals("阴"))
            img_weather.setImageDrawable(ctx.getResources().getDrawable(R.drawable.weather_3));
        if (option.equals("大雨"))
            img_weather.setImageDrawable(ctx.getResources().getDrawable(R.drawable.weather_4));
        if (option.equals("中雨"))
            img_weather.setImageDrawable(ctx.getResources().getDrawable(R.drawable.weather_5));
        if (option.equals("阵雨"))
            img_weather.setImageDrawable(ctx.getResources().getDrawable(R.drawable.weather_6));
        if (option.equals("雷阵雨"))
            img_weather.setImageDrawable(ctx.getResources().getDrawable(R.drawable.weather_7));
        if (option.equals("小雨"))
            img_weather.setImageDrawable(ctx.getResources().getDrawable(R.drawable.weather_8));
    }
}


