package com.liuchen.navite;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * @program: che300WorkStudy
 * @description:
 * @author: lc
 * @date: 2020/6/16
 **/
public class MainTest1 {
    public static void main(String[] args) {
//      读取配置文件，获取 ProcessEngine对象。
        String resource = "activiti.cfg.xml";
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource(resource);
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        String pName = processEngine.getName();
        String ver = ProcessEngine.VERSION;
        System.out.println("ProcessEngine [" + pName + "] Version: [" + ver + "]");

//        因为之前部署过流程图，这里就注销了.

//        //管理流程定义
//        RepositoryService repositoryService = processEngine.getRepositoryService();
//
//        Deployment deployment = repositoryService.createDeployment()
//                                .addClasspathResource("bpmn/hoilday.bpmn")
//                                .addClasspathResource("bpmn/hoilday.png")
//                                //禁止检查格式。bpmn本质就是个xml文件。这里就是禁止检查xml标签。
//                                .disableSchemaValidation()
//                                .deploy();
//        //流程定义。他的底层还是去查那些相关的表的。这就是得到一个service，查数据库。
//        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
//                .deploymentId(deployment.getId()).singleResult();
//        System.out.println(
//                "Found process definition ["
//                        + processDefinition.getName() + "] with id ["
//                        + processDefinition.getId() + "]");

        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService
                .startProcessInstanceByKey("hoilday");

        System.out.println("Onboarding process started with process instance id ["
                + processInstance.getProcessInstanceId()
                + "] key [" + processInstance.getProcessDefinitionKey() + "]");
    }
}
