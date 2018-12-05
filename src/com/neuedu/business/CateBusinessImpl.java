package com.neuedu.business;

import com.neuedu.dao.CateDao;
import com.neuedu.dao.CateDaoImpl;
import com.neuedu.entity.Categroy;
import com.neuedu.entity.Page;
import com.neuedu.entity.Shop;

import java.util.List;
import java.util.Map;

public class CateBusinessImpl implements CateBusiness {
    CateDao cateDao = new CateDaoImpl();
    @Override
    public Categroy getOneCate(int Cate_id) {
        return cateDao.getOneCate(Cate_id);
    }

    @Override
    public List<Categroy> getParCate() {
        return cateDao.getParCategroy();
    }

    @Override
    public List<Categroy> getChildCate(int parId) {
        return cateDao.getSecondCate(parId);
    }
//查询所有的二级类别
    @Override
    public List<Categroy> getChildCate() {
        return cateDao.getSecondCate();
    }
    @Override
    public Page getCateByLimite(int pageNum, int pageSize,Integer cate_par_id) {
        //查询总的数据数
        int allRecords = cateDao.getAllRecords();
        //创建page对象
        Page page = new Page(pageNum,pageSize,allRecords);
        Integer startIndex = page.getStartIndex();
        //分页查询
        Map<Categroy, String> cateByLimit = cateDao.getCateByLimit(startIndex, pageSize,cate_par_id);
        page.setCates(cateByLimit);
        return page;
    }
    //修改商品信息
    @Override
    public boolean updateCate(String sql, Object... objects) {
        return cateDao.updateCate(sql,objects);
    }
    //删除商品信息
    @Override
    public boolean deleteCate(int cate_id) {
        //判断是否为一级类别
        Categroy oneCate = cateDao.getOneCate(cate_id);
        if(oneCate.getCate_Parent_Id()!=0){
            System.out.println("我是二级类别，可以进行删除");
            //根据当前的商品类别id查询当前的商品信息
            //创建商品信息
            ShopsBusiness shopsBusiness = new ShopsBusinessImpl();
            List<Shop> shops = shopsBusiness.getShops(cate_id);
            if(shops.size()>0){
                System.out.println("我是有商品信息的");
                //删除商品信息
                boolean exists = shopsBusiness.updateShopsIsExists("delete from shop where shop_cate_id = ?", cate_id);
                if(exists == true){
                    //删除类别
                    String sql = "delete from categroy where cate_id = ?";
                    return cateDao.updateCate(sql, cate_id);
                }
            }else {
                System.out.println("我没有商品信息");
                //删除类别
                String sql = "delete from categroy where cate_id = ?";
                return cateDao.updateCate(sql, cate_id);
            }
        }
        return false;
    }
}
