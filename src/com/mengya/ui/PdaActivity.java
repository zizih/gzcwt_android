package com.mengya.ui;

import android.widget.*;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TabHost.OnTabChangeListener;
import com.google.gson.Gson;
import com.gzcwt.entity.pda.dao.HandbookDao;
import com.gzcwt.entity.pda.dao.InitDB;
import com.gzcwt.entity.pda.entity.*;
import com.mengya.adapter.PdaListAdapter;
import com.mengya.gzcwt.R;

import java.util.*;

import com.common.utils.date.DateUtil;
import android.widget.TabHost.TabContentFactory;

public class PdaActivity extends BaseActivity {
    private TabHost tabHost;
    private LayoutInflater inflater;
    private ImageView back;
    private TextView title;
    private Button btn_pda_save;
    private Button btn_pda_finish;

    //about wiget pda_info
    private EditText et_car_num;
    private EditText et_car_type;
    private EditText et_train_num;
    private EditText et_main_driver;
    private EditText et_co_driver;
    private Button btn_start_work;
    private Button btn_off_work;
    private EditText et_student_name;
    private EditText et_other_car_name;
    private EditText et_other_car_type;
    private EditText et_other_car_driver;
    private EditText et_run_note;
    private EditText et_note;

    private RadioGroup radio_control_group;
    private RadioButton radio_master_control;
    private RadioButton radio_follow_control;


    //about pda_info
    private ImageView img_weather_type;
    private PdaWeatherDialog weatherDialog;
    private PdaLineDialog lineDialog;
    private boolean ifStartWorkTimeNotStop = false;
    private boolean ifOffWorkTimeNotStop = false;
    private Timer runTimer = new Timer();
    private Date runDate = new Date();


    //pda_list
    private TextView tv_train_num;
    private TextView tv_driver_name;
    private TextView tv_add_time;
    private List<Handbook> handbookList;

