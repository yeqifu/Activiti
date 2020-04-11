package com.yeqifu.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;

/**
 * 处理当前用户的任务
 * 背后操作的表：
 *      act_hi_actinst
 *      act_hi_identitylink
 *      act_hi_taskinst
 *      act_ru_execution
 *      act_ru_identitylink
 *      act_ru_task
 * @Author: 落亦-
 * @Date: 2020/4/10 19:06
 */
public class ActivitiCompleteTask {
    public static void main(String[] args) {
        //1.获取processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.获取taskService
        TaskService taskService = processEngine.getTaskService();
        //3.处理任务，结合当前用户任务的id
        taskService.complete("2505");
    }
}
