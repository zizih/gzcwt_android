package com.gzcwt.entity.pda.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.List;

/**
 * 路线
 *
 * @author zengqf （曾庆锋）
 *         2013-3-30
 */
@DatabaseTable(tableName = "c_trainline")
public class TrainLine {
    /**
     * 路线id
     */
    @DatabaseField(generatedId = true,unique = true)
    private Integer id;
    /**
     * 路线名
     */
    @DatabaseField(columnName = "tl_name")
    private String name;
    /**
     * 路线备注
     */

    @DatabaseField(columnName = "tl_remark")
    private String remark;
    /**
     * 该路线所有站点
     */
    private List<Station> stations = new ArrayList<Station>(0);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

}
