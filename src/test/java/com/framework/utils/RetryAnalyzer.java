package com.framework.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.framework.configuration.ConfigFile;

import java.util.concurrent.atomic.AtomicInteger;

public class RetryAnalyzer implements IRetryAnalyzer{
    private int retryCount = 0;
    private  static int RETRY_COUNT = Integer.parseInt(ConfigFile.getProperty("retryCount").toString());
    
    AtomicInteger count = new AtomicInteger(RETRY_COUNT);
    
    public boolean isRetryAvailable() {
        return (count.intValue() > 0);
    }

    @Override
    public boolean retry(ITestResult result) {
    	 boolean retry = false;
    	    if (isRetryAvailable()) {
    	        System.out.println("Going to retry test case: " + result.getMethod() + ", " + (RETRY_COUNT - count.intValue() + 1) + " out of " + RETRY_COUNT);
    	        retry = true;
    	        count.decrementAndGet();
    	    }
    	    return retry;
     } 
 } 