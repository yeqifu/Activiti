package com.yeqifu.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;

/**
 * 删除流程定义
 * @Author: 落亦-
 * @Date: 2020/4/11 19:07
 */
public class DeleteProcessDefinition {

    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //删除流程定义，如果该流程定义已有流程实例启动则删除时出错
        repositoryService.deleteDeployment("1");
        //设置为 true 级联删除流程定义，即使该流程有流程实例启动也可以删除，设置为false则为非级联删除方式
        //repositoryService.deleteDeployment(deploymentId, true);
    }

}
