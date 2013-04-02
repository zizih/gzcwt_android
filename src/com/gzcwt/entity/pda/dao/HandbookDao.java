package com.gzcwt.entity.pda.dao;

import android.app.Activity;
import com.gzcwt.entity.pda.entity.Handbook;
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
public class HandbookDao {

    Activity ctx;
    Dao<Handbook, Integer> handbookDao;

    private static HandbookDao instance;

    public static HandbookDao getinstance(Activity ctx) {
        if (instance == null)
            instance = new HandbookDao(ctx);
        return instance;
    }

    public HandbookDao(Activity ctx) {
        this.ctx = ctx;
        handbookDao = DbHelper.getInstance(this.ctx).getHandbookDao();
    }

    public boolean insert(Handbook handbook) {
        try {
            handbookDao.create(handbook);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Handbook> getHandbooks() {
        try {
            return handbookDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
