package com.homesofting.spring.batch;

import java.util.GregorianCalendar;
import java.util.HashMap;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String[] springConfig  = 
    		{	
    			"job-hello-world.xml" 
    		};
     
    	ApplicationContext context = 
    			new ClassPathXmlApplicationContext(springConfig);
     
    	JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
    	Job job = (Job) context.getBean("helloWorldJob");
     
    	try {
     
    		
    		HashMap<String, JobParameter> paramsMap = new HashMap<String, JobParameter>();
    		paramsMap.put("date", new JobParameter(GregorianCalendar.getInstance().getTime()));
			JobExecution execution = jobLauncher.run(job, new JobParameters(paramsMap));
    		System.out.println("Exit Status : " + execution.getStatus());
     
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
     
    	System.out.println("Done");
    }
}
