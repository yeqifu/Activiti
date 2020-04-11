package com.yeqifu.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @Author: 落亦-
 * @Date: 2020/4/10 19:50
 */
public class ActivitiTaskQueryComplete {
    public static void main(String[] args) {
        /*//1.获得processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.获得taskService对象
        TaskService taskService = processEngine.getTaskService();
        //3.查询任务
        Task task = taskService.createTaskQuery().processDefinitionKey("holiday").taskAssignee("李四").singleResult();
        //4.执行任务
        taskService.complete(task.getId());*/


        //1.获得processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.获得taskService对象
        TaskService taskService = processEngine.getTaskService();
        //3.查询任务
        Task task = taskService.createTaskQuery().processDefinitionKey("holiday").taskAssignee("王五").singleResult();
        //4.执行任务
        taskService.complete(task.getId());

    }
}
