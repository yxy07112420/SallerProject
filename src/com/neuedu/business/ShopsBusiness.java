package com.neuedu.business;

import com.neuedu.entity.Categroy;
import com.neuedu.entity.Page;
import com.neuedu.entity.Shop;

import java.util.List;
import java.util.Map;

public interface ShopsBusiness {
    //根据当前页和每页记录查询
    public Page getShopsByPaging(int pageNum, int pageSize,int isGc);
    //修改商品表信息（增、删、改）
    public boolean updateShopsIsExists(String sql,Object...objects);
    //查询没有还原的商品信息
    public List<Shop> getShops();
    //根据商品id查询商品信息
    public List getOneShop(String shop_id);
    //根据商品类别编号查询商品信息
    public List<Shop> getShops(int shop_cate_id);
}
