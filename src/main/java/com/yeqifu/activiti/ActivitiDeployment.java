package com.yeqifu.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * 流程定义部署
 * activiti中哪些表中新增了记录？
 * act_re_deployment  新增部署信息
 * act_re_procedef    流程定义的一些信息
 * act_ge_bytearry    流程定义的bpmn文件和png文件
 * @Author: 落亦-
 * @Date: 2020/4/9 9:33
 */
public class ActivitiDeployment {

    public static void main(String[] args) {
        //1.获取ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3.添加相应的资源进行部署
        Deployment deployment = repositoryService.createDeployment().addClasspathResource("diagram/holiday.bpmn").addClasspathResource("diagram/holiday.png").name("请假流程申请").deploy();

        System.out.println(deployment.getName());
        System.out.println(deployment.getId());
    }

}
