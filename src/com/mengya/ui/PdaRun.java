package com.mengya.ui;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.*;
import com.common.utils.date.DateUtil;
import com.gzcwt.entity.pda.dao.HandbookRunDao;
import com.gzcwt.entity.pda.entity.HandbookRun;
import com.mengya.gzcwt.R;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 4/2/13
 * Time: 11:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class PdaRun {

    private Activity ctx;
    private View layout;

    //about station 's pad_run
    private EditText et_flag;
    private EditText et_station_name;
    private EditText et_speed_limit;
    private EditText et_part_interval;
    private EditText et_car_count;
    private EditText et_station_driver;
    private EditText et_car_tonnage;
    private EditText et_length_count;
    private Button btn_part_time;
    private Button btn_off_time;
    private Button btn_charge_wind_time;
    private Button btn_discharge_wind_time;

    //about pda_run list
    private TextView tv_flag;
    private TextView tv_station_name;
    private TextView tv_speed_limit;
    private TextView tv_part_interval;
    private TextView tv_car_count;
    private TextView tv_station_driver;
    private TextView tv_car_tonnage;
    private TextView tv_length_count;
    private TextView tv_part_time;
    private TextView tv_off_time;

    //about pda_run event
    private long chargeTime = 0;
    private long dischargeTime = 0;
    private boolean ifCharge = false;
    private boolean ifDischarge = false;
    private boolean ifChargeStart = false;
    private boolean ifDischargeStart = false;
    private Timer chargeTimer = new Timer();
    private Timer dischargeTimer = new Timer();
    private TimePickerDialog timePickerDialog;

    private boolean offTimeflag = false;
    private boolean partTimeflag = false;
    private Date date = new Date();

    private PdaRunClickListener pdaRunClickListener;

    PdaRun(Activity ctx, View layout) {
        this.ctx = ctx;
        this.layout = layout;
        initPdaRunView();
    }

    private void savePdaRun() {
        HandbookRun handbookRun = new HandbookRun();
        handbookRun.setCarCount(Integer.parseInt(et_car_count.getText().toString()));
        handbookRun.setChargeWind(chargeTime);
        handbookRun.setDischargeWind(dischargeTime);
        handbookRun.setDriver(et_station_driver.getText().toString());
        handbookRun.setFlag(Integer.parseInt(et_flag.getText().toString()));
        handbookRun.setLength(Integer.parseInt(et_length_count.getText().toString()));
        handbookRun.setOffTime(btn_off_time.getText().toString());
        handbookRun.setPartTime(btn_part_time.getText().toString());
        handbookRun.setPartInterval(et_part_interval.getText().toString());
        handbookRun.setSpeedLimit(Float.parseFloat(et_speed_limit.getText().toString()));
        handbookRun.setTonnage(Integer.parseInt(et_car_tonnage.getText().toString()));
        handbookRun.setStation(et_station_name.getText().toString());
        HandbookRunDao.getInstance(this.ctx).insert(handbookRun);
        System.out.println("【【【handbookrunList: " + HandbookRunDao.getInstance(this.ctx).getHandbookRuns());
    }

    class PdaRunClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //To change body of implemented methods use File | Settings | File Templates.
            switch (v.getId()) {
                case R.id.btn_charge_wind_time:
                    clickCharge();
                    break;
                case R.id.btn_discharge_wind_time:
                    clickDischarge();
                    break;
                case R.id.btn_part_time:
                    partTimeflag = !partTimeflag;
                    getTimePickerDialog().show();
                    break;
                case R.id.btn_off_time:
                    offTimeflag = !offTimeflag;
                    getTimePickerDialog().show();
                    break;
                default:
                    break;
            }
        }
    }

    private void initPdaRunView() {
        //about pda_info
        et_flag = (EditText) layout.findViewById(R.id.et_flag);
        et_station_name = (EditText) layout.findViewById(R.id.et_station_name);
        et_speed_limit = (EditText) layout.findViewById(R.id.et_speed_limit);
        et_part_interval = (EditText) layout.findViewById(R.id.et_part_interval);
        et_car_count = (EditText) layout.findViewById(R.id.et_car_count);
        et_station_driver = (EditText) layout.findViewById(R.id.et_station_driver);
        et_car_tonnage = (EditText) layout.findViewById(R.id.et_car_tonnage);
        et_length_count = (EditText) layout.findViewById(R.id.et_length_count);

        btn_part_time = (Button) layout.findViewById(R.id.btn_part_time);
        btn_off_time = (Button) layout.findViewById(R.id.btn_off_time);
        btn_charge_wind_time = (Button) layout.findViewById(R.id.btn_charge_wind_time);
        btn_discharge_wind_time = (Button) layout.findViewById(R.id.btn_discharge_wind_time);

        pdaRunClickListener = new PdaRunClickListener();
        btn_part_time.setOnClickListener(pdaRunClickListener);
        btn_off_time.setOnClickListener(pdaRunClickListener);
        btn_charge_wind_time.setOnClickListener(pdaRunClickListener);
        btn_discharge_wind_time.setOnClickListener(pdaRunClickListener);

    }

    private void initPdaRunList(){
        private TextView tv_flag;
        private TextView tv_station_name;
        private TextView tv_speed_limit;
        private TextView tv_part_interval;
        private TextView tv_car_count;
        private TextView tv_station_driver;
        private TextView tv_car_tonnage;
        private TextView tv_length_count;
        private TextView tv_part_time;
        private TextView tv_off_time;
    }

    private void setChargeTime(long time) {
        btn_charge_wind_time.setText(DateUtil.formatMillis(time));
    }

    private void setDischargeTime(long time) {
        btn_discharge_wind_time.setText(DateUtil.formatMillis(time));
    }

    private Runnable setChargeTimeRunable = new Runnable() {
        @Override
        public void run() {
            //To change body of implemented methods use File | Settings | File Templates.
            setChargeTime(chargeTime);
        }
    };
    private Runnable setDischargeTimeRunable = new Runnable() {
        @Override
        public void run() {
            //To change body of implemented methods use File | Settings | File Templates.
            setDischargeTime(dischargeTime);
        }
    };
    private TimerTask chargeTask = new TimerTask() {
        @Override
        public void run() {
            //To change body of implemented methods use File | Settings | File Templates.
            if (ifCharge) {
                chargeTime++;
                ctx.runOnUiThread(setChargeTimeRunable);
            }
        }
    };

    private TimerTask dischargeTask = new TimerTask() {
        @Override
        public void run() {
            //To change body of implemented methods use File | Settings | File Templates.
            if (ifDischarge) {
                dischargeTime++;
                ctx.runOnUiThread(setDischargeTimeRunable);
            }
        }
    };

    private void clickCharge() {
        ifCharge = !ifCharge;
        if (!ifChargeStart) chargeTimer.schedule(chargeTask, 0, 1);
        if (ifCharge) {
            btn_discharge_wind_time.setEnabled(false);
        } else {
            btn_discharge_wind_time.setEnabled(true);
        }
        ifChargeStart = true;
    }

    private void clickDischarge() {
        ifDischarge = !ifDischarge;
        if (!ifDischargeStart) dischargeTimer.schedule(dischargeTask, 0, 1);
        if (ifDischarge) {
            btn_charge_wind_time.setEnabled(false);
        } else {
            btn_charge_wind_time.setEnabled(true);
        }
        ifDischargeStart = true;
    }

    private TimePickerDialog getTimePickerDialog() {
        if (timePickerDialog == null) {
            timePickerDialog = new TimePickerDialog(this.ctx, 0,
                    new TimePickerDialog.OnTimeSetListener() {

                        public void onTimeSet(TimePicker arg0, int arg1,
                                              int arg2) {
                            // TODO Auto-generated method stub
                            if (partTimeflag) {
                                partTimeflag = !partTimeflag;
                                date.setTime(System.currentTimeMillis());
                                btn_part_time.setText(DateUtil.dateToStr(date, "yyyy-MM-dd") + arg1 + ":" + arg2);
                            }
                            if (offTimeflag) {
                                offTimeflag = !offTimeflag;
                                date.setTime(System.currentTimeMillis());
                                btn_off_time.setText(DateUtil.dateToStr(date, "yyyy-MM-dd")+arg1 + ":" + arg2);
                            }
                        }
                    }, Calendar.HOUR, Calendar.MINUTE, false);
        }
        return timePickerDialog;
    }


}
