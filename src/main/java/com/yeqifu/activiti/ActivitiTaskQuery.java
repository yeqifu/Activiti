package com.yeqifu.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 删除已经部署的流程定义
 * 背后影响的表：
 *      act_ge_bytearray
 *      act_re_deployment
 *      act_re_procdef
 * @Author: 落亦-
 * @Date: 2020/4/9 19:42
 */
public class ActivitiTaskQuery {

    public static void main(String[] args) {
        //1.获取processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.获得taskService对象
        TaskService taskService = processEngine.getTaskService();
        //3.根据流程定义的key，负责人assignee来实现对当前用户的任务列表查询
        List<Task> taskList = taskService.createTaskQuery().processDefinitionKey("holiday").taskAssignee("张三").list();
        //4.任务列表的展示
        for (Task task : taskList) {
            System.out.println("流程实例ID："+task.getProcessInstanceId());
            System.out.println("任务ID："+task.getId());
            System.out.println("任务负责人："+task.getAssignee());
            System.out.println("任务名称："+task.getName());
        }

    }

}
