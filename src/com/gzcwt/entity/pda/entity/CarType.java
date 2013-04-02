package com.gzcwt.entity.pda.entity;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "c_car_type")
public class CarType {

    @DatabaseField(generatedId = true,unique = true)
    private Integer id;

    @DatabaseField(columnName = "car_type_name", canBeNull = false,unique = true,useGetSet = true)
    private String carTypeName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarTypeName() {
        return carTypeName;
    }

    public void setCarTypeName(String carTypeName) {
        this.carTypeName = carTypeName;
    }

}
