package com.neuedu.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品信息
 */

public class Shop implements Serializable {
    private Integer id;
    //商品编号
    private String shop_id;
    //商品名
    private String shop_Name;
    //商品的描述
    private String shop_des;
    //商品的图片
    private String shop_img;
    //商品的销售价格
    private BigDecimal shop_price;
    //商品类型
    private Integer shop_Cate_id;
    //商品的库存数量
    private Integer shop_Stock;
    //商品的状态（是否存在于回收站中）
    private Byte shop_IsGc;
    public Shop(){

    }

    public Shop(Integer id, String shop_id, String shop_Name, String shop_des, String shop_img, BigDecimal shop_price, Integer shop_Cate_id, Integer shop_Stock, Byte shop_IsGc) {
        this.id = id;
        this.shop_id = shop_id;
        this.shop_Name = shop_Name;
        this.shop_des = shop_des;
        this.shop_img = shop_img;
        this.shop_price = shop_price;
        this.shop_Cate_id = shop_Cate_id;
        this.shop_Stock = shop_Stock;
        this.shop_IsGc = shop_IsGc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_Name() {
        return shop_Name;
    }

    public void setShop_Name(String shop_Name) {
        this.shop_Name = shop_Name;
    }

    public String getShop_des() {
        return shop_des;
    }

    public void setShop_des(String shop_des) {
        this.shop_des = shop_des;
    }

    public String getShop_img() {
        return shop_img;
    }

    public void setShop_img(String shop_img) {
        this.shop_img = shop_img;
    }

    public BigDecimal getShop_price() {
        return shop_price;
    }

    public void setShop_price(BigDecimal shop_price) {
        this.shop_price = shop_price;
    }

    public Integer getShop_Cate_id() {
        return shop_Cate_id;
    }

    public void setShop_Cate_id(Integer shop_Cate_id) {
        this.shop_Cate_id = shop_Cate_id;
    }

    public Integer getShop_Stock() {
        return shop_Stock;
    }

    public void setShop_Stock(Integer shop_Stock) {
        this.shop_Stock = shop_Stock;
    }

    public Byte getShop_IsGc() {
        return shop_IsGc;
    }

    public void setShop_IsGc(Byte shop_IsGc) {
        this.shop_IsGc = shop_IsGc;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", shop_id='" + shop_id + '\'' +
                ", shop_Name='" + shop_Name + '\'' +
                ", shop_des='" + shop_des + '\'' +
                ", shop_img='" + shop_img + '\'' +
                ", shop_price=" + shop_price +
                ", shop_Cate_id=" + shop_Cate_id +
                ", shop_Stock=" + shop_Stock +
                ", shop_IsGc=" + shop_IsGc +
                '}';
    }
}
