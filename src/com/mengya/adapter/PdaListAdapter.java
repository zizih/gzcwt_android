package com.mengya.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.gzcwt.entity.pda.entity.Handbook;
import com.gzcwt.entity.pda.entity.HandbookRun;
import com.mengya.gzcwt.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 3/30/13
 * Time: 2:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class PdaListAdapter extends BaseAdapter {

    //pda_list
    private TextView tv_train_num;
    private TextView tv_driver_name;
    private TextView tv_add_time;
    private List<Handbook> handbookList;

    private Activity ctx;

    public PdaListAdapter(Activity ctx, List<Handbook> handbookList) {
        this.ctx = ctx;
        this.handbookList = handbookList;
    }

    public PdaListAdapter(Activity ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return handbookList.size();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getItem(int position) {
        return handbookList.get(position);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getItemId(int position) {
        return position;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = View.inflate(ctx, R.layout.pda_list_item, null);
        tv_train_num = (TextView) convertView.findViewById(R.id.tv_list_train_num);
        tv_driver_name = (TextView) convertView.findViewById(R.id.tv_list_driver_name);
        tv_add_time = (TextView) convertView.findViewById(R.id.tv_list_add_time);
        tv_train_num.setText(handbookList.get(position).getTrainNo());
        tv_driver_name.setText(handbookList.get(position).getDriver());
        tv_add_time.setText(handbookList.get(position).getAddDate());

        return convertView;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void addHandbook(Handbook handbook) {
        this.handbookList.add(handbook);
    }

    public void setItems(List<Handbook> handbookList) {
        this.handbookList = handbookList;
    }

}
