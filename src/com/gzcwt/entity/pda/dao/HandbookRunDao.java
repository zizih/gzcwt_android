package com.gzcwt.entity.pda.dao;

import android.app.Activity;
import com.gzcwt.entity.pda.entity.HandbookRun;
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
public class HandbookRunDao {

    Activity ctx;
    Dao<HandbookRun, Integer> handbookRunDao;

    private static HandbookRunDao instance;

    public static HandbookRunDao getInstance(Activity ctx) {
        if (instance == null)
            instance = new HandbookRunDao(ctx);
        return instance;
    }

    public HandbookRunDao(Activity ctx) {
        this.ctx = ctx;
        handbookRunDao = DbHelper.getInstance(this.ctx).getHandbookRunDao();
    }

    public boolean insert(HandbookRun handbookrun) {
        try {
            handbookRunDao.create(handbookrun);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<HandbookRun> getHandbookRuns() {
        try {
            return handbookRunDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
