package com.gzcwt.entity.pda.dao;

import android.app.Activity;
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
public class TrainLineDao {

    Activity ctx;
    Dao<TrainLine, Integer> trainLineDao;

    private static TrainLineDao instance;

    public static TrainLineDao getInstance(Activity ctx) {
        if (instance == null)
            instance = new TrainLineDao(ctx);
        return instance;
    }

    public TrainLineDao(Activity ctx) {
        this.ctx = ctx;
        trainLineDao = DbHelper.getInstance(this.ctx).getTrainLineDao();
    }

    public boolean insert(TrainLine trainLine) {
        try {
            trainLineDao.create(trainLine);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<TrainLine> getTrainLines() {
        try {
            return trainLineDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
