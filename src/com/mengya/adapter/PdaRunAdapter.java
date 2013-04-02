package com.mengya.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.mengya.gzcwt.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 3/30/13
 * Time: 2:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class PdaRunAdapter extends BaseAdapter{

    //pda_list
    private TextView tv_train_num;
    private TextView tv_driver_name;
    private TextView tv_add_time;
    private List<HashMap<String,String>> items;

    private Activity ctx;

    public PdaRunAdapter(Activity ctx,ArrayList<HashMap<String,String>> items) {
        this.ctx = ctx;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getItemId(int position) {
        return position;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = View.inflate(ctx, R.layout.pda_list_item,null);
        tv_train_num = (TextView) convertView.findViewById(R.id.tv_list_train_num);
        tv_driver_name = (TextView) convertView.findViewById(R.id.tv_list_driver_name);
        tv_add_time = (TextView) convertView.findViewById(R.id.tv_list_add_time);
        tv_train_num.setText(items.get(position).get("train_num"));
        tv_driver_name.setText(items.get(position).get("driver_name"));
        tv_add_time.setText(items.get(position).get("add_time"));

        return convertView;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
