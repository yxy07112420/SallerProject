package com.neuedu.business;

import com.neuedu.dao.CateDao;
import com.neuedu.dao.CateDaoImpl;
import com.neuedu.dao.ShopsDao;
import com.neuedu.dao.ShopsDapImpl;
import com.neuedu.entity.Categroy;
import com.neuedu.entity.Page;
import com.neuedu.entity.Shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopsBusinessImpl implements ShopsBusiness {
    ShopsDao shopsDao = new ShopsDapImpl();
    @Override
    public Page getShopsByPaging(int pageNum, int pageSize,int isGc) {
        //查询中的记录数
        int allRecords = shopsDao.getAllRecords(isGc);
        //构建page对象
        Page page = new Page(pageNum,pageSize,allRecords);
        //拿到page中的开始索引
        Integer startIndex = page.getStartIndex();
        //根据开始索引和页面数量查询商品
        Map<Shop, String> shopByLimit = shopsDao.getShopByLimit(startIndex, pageSize,isGc);
        page.setShops(shopByLimit);
        return page;
    }

    @Override
    public boolean updateShopsIsExists(String sql, Object... objects) {
        return shopsDao.updateShopsIsExists(sql,objects);
    }

    @Override
    public List<Shop> getShops() {

        return shopsDao.getShops();
    }
//根据商品id查询单个商品信息
    @Override
    public List getOneShop(String shop_id) {
        Shop oneShop = shopsDao.getOneShop(shop_id);
        if(oneShop != null){
            //获取商品类别编号
            Integer shop_cate_id = oneShop.getShop_Cate_id();
            //根据就商品的类别编号获取商品类别
            CateBusiness cateBusiness = new CateBusinessImpl();
            Categroy oneCate = cateBusiness.getOneCate(shop_cate_id);
            //获取商品的类别名
            String cate_name = oneCate.getCate_Name();
            //创建一个集合
            List list = new ArrayList();
            list.add(oneShop);
            list.add(cate_name);
            return list;
        }
       return null;
    }

    @Override
    public List<Shop> getShops(int shop_cate_id) {
        return shopsDao.getShops(shop_cate_id);
    }
}
