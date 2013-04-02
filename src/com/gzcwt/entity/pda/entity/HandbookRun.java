package com.gzcwt.entity.pda.entity;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * 手账运行信息实体
 *
 * @author zengqf （曾庆锋）
 *         2013-3-30
 */
@DatabaseTable(tableName = "c_handbook_run")
public class HandbookRun {
    /**
     * 运行信息id
     */
    @DatabaseField(generatedId = true, columnName = "hbr_id",unique = true)
    private Integer id;
    /**
     * 标志
     */
    @DatabaseField(columnName = "hbr_flag", dataType = DataType.INTEGER)
    private int flag;
    /**
     * 站点
     */
    @DatabaseField(columnName = "hbr_station")
    private String station;
    /**
     * 限速
     */
    @DatabaseField(columnName = "hbr_speed_limit", dataType = DataType.FLOAT)
    private float speedLimit;
    /**
     * 区停 ，类型不确定？？？
     */
    @DatabaseField(columnName = "hbr_part_interval")
    private String partInterval;
    /**
     * 辆数
     */
    @DatabaseField(columnName = "hbr_car_count", dataType = DataType.INTEGER)
    private int carCount;
    /**
     * 司机
     */
    @DatabaseField(columnName = "hbr_driver")
    private String driver;
    /**
     * 吨
     */
    @DatabaseField(columnName = "hbr_tonnage", dataType = DataType.FLOAT)
    private float tonnage;
    /**
     * 计长
     */
    @DatabaseField(columnName = "hbr_length", dataType = DataType.INTEGER)
    private int length;
    /**
     * 出发时间
     */
    @DatabaseField(columnName = "hbr_parttime")
    private String partTime;
    /**
     * 到达时间
     */
    @DatabaseField(columnName = "hbr_offtime")
    private String offTime;
    /**
     * 冲风时长
     */
    @DatabaseField(columnName = "hbr_charge_wind_time", dataType = DataType.LONG)
    private long chargeWind;
    /**
     * 排风时长
     */
    @DatabaseField(columnName = "hbr_discharge_wind", dataType = DataType.LONG)
    private long dischargeWind;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public void setSpeedLimit(float speedLimit) {
        this.speedLimit = speedLimit;
    }

    public void setPartInterval(String partInterval) {
        this.partInterval = partInterval;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setTonnage(float tonnage) {
        this.tonnage = tonnage;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setPartTime(String partTime) {
        this.partTime = partTime;
    }

    public void setOffTime(String offTime) {
        this.offTime = offTime;
    }

    public void setChargeWind(long chargeWind) {
        this.chargeWind = chargeWind;
    }

    public void setDischargeWind(long dischargeWind) {
        this.dischargeWind = dischargeWind;
    }

    public Integer getId() {
        return id;
    }

    public int getFlag() {
        return flag;
    }

    public String getStation() {
        return station;
    }

    public float getSpeedLimit() {
        return speedLimit;
    }

    public String getPartInterval() {
        return partInterval;
    }

    public int getCarCount() {
        return carCount;
    }

    public String getDriver() {
        return driver;
    }

    public float getTonnage() {
        return tonnage;
    }

    public int getLength() {
        return length;
    }

    public String getPartTime() {
        return partTime;
    }

    public String getOffTime() {
        return offTime;
    }

    public long getChargeWind() {
        return chargeWind;
    }

    public long getDischargeWind() {
        return dischargeWind;
    }
}
