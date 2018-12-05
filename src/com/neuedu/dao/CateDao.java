package com.neuedu.dao;

import com.neuedu.entity.Categroy;
import com.neuedu.entity.Shop;

import java.util.List;
import java.util.Map;

public interface CateDao {
    //根据类别id查询类别信息
    public Categroy getOneCate(int Cate_id);
    //查询所有的一级类别的信息
    public List<Categroy> getParCategroy();
    //根据一级类别的id查询二级类别
    public List<Categroy> getSecondCate(int cate_par_id);
    //查询所有的二级类别
    public List<Categroy> getSecondCate();
    //查询所有的记录数
    public int getAllRecords();
    //查询某一页的数据(根据父类 类别的状态)
    public Map<Categroy,String> getCateByLimit(int startIndex, int pageSize,Integer cate_par_id);
    //修改商品信息（包括增、删、该操作）
    public boolean updateCate(String sql,Object...objects);

}
