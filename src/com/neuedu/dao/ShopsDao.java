package com.neuedu.dao;

import com.neuedu.entity.Shop;

import java.util.List;
import java.util.Map;

public interface ShopsDao {
    //查询所有的记录数(根据不同的商品信息)
    public int getAllRecords(int isGc);
    //查询某一页的数据
    public Map<Shop,String> getShopByLimit(int startIndex, int pageSize,int isGc);
    //修改商品表（增、删、改）
    public boolean updateShopsIsExists(String sql,Object...objects);
    //查询没有还原的商品信息
    public List<Shop> getShops();
    //根据商品id查询单个商品信息
    public Shop getOneShop(String shop_id);
    //根据商品类别编号查询商品信息
    public List<Shop> getShops(int shop_cate_id);
}
