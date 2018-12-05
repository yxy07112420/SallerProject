package com.neuedu.business;

import com.neuedu.entity.Categroy;
import com.neuedu.entity.Page;

import java.util.List;

public interface CateBusiness {
    //根据商品类型的id值查询商品的类型
    public Categroy getOneCate(int Cate_id);
    //查看父类商品
    public List<Categroy> getParCate();
    //查看二级商品类别
    public List<Categroy> getChildCate(int parId);
    //查询所有的二级类别信息
    public List<Categroy> getChildCate();
    //分页查询商品的类别信息
    //根据当前页和每页记录查询
    public Page getCateByLimite(int pageNum, int pageSize,Integer cate_par_id);
    //修改商品信息（包括增、删、该操作）
    public boolean updateCate(String sql,Object...objects);
    //删除商品信息
    public boolean deleteCate(int cate_id);
}
