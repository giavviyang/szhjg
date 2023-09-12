package com.fudian.szhjg.templateMode;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fudian.common.pojo.BaseEntity;
import com.fudian.common.pojo.CommonGridResult;
import com.fudian.common.pojo.CommonResult;
import com.fudian.szhjg.pojo.TProject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.List;

public class TemplateQuery<T extends BaseEntity,S extends IService<T>,M extends BaseMapper<T>> {
//
//    private T tEntity;
//
//    private S tEntityService;
//    private M tEntityMapper;
//
//    public TemplateQuery(T t,S s,M m) {
//        this.tEntity=t;
//        this.tEntityService=s;
//        this.tEntityMapper=m;
//    }
//
//    //此方法为了实现查询条件的组合,目前采用接收sql语句的方式，如果有更好的方式可以在此处修改。
//    public void spliceSql(LambdaQueryWrapper<T> lambdaQueryWrapper,String sql){
////        System.out.println(o.length);
////        for (Object s : o){
////            System.out.println(s);
////        }
////        lambdaQueryWrapper.like(TProject::getProjectName,"%");
////        lambdaQueryWrapper.last("where project_name like '%' order by project_name desc");
//        if(sql==null||!sql.startsWith("where")||sql.contains("CREATE")||sql.contains("DROP")||sql.contains("ALTER")||sql.contains("show")||sql.contains("databases")||sql.contains("database_name")||sql.contains("TABLE")||sql.contains("TABLES")||sql.contains("tablename")||sql.contains("COLUMN")){
//            System.out.println("=====sql语句有误，请检查！=====");
//            lambdaQueryWrapper.last(null);
//        }else
//            lambdaQueryWrapper.last(sql);
//    }
//
//    //查询
//    @Override
//    public CommonGridResult queryAllList(String sql) {
//
//        LambdaQueryWrapper<T> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//
//        spliceSql(lambdaQueryWrapper,sql);
//
//        try {
//            PageHelper.startPage(tEntity.getPageNum(),tEntity.getPageSize());
//            List<T> tProjectList = tEntityService.list(lambdaQueryWrapper);
//            Page page = (Page) tProjectList;
//            CommonGridResult commonGridResult = new CommonGridResult(tEntity.getPageNum(), tEntity.getPageSize(), page.getTotal(), tProjectList);
//            return  commonGridResult;
//        }catch (Exception e){
//            System.out.println("=====查询语句有误，请检查！=====");
//        }
//
//        return null;
//    }
//
//    @Override
//    public CommonResult add() {
//        int i = tEntityMapper.insert(tEntity);
//        CommonResult commonResult = new CommonResult();
//        if (i > 0) {
//            commonResult.setCode(200);
//            commonResult.setMsg("新增项目成功");
//        } else {
//            commonResult.setCode(500);
//            commonResult.setMsg("新增项目失败");
//        }
//        return commonResult;
//    }
//
//    @Override
//    void update() {
//
//    }
//
//    @Override
//    void delete() {
//
//    }
}
