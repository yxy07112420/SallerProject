package com.neuedu.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Page implements Serializable {
    //用户所选页数
    private Integer pageNum;
    //每页显示多少条数据
    private Integer pageSize;
    //总记录数
    private Integer allRecods;
    //开始页数
    private Integer startPage;
    //结束页数
    private Integer endPage;
    //总页数
    private Integer allPages;
    //数据库开始的索引数
    private Integer startIndex;
    //每一页数据集合
    Map<Shop,String> shops;
    //每一页类别的集合
    Map<Categroy,String> cates;
    public Page(){

    }
    public Page(int pageNum,int pageSize,int allRecods){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.allRecods = allRecods;
        if(allRecods%pageSize == 0){
            this.allPages = allRecods/pageSize;
        }else {
            this.allPages = allRecods/pageSize+1;
        }
        this.startIndex = (pageNum - 1)*pageSize;
        this.startPage = 1;
        this.endPage = 5;
        if(allPages <= 5){
            this.startPage = 1;
            this.endPage = this.allPages;
        }else {
            this.startPage = this.pageNum - 2;
            this.endPage = this.pageNum + 2;
            if(startPage <= 0){
                this.startPage = 1;
                this.endPage = 5;
            }
            if(endPage >= allPages){
                this.startPage = endPage - 4;
                this.endPage = this.allPages;
            }
        }
    }
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getAllRecods() {
        return allRecods;
    }

    public void setAllRecods(Integer allRecods) {
        this.allRecods = allRecods;
    }

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getEndPage() {
        return endPage;
    }

    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }

    public Integer getAllPages() {
        return allPages;
    }

    public void setAllPages(Integer allPages) {
        this.allPages = allPages;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Map<Shop, String> getShops() {
        return shops;
    }

    public void setShops(Map<Shop, String> shops) {
        this.shops = shops;
    }

    public Map<Categroy, String> getCates() {
        return cates;
    }

    public void setCates(Map<Categroy, String> cates) {
        this.cates = cates;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", allRecods=" + allRecods +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", allPages=" + allPages +
                ", startIndex=" + startIndex +
                ", shops=" + shops +
                ", cates=" + cates +
                '}';
    }
}
