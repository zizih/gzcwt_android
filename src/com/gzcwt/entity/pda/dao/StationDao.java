package com.gzcwt.entity.pda.dao;

import android.app.Activity;
import com.gzcwt.entity.pda.entity.Station;
import com.gzcwt.entity.pda.entity.TrainLine;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 4/1/13
 * Time: 8:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class StationDao {

    Activity ctx;
    Dao<Station, Integer> stationDao;

    private static StationDao instance;

    public static StationDao getInstance(Activity ctx) {
        if (instance == null)
            instance = new StationDao(ctx);
        return instance;
    }

    public StationDao(Activity ctx) {
        this.ctx = ctx;
        stationDao = DbHelper.getInstance(this.ctx).getStationDao();
    }

    public boolean insert(Station station) {
        try {
            stationDao.create(station);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Station> getStations() {
        try {
            return stationDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
