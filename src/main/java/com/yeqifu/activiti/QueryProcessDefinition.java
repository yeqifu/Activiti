package com.yeqifu.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * 流程定义的查询
 * @Author: 落亦-
 * @Date: 2020/4/11 18:52
 */
public class QueryProcessDefinition {

    public static void main(String[] args) {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();
        //获得流程定义的查询对象
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        //设置查询条件    根据key，同时根据key的版本号进行降序排序
        List<ProcessDefinition> processDefinitionList = processDefinitionQuery.processDefinitionKey("holiday")
                .orderByProcessDefinitionVersion()
                .desc()
                .list();

        for (ProcessDefinition processDefinition : processDefinitionList) {
            System.out.println("流程定义的ID:"+processDefinition.getId());
            System.out.println("流程定义的名称:"+processDefinition.getName());
            System.out.println("流程定义的key:"+processDefinition.getKey());
            System.out.println("流程定义的版本:"+processDefinition.getVersion());
        }

    }


}
