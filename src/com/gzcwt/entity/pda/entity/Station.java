package com.gzcwt.entity.pda.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 站点实体
 *
 * @author zengqf （曾庆锋）
 *         2013-3-30
 */
@DatabaseTable(tableName = "c_station")
public class Station {
    /**
     * 站点id
     */
    @DatabaseField(generatedId = true,unique = true,columnName = "sta_id")
    private Integer id;
    /**
     * 站点名
     */
    @DatabaseField(columnName = "sta_name",unique = true)
    private String name;
    /**
     * 站点备注
     */
    @DatabaseField(columnName = "sta_remark")
    private String remark;


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


}