    //about click event
    private PdaClickListener pdaClickListener;
    private PdaRun pdaRun;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pda);
        initTabhost();
        pdaClickListener = new PdaClickListener();
    }


    private void initPdaList(View pda_list) {
        //about pda_list

        ListView lv_pda_list = (ListView) pda_list.findViewById(R.id.lv_pda_list);
        tv_train_num = (TextView) pda_list.findViewById(R.id.tv_list_train_num);
        tv_driver_name = (TextView) pda_list.findViewById(R.id.tv_list_driver_name);
        tv_add_time = (TextView) pda_list.findViewById(R.id.tv_list_add_time);

        handbookList = HandbookDao.getinstance(PdaActivity.this).getHandbooks();
        PdaListAdapter adapter = new PdaListAdapter(PdaActivity.this);
        adapter.setItems(handbookList);
        lv_pda_list.setAdapter(adapter);
        lv_pda_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //To change body of implemented methods use File | Settings | File Templates.
                tabHost.setCurrentTab(1);
                et_car_num.setText(handbookList.get(position).getCar());
                et_car_type.setText(handbookList.get(position).getCarType());
                et_train_num.setText(handbookList.get(position).getTrainNo());
                et_main_driver.setText(handbookList.get(position).getDriver());
                et_co_driver.setText(handbookList.get(position).getCoDriver());
                btn_start_work.setText(handbookList.get(position).getStartWork());
                btn_off_work.setText(handbookList.get(position).getEndWork());
                et_student_name.setText(handbookList.get(position).getStudent());
                et_other_car_name.setText(handbookList.get(position).getOtherCar());
                et_other_car_type.setText(handbookList.get(position).getOtherCarType());
                et_other_car_driver.setText(handbookList.get(position).getOtherCarDriver());
                et_run_note.setText(handbookList.get(position).getPrecaution());
                et_note.setText(handbookList.get(position).getNote());
            }
        });

    }

    private void initPdaInfo(View pda_base_info) {
        et_car_num = (EditText) pda_base_info.findViewById(R.id.et_car_num);
        et_car_type = (EditText) pda_base_info.findViewById(R.id.et_car_type);
        et_train_num = (EditText) pda_base_info.findViewById(R.id.et_train_num);
        et_main_driver = (EditText) pda_base_info.findViewById(R.id.et_main_driver);
        et_co_driver = (EditText) pda_base_info.findViewById(R.id.et_co_driver);
        btn_start_work = (Button) pda_base_info.findViewById(R.id.btn_start_work);
        btn_off_work = (Button) pda_base_info.findViewById(R.id.btn_off_work);
        et_student_name = (EditText) pda_base_info.findViewById(R.id.et_student);
        radio_master_control = (RadioButton) pda_base_info.findViewById(R.id.radio_master_control);
        radio_follow_control = (RadioButton) pda_base_info.findViewById(R.id.radio_follow_control);
        radio_control_group = (RadioGroup) pda_base_info.findViewById(R.id.radio_control_group);
        et_other_car_name = (EditText) pda_base_info.findViewById(R.id.et_other_car_name);
        et_other_car_type = (EditText) pda_base_info.findViewById(R.id.et_other_car_type);
        et_other_car_driver = (EditText) pda_base_info.findViewById(R.id.et_other_car_driver);
        et_run_note = (EditText) pda_base_info.findViewById(R.id.et_run_note);
        et_note = (EditText) pda_base_info.findViewById(R.id.et_note);

        //about weather
        img_weather_type = (ImageView) pda_base_info.findViewById(R.id.img_weather);
        weatherDialog = new PdaWeatherDialog(PdaActivity.this);
        img_weather_type.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //To change body of implemented methods use File | Settings | File Templates.
                weatherDialog.showWeatherDialog(img_weather_type);
            }
        });

        //about part_time& off_time
        btn_start_work.setOnClickListener(pdaClickListener);
        btn_off_work.setOnClickListener(pdaClickListener);
        runTimer.schedule(runTimeTask, 0, 1000);
    }

    private void setStartWorkTime() {
        btn_start_work.setText(DateUtil.dateToStr(runDate, "yyyy-MM-dd HH:mm:ss"));
    }

    private void setOffWorkTime() {
        btn_off_work.setText(DateUtil.dateToStr(runDate, "yyyy-MM-dd HH:mm:ss"));
    }

    Runnable setRunTimeRunable = new Runnable() {
        @Override
        public void run() {
            //To change body of implemented methods use File | Settings | File Templates.
            if (!ifStartWorkTimeNotStop) {
                (PdaActivity.this).setStartWorkTime();
            }
            if (!ifOffWorkTimeNotStop) {
                (PdaActivity.this).setOffWorkTime();
            }
        }
    };
    private TimerTask runTimeTask = new TimerTask() {
        @Override
        public void run() {
            //To change body of implemented methods use File | Settings | File Templates.
            runDate.setTime(System.currentTimeMillis());
            (PdaActivity.this).runOnUiThread(setRunTimeRunable);
        }
    };


    class PdaClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            //To change body of implemented methods use File | Settings | File Templates.
            switch (v.getId()) {
                case R.id.btn_start_work:
                    ifStartWorkTimeNotStop = !ifStartWorkTimeNotStop;
                    break;
                case R.id.btn_off_work:
                    ifOffWorkTimeNotStop = !ifOffWorkTimeNotStop;
                    break;
                default:
                    break;
            }
        }
    }



    private void initTabhost() {
        back = (ImageView) findViewById(R.id.pda_back);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
        title = (TextView) findViewById(R.id.pda_title);
        btn_pda_save = (Button) findViewById(R.id.btn_pda_save);
        btn_pda_finish = (Button) findViewById(R.id.btn_pda_finish);

        tabHost = (TabHost) this.findViewById(R.id.pda_TabHost);
        try {
            tabHost.setup();
            tabHost.addTab(tabHost.newTabSpec("0")
                    .setContent(new TabFactory(this, 0))
                    .setIndicator("手帐列表"));
            tabHost.addTab(tabHost.newTabSpec("1")
                    .setContent(new TabFactory(this, 1))
                    .setIndicator("基本信息"));
            tabHost.addTab(tabHost.newTabSpec("2")
                    .setContent(new TabFactory(this, 2))
                    .setIndicator("运行信息"));
            tabHost.setCurrentTab(0);
            for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
                TextView view = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
                view.setTextColor(Color.WHITE);
                view.setTextSize(25);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
                params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 0); //取消文字底边对齐
                params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE); //设置文字居中对齐
                if (i == 0) {
                    View im = tabHost.getTabWidget().getChildAt(i);
                    im.setBackgroundResource(R.drawable.nav_2);
                } else {
                    View im2 = tabHost.getTabWidget().getChildAt(i);
                    im2.setBackgroundResource(R.drawable.nav_1);
                }
            }
            initTab1();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        final SaveFinishBtnListener saveFinishBtnListener = new SaveFinishBtnListener();
        lineDialog = new PdaLineDialog(PdaActivity.this);
        tabHost.setOnTabChangedListener(new OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                // TODO Auto-generated method stub
                if (tabId.equals("0")) {
                    initTab1();
                } else if (tabId.equals("1")) {
                    btn_pda_save.setText("保存");
                    btn_pda_finish.setVisibility(View.INVISIBLE);
                    title.setText("基本信息");
                    btn_pda_save.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //To change body of implemented methods use File | Settings | File Templates.
                            savePdaBaseInfo();
                            lineDialog.showLineSelectDialog(et_train_num.getText().toString());
                        }
                    });
                    et_car_num.setText("");
                    et_car_type.setText("");
                    et_train_num.setText("");
                    et_main_driver.setText("");
                    et_co_driver.setText("");
                    btn_start_work.setText("");
                    btn_off_work.setText("");
                    et_student_name.setText("");
                    et_other_car_name.setText("");
                    et_other_car_type.setText("");
                    et_other_car_driver.setText("");
                    et_run_note.setText("");
                    et_note.setText("");
                } else if (tabId.equals("2")) {
                    btn_pda_save.setText("保存");
                    btn_pda_finish.setVisibility(View.VISIBLE);
                    btn_pda_finish.setText("完成");
                    title.setText("运行信息");
                    btn_pda_save.setOnClickListener(saveFinishBtnListener);
                    btn_pda_finish.setOnClickListener(saveFinishBtnListener);
                }
                for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
                    if (tabId.equals(i + "")) {
                        View im = tabHost.getTabWidget().getChildAt(i);
                        im.setBackgroundResource(R.drawable.nav_2);
                    } else {
                        View im2 = tabHost.getTabWidget().getChildAt(i);
                        im2.setBackgroundResource(R.drawable.nav_1);
                    }
                }
            }
        });
    }

    private void initTab1() {
        btn_pda_save.setText("添加手帐");
        btn_pda_finish.setVisibility(View.INVISIBLE);
        title.setText("手帐列表");
        btn_pda_save.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //To change body of implemented methods use File | Settings | File Templates.
                tabHost.setCurrentTab(1);
            }
        });
    }

    class SaveFinishBtnListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            //To change body of implemented methods use File | Settings | File Templates.
            switch (v.getId()) {
                case R.id.btn_pda_save:
                    break;
                case R.id.btn_pda_finish:
                    break;
            }
        }
    }

    private void savePdaBaseInfo() {
        InitDB.initDB(PdaActivity.this);
        Handbook handbook = new Handbook();
        handbook.setAddDate(DateUtil.getLocalDate());
        handbook.setCar(et_car_num.getText().toString());
        handbook.setCoDriver(et_co_driver.getText().toString());
        handbook.setDriver(et_main_driver.getText().toString());
        handbook.setFollowControl(radio_follow_control.isChecked());
        handbook.setMasterControl(radio_master_control.isChecked());
        handbook.setNote(et_note.getText().toString());
        handbook.setWeather(weatherDialog.getWeather());
        handbook.setStudent(et_student_name.getText().toString());
        handbook.setPrecaution(et_run_note.getText().toString());
        handbook.setTrainNo(et_train_num.getText().toString());
        handbook.setOtherCar(et_other_car_name.getText().toString());
        handbook.setOtherCarType(et_other_car_type.getText().toString());
        handbook.setOtherCarDriver(et_other_car_driver.getText().toString());
        handbook.setStartWork(btn_start_work.getText().toString());
        handbook.setEndWork(btn_off_work.getText().toString());
        HandbookDao.getinstance(PdaActivity.this).insert(handbook);
        List<Handbook> handbookList = HandbookDao.getinstance(PdaActivity.this).getHandbooks();
        System.out.println("【【【【handBookList: " + new Gson().toJson(handbookList));
        System.out.println("【【【【handbbook: " + new Gson().toJson(handbook));
    }




    class TabFactory implements TabContentFactory {
        private Context con;
        private int tabnum;
        private View covertView;

        public TabFactory(Context c, int tabnum) {
            this.con = c;
            this.tabnum = tabnum;
            inflater = LayoutInflater.from(this.con);
        }

        @Override
        public View createTabContent(String arg0) {
            if (tabnum == 0) {
                covertView = inflater.inflate(R.layout.pda_list, null);
                //initPdaList(covertView);
            } else if (tabnum == 1) {
                covertView = inflater.inflate(R.layout.pda_info, null);
                initPdaInfo(covertView);
            } else if (tabnum == 2) {
                covertView = inflater.inflate(R.layout.pda_run, null);
                pdaRun =new PdaRun(PdaActivity.this,covertView);
            }
            return covertView;
        }
    }


}
