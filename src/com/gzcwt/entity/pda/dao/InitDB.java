package com.gzcwt.entity.pda.dao;

import android.app.Activity;
import android.util.Log;
import com.google.gson.Gson;
import com.gzcwt.entity.pda.entity.Handbook;
import com.gzcwt.entity.pda.entity.Station;
import com.gzcwt.entity.pda.entity.TrainLine;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 4/1/13
 * Time: 8:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class InitDB {


    public static void initDB(Activity ctx) {
        System.out.println("】】】DROP"+DbHelper.getInstance(ctx).DropTables());
        System.out.println("】】】CREATE" + DbHelper.getInstance(ctx).CreateTables());

        TrainLine trainLine = new TrainLine();
        Station station = new Station();


        trainLine.setName("广深线");
        trainLine.setRemark("remark!");
        TrainLineDao.getInstance(ctx).insert(trainLine);

        trainLine.setName("DD广京线");
        trainLine.setRemark("remark!");
        TrainLineDao.getInstance(ctx).insert(trainLine);

        trainLine.setName("广上线");
        trainLine.setRemark("remark!");
        TrainLineDao.getInstance(ctx).insert(trainLine);

        trainLine.setName("ab直通线");
        trainLine.setRemark("remark!");
        TrainLineDao.getInstance(ctx).insert(trainLine);

        station.setName("广州");
        station.setRemark("remark");
        StationDao.getInstance(ctx).insert(station);

        station.setName("上海");
        station.setRemark("remark");
        StationDao.getInstance(ctx).insert(station);

        station.setName("深圳");
        station.setRemark("remark");
        StationDao.getInstance(ctx).insert(station);

        List<TrainLine> trainLineList = TrainLineDao.getInstance(ctx).getTrainLines();
        System.out.println("【【【【trainLineList: " + new Gson().toJson(trainLineList));
        List<Station> stationList = StationDao.getInstance(ctx).getStations();
        System.out.println("【【【【stationList: " + new Gson().toJson(stationList));
    }
}
