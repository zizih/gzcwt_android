package com.gzcwt.entity.pda.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.gzcwt.entity.pda.entity.*;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 3/31/13
 * Time: 3:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class DbHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "pda.db";
    private static final int DATABASE_VERSION = 1;
    private static Dao<CarType, Integer> carTypeDao = null;
    private static Dao<Handbook, Integer> handbookDao = null;
    private static Dao<HandbookRun, Integer> handbookRunDao = null;
    private static Dao<Station, Integer> stationDao = null;
    private static Dao<TrainLine, Integer> trainLineDao = null;

    @SuppressWarnings("unused")
    private Context context;

    private static DbHelper instance;

    public static DbHelper getInstance(Context ctx){
        if(instance == null)
            instance = new DbHelper(ctx);
        return instance;
    }

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();    //To change body of overridden methods use File | Settings | File Templates.
    }


    public boolean ClearAll() {
        ConnectionSource cs = getConnectionSource();
        try {
            TableUtils.clearTable(cs, CarType.class);
            TableUtils.clearTable(cs, Handbook.class);
            TableUtils.clearTable(cs, HandbookRun.class);
            TableUtils.clearTable(cs, Station.class);
            TableUtils.clearTable(cs, TrainLine.class);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean DropTables() {
        ConnectionSource cs = getConnectionSource();
        try {
            TableUtils.dropTable(cs, CarType.class, true);
            TableUtils.dropTable(cs, Handbook.class, true);
            TableUtils.dropTable(cs, HandbookRun.class, true);
            TableUtils.dropTable(cs, Station.class, true);
            TableUtils.dropTable(cs, TrainLine.class, true);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean CreateTables() {
        ConnectionSource cs = getConnectionSource();
        try {
            TableUtils.createTableIfNotExists(cs, CarType.class);
            TableUtils.createTableIfNotExists(cs, Handbook.class);
            TableUtils.createTableIfNotExists(cs, HandbookRun.class);
            TableUtils.createTableIfNotExists(cs, Station.class);
            TableUtils.createTableIfNotExists(cs, TrainLine.class);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource cs) {
        System.out.println("OnCreate!!");
    }

    public void onUpgrade(SQLiteDatabase db, ConnectionSource cs,
                          int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(cs, CarType.class, true);
            TableUtils.dropTable(cs, Handbook.class, true);
            TableUtils.dropTable(cs, HandbookRun.class, true);
            TableUtils.dropTable(cs, Station.class, true);
            TableUtils.dropTable(cs, TrainLine.class, true);
            onCreate(db, cs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Dao<CarType, Integer> getCarTypeDao() {
        try {
            if (carTypeDao == null) {
                carTypeDao = DaoManager.createDao(getConnectionSource(), CarType.class);
                //carTypeDao = getDao(CarType.class);
            }
            return carTypeDao;
        } catch (SQLException e) {
            Log.i("DB ERR:", "get carTypeDao err");
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Dao<Handbook, Integer> getHandbookDao() {
        try {
            if (handbookDao == null) {
                handbookDao = DaoManager.createDao(getConnectionSource(),
                        Handbook.class);
            }
            return handbookDao;
        } catch (SQLException e) {
            Log.i("DB ERR:", "get handbookDao err");
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Dao<HandbookRun, Integer> getHandbookRunDao() {
        try {
            if (handbookRunDao == null) {
                handbookRunDao = DaoManager.createDao(getConnectionSource(),
                        HandbookRun.class);
            }
            return handbookRunDao;
        } catch (SQLException e) {
            Log.i("DB ERR:", "get handbookRunDao err");
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Dao<Station, Integer> getStationDao() {
        try {
            if (stationDao == null) {
                stationDao = DaoManager.createDao(getConnectionSource(),
                        Station.class);
            }
            return stationDao;
        } catch (SQLException e) {
            Log.i("DB ERR:", "get staionDao err");
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Dao<TrainLine, Integer> getTrainLineDao() {
        try {
            if (trainLineDao == null) {
                trainLineDao = DaoManager.createDao(getConnectionSource(),
                        TrainLine.class);
            }
            return trainLineDao;
        } catch (SQLException e) {
            Log.i("DB ERR:", "get trainLineDao err");
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return null;
        }
    }

}
