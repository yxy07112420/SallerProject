package com.neuedu.entity;

import java.io.Serializable;

/**
 * 商品类别
 */
public class Categroy implements Serializable {
    private Integer cate_id;
    private String cate_Name;
    private Integer cate_Parent_Id;
    public Categroy(){

    }
    @Override
    public String toString() {
        return "Categroy{" +
                "cate_id=" + cate_id +
                ", cate_Name='" + cate_Name + '\'' +
                ", cate_Parent_Id=" + cate_Parent_Id +
                '}';
    }

    public Integer getCate_id() {
        return cate_id;
    }

    public void setCate_id(Integer cate_id) {
        this.cate_id = cate_id;
    }

    public String getCate_Name() {
        return cate_Name;
    }

    public void setCate_Name(String cate_Name) {
        this.cate_Name = cate_Name;
    }

    public Integer getCate_Parent_Id() {
        return cate_Parent_Id;
    }

    public void setCate_Parent_Id(Integer cate_Parent_Id) {
        this.cate_Parent_Id = cate_Parent_Id;
    }

    public Categroy(Integer cate_id, String cate_Name, Integer cate_Parent_Id) {
        this.cate_id = cate_id;
        this.cate_Name = cate_Name;
        this.cate_Parent_Id = cate_Parent_Id;
    }
}
