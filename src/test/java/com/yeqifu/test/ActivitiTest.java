package com.yeqifu.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

/**
 * @Author: 落亦-
 * @Date: 2020/4/7 23:23
 */
public class ActivitiTest {

    /**
     * 测试activiti25张表的生成
     */
    @Test
    public void testGenerationTable(){
        //1.创建ProcessEngineConfiguration对象   第一个参数：配置文件的名称  第二个参数是processEngineConfiguration的Bean的id
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        //2.创建ProcesEngine对象
        ProcessEngine processEngine = configuration.buildProcessEngine();
        //3.输出processEngine对象
        System.out.println(processEngine);
    }

}
