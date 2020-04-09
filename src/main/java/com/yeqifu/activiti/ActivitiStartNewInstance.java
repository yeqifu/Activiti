package com.yeqifu.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 运行一个流程实例：前提是已经完成流程定义的部署工作
 * 背后影响的表：
 *      act_hi_actinst      已完成的活动信息
 *      act_hi_identitylink 参与者信息
 *      act_hi_procinst     流程实例
 *      act_hi_taskinst     任务实例
 *      act_ru_execution    执行表
 *      act_ru_identitylink 参与者信息
 *      act_ru_task         任务
 *
 * @Author: 落亦-
 * @Date: 2020/4/9 10:07
 */
public class ActivitiStartNewInstance {
    public static void main(String[] args) {
        //1.获得processEngine
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.获取runtimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //3.运行实例
        ProcessInstance myHoliday = runtimeService.startProcessInstanceByKey("myProcess_1");

        System.out.println("流程部署的ID："+myHoliday.getDeploymentId());
        System.out.println("流程实例的ID："+myHoliday.getId());
    }
}
