package com.gzcwt.entity.pda.entity;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.HashSet;
import java.util.Set;

/**
 * 司机手帐实体
 *
 * @author zengqf
 */
@DatabaseTable(tableName = "c_handbook")
public class Handbook {
    /**
     * 手帐编号
     */
    @DatabaseField(generatedId = true, columnName = "hb_id",unique = true)
    private Integer id;
    /**
     * 手帐车次
     */
    @DatabaseField(columnName = "hb_train_no")
    private String trainNo;
    /**
     * 机车号
     */
    @DatabaseField(columnName = "hb_car")
    private String car;
    /**
     * 机车类型
     */
    @DatabaseField(columnName = "hb_car_type")
    private String carType;
    /**
     * 手帐司机
     */
    @DatabaseField(columnName = "hb_driver")
    private String driver;
    /**
     * 副司机
     */
    @DatabaseField(columnName = "hb_co_driver")
    private String coDriver;
    /**
     * 出勤时间
     */
    @DatabaseField(columnName = "hb_start_work")
    private String startWork;
    /**
     * 退勤时间
     */
    @DatabaseField(columnName = "hb_en_work")
    private String endWork;
    /**
     * 学员
     */
    @DatabaseField(columnName = "hb_student")
    private String student;
    /**
     * 天气
     */
    @DatabaseField(columnName = "hb_weather")
    private String weather;
    /**
     * 是否主控
     */
    @DatabaseField(columnName = "hb_master_control", dataType = DataType.BOOLEAN)
    private boolean masterControl;
    /**
     * 是否从控
     */
    @DatabaseField(columnName = "hb_follow_control", dataType = DataType.BOOLEAN)
    private boolean followControl;
    /**
     * 他车号
     */
    @DatabaseField(columnName = "hb_other_car")
    private String otherCar;
    /**
     * 他车类型
     */
    @DatabaseField(columnName = "hb_other_car_type")
    private String otherCarType;
    /**
     * 他车司机
     */
    @DatabaseField(columnName = "hb_other_car_driver")
    private String otherCarDriver;
    /**
     * 注意事项
     */
    @DatabaseField(columnName = "hb_precaution")
    private String precaution;
    /**
     * 记事
     */
    @DatabaseField(columnName = "hb_note")
    private String note;
    /**
     * 手帐添加时间
     */
    @DatabaseField(columnName = "hb_add_date")
    private String addDate;
    /**
     * 该手帐对应的全部运行信息
     */
    private Set<HandbookRun> handbookRuns = new HashSet<HandbookRun>(0);

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setCoDriver(String coDriver) {
        this.coDriver = coDriver;
    }

    public void setStartWork(String startWork) {
        this.startWork = startWork;
    }

    public void setEndWork(String endWork) {
        this.endWork = endWork;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setMasterControl(boolean masterControl) {
        this.masterControl = masterControl;
    }

    public void setFollowControl(boolean followControl) {
        this.followControl = followControl;
    }

    public void setOtherCar(String otherCar) {
        this.otherCar = otherCar;
    }

    public void setOtherCarType(String otherCarType) {
        this.otherCarType = otherCarType;
    }

    public void setOtherCarDriver(String otherCarDriver) {
        this.otherCarDriver = otherCarDriver;
    }

    public void setPrecaution(String precaution) {
        this.precaution = precaution;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public Integer getId() {
        return id;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public String getCar() {
        return car;
    }

    public String getCarType() {
        return carType;
    }

    public String getDriver() {
        return driver;
    }

    public String getCoDriver() {
        return coDriver;
    }

    public String getStartWork() {
        return startWork;
    }

    public String getEndWork() {
        return endWork;
    }

    public String getStudent() {
        return student;
    }

    public String getWeather() {
        return weather;
    }

    public boolean isMasterControl() {
        return masterControl;
    }

    public boolean isFollowControl() {
        return followControl;
    }

    public String getOtherCar() {
        return otherCar;
    }

    public String getOtherCarType() {
        return otherCarType;
    }

    public String getOtherCarDriver() {
        return otherCarDriver;
    }

    public String getPrecaution() {
        return precaution;
    }

    public String getNote() {
        return note;
    }

    public String getAddDate() {
        return addDate;
    }
}
