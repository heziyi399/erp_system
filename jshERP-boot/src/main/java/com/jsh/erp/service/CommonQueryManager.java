package com.jsh.erp.service;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author jishenghua 752718920 2018-10-7 15:25:58
 */
@Slf4j
@Service
public class CommonQueryManager {

    @Resource
    private InterfaceContainer container;

    @Resource
    private LogService logService;

    /**
     * 查询单条
     *
     * @param apiName 接口名称
     * @param id      ID
     */
    public Object selectOne(String apiName, Long id) throws Exception {
        if (StringUtil.isNotEmpty(apiName) && id!=null) {
            return container.getCommonQuery(apiName).selectOne(id);
        }
        return null;
    }

    /**
     * 查询
     * @param apiName
     * @param parameterMap
     * @return
     */
    public List<?> select(String apiName, Map<String, String> parameterMap)throws Exception {
        if (StringUtil.isNotEmpty(apiName)) {
            System.out.println("CommonQueryManager的方法："+apiName);
            parameterMap.entrySet().forEach(e->
                    System.out.print(e.getKey()+":"+e.getValue()
            ));
            return container.getCommonQuery(apiName).select(parameterMap);
        }
        return new ArrayList<Object>();
    }

    /**
     * 计数
     * @param apiName
     * @param parameterMap
     * @return
     */
    public Long counts(String apiName, Map<String, String> parameterMap)throws Exception {
        if (StringUtil.isNotEmpty(apiName)) {
            parameterMap.entrySet().forEach(e->{
                log.info(e.getKey()+":"+e.getValue());
            });
            //输出
    // 2021/10/27-13:11:00 INFO  [http-nio-9999-exec-1] com.jsh.erp.service.CommonQueryManager - search:{"number":"","materialParam":"衣服","type":"其它",
            // "subType":"销售订单","roleType":"全部数据","organId":"","depotId":"","creator":""}
   //2021/10/27-13:11:00 INFO  [http-nio-9999-exec-1] com.jsh.erp.service.CommonQueryManager - field:id,,organName,number,materialsList,operTimeStr,userName,totalPrice,status,action
    //2021/10/27-13:11:00 INFO  [http-nio-9999-exec-1] com.jsh.erp.service.CommonQueryManager - offset:0
     //2021/10/27-13:11:00 INFO  [http-nio-9999-exec-1] com.jsh.erp.service.CommonQueryManager - column:createTime
     //2021/10/27-13:11:00 INFO  [http-nio-9999-exec-1] com.jsh.erp.service.CommonQueryManager - pageSize:10
    //2021/10/27-13:11:00 INFO  [http-nio-9999-exec-1] com.jsh.erp.service.CommonQueryManager - currentPage:1
    //2021/10/27-13:11:00 INFO  [http-nio-9999-exec-1] com.jsh.erp.service.CommonQueryManager - order:desc

            return container.getCommonQuery(apiName).counts(parameterMap);
        }
        return BusinessConstants.DEFAULT_LIST_NULL_NUMBER;
    }

    /**
     * 插入
     * @param apiName
     * @param obj
     * @return
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insert(String apiName, JSONObject obj, HttpServletRequest request) throws Exception{
        if (StringUtil.isNotEmpty(apiName)) {
            return container.getCommonQuery(apiName).insert(obj, request);
        }
        return 0;
    }

    /**
     * 更新
     * @param apiName
     * @param obj
     * @return
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int update(String apiName, JSONObject obj, HttpServletRequest request)throws Exception {
        if (StringUtil.isNotEmpty(apiName)) {
            return container.getCommonQuery(apiName).update(obj, request);
        }
        return 0;
    }

    /**
     * 删除
     * @param apiName
     * @param id
     * @return
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int delete(String apiName, Long id, HttpServletRequest request)throws Exception {
        if (StringUtil.isNotEmpty(apiName)) {
            return container.getCommonQuery(apiName).delete(id, request);
        }
        return 0;
    }

    /**
     * 批量删除
     * @param apiName
     * @param ids
     * @return
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteBatch(String apiName, String ids, HttpServletRequest request)throws Exception {
        if (StringUtil.isNotEmpty(apiName)) {
            return container.getCommonQuery(apiName).deleteBatch(ids, request);
        }
        return 0;
    }

    /**
     * 判断是否存在
     * @param apiName
     * @param id
     * @param name
     * @return
     */
    public int checkIsNameExist(String apiName, Long id, String name) throws Exception{
        if (StringUtil.isNotEmpty(apiName)) {
            return container.getCommonQuery(apiName).checkIsNameExist(id, name);
        }
        return 0;
    }

}