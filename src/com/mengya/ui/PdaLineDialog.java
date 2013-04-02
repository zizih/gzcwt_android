package com.mengya.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.gzcwt.entity.pda.dao.DbHelper;
import com.gzcwt.entity.pda.dao.TrainLineDao;
import com.gzcwt.entity.pda.entity.Station;
import com.gzcwt.entity.pda.entity.TrainLine;
import com.j256.ormlite.dao.Dao;
import com.mengya.gzcwt.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 3/31/13
 * Time: 8:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class PdaLineDialog {
    Activity ctx;
    AlertDialog.Builder builder;
    AlertDialog dialog;

    List<String> lines;
    List<CheckBox> checkBoxList;
    LineCheckedChangeListener lineCheckedChangeListener;


    //about view
    View layout;
    GridLayout gl_checkbox_line_options;
    TextView tv_select_line;

    Spinner sp_line_first_station;
    Spinner sp_line_last_station;
    ArrayAdapter firstStationAdapter;
    ArrayAdapter lastStationAdapter;
    ArrayList<String> firstList;
    ArrayList<String> lastList;

    PdaLineDialog(Activity ctx) {
        this.ctx = ctx;
        checkBoxList = new ArrayList<CheckBox>();
        lineCheckedChangeListener = new LineCheckedChangeListener();
    }

    public void showLineSelectDialog(String train_num) {
        layout = View.inflate(this.ctx, R.layout.pda_line, null);
        gl_checkbox_line_options = (GridLayout) layout.findViewById(R.id.gl_checkbox_line_options);
        tv_select_line = (TextView) layout.findViewById(R.id.tv_select_line);

        List<TrainLine> trainLineList = TrainLineDao.getInstance(this.ctx).getTrainLines();
        if (trainLineList != null) {
            for (int i = 0; i < trainLineList.size(); i++) {
                gl_checkbox_line_options.addView(getoneCheckbox(trainLineList.get(i).getName()));
            }
        } else {
            tv_select_line.setText("数据库中没有路线可供选择");
        }
        firstList = new ArrayList<String>();
        lastList = new ArrayList<String>();

        sp_line_first_station = (Spinner) layout.findViewById(R.id.sp_line_first_station);
        sp_line_last_station = (Spinner) layout.findViewById(R.id.sp_line_last_station);

        firstStationAdapter = new ArrayAdapter(this.ctx, R.layout.simple_spinner_item, firstList);
        firstStationAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        lastStationAdapter = new ArrayAdapter(this.ctx, R.layout.simple_spinner_item, lastList);
        lastStationAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        sp_line_first_station.setAdapter(firstStationAdapter);
        sp_line_last_station.setAdapter(lastStationAdapter);


        builder = new AlertDialog.Builder(ctx);
        // dialog
        builder.setTitle("请选择路线");
        builder.setView(layout);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        }

        );
        builder.setNegativeButton("取消", null);
        dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }


    private CheckBox getoneCheckbox(String option) {
        CheckBox checkBox = new CheckBox(this.ctx);
        checkBox.setText(option);
        checkBoxList.add(checkBox);
        checkBox.setTextColor(Color.BLACK);
        checkBox.setOnCheckedChangeListener(lineCheckedChangeListener);
        return checkBox;
    }

    class LineCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            //To change body of implemented methods use File | Settings | File Templates.
            if (isChecked) {
                for (CheckBox checkBox : checkBoxList) {
                    checkBox.setChecked(false);
                }
                buttonView.setChecked(true);
                buttonView.getText();
            }
        }
    }
}
