package com.yeqifu.activiti;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;

import java.util.List;

/**
 * activiti历史信息的查询
 * @Author: 落亦-
 * @Date: 2020/4/18 19:43
 */
public class HistoryQuery {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        HistoryService historyService = processEngine.getHistoryService();
        //获得流程实例的查询对象
        HistoricActivityInstanceQuery historicActivityInstanceQuery = historyService.createHistoricActivityInstanceQuery();
        //设置流程实例的ID
        historicActivityInstanceQuery.processInstanceId("2501");
        //执行查询，获得一个list,并遍历list
        List<HistoricActivityInstance> list = historicActivityInstanceQuery.orderByHistoricActivityInstanceStartTime().asc().list();
        for (HistoricActivityInstance activityInstance : list) {
            System.out.println(activityInstance.getActivityId());
            System.out.println(activityInstance.getActivityName());
            System.out.println(activityInstance.getAssignee());
            System.out.println(activityInstance.getProcessInstanceId());
            System.out.println("==========================================");
        }

    }
}
