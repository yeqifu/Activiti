package com.yeqifu.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * 从数据库中查询出bpmn文件和png图片，并将其存放到  G:\IDEA_workspace\Activiti  目录中
 * @Author: 落亦-
 * @Date: 2020/4/11 20:57
 */
public class QueryBpmnFile {
    public static void main(String[] args) throws IOException {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        //4.设置查询条件
        processDefinitionQuery.processDefinitionKey("holiday");//参数是流程定义的key

        //5.执行查询操作,查询出想要的流程定义
        ProcessDefinition processDefinition = processDefinitionQuery.singleResult();
        //获得流程部署的ID
        String deploymentId = processDefinition.getDeploymentId();
        //通过repositoryService.getResourceAsStream(String s,String s1)读取png以及bpmn信息（输入流）  参数一：流程部署的ID  参数二：资源名称
        InputStream pngInputStream = repositoryService.getResourceAsStream(deploymentId, processDefinition.getDiagramResourceName());
        InputStream bpmnInputStream = repositoryService.getResourceAsStream(deploymentId, processDefinition.getResourceName());
        //构建输出流
        OutputStream pngFileOutputStream = new FileOutputStream("G:\\IDEA_workspace\\Activiti\\"+processDefinition.getDiagramResourceName());
        OutputStream bpmnFileOutputStream = new FileOutputStream("G:\\IDEA_workspace\\Activiti\\"+processDefinition.getResourceName());
        //输入流与输出流的转换
        IOUtils.copy(pngInputStream,pngFileOutputStream);
        IOUtils.copy(bpmnInputStream,bpmnFileOutputStream);
        //关闭流
        bpmnFileOutputStream.close();
        pngFileOutputStream.close();
        bpmnInputStream.close();
        pngInputStream.close();

    }
}
