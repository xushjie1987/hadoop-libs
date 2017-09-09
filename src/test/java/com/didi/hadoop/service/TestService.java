/**
 * Project Name:hadoop-libs
 * File Name:TestService.java
 * Package Name:com.didi.hadoop.service
 * Date:2017年9月9日下午9:32:45
 * Copyright (c) 2017, All Rights Reserved.
 *
*/
package com.didi.hadoop.service;

import org.apache.hadoop.conf.Configuration;
import org.junit.Test;

/**
 * ClassName:TestService <br/>
 * Function: <br/>
 * Date: 2017年9月9日 下午9:32:45 <br/>
 * 
 * @author xushjie
 * @version
 * @since JDK 1.8
 * @see
 */
public class TestService {
    
    public static class MyService extends AbstractService {
        public MyService(String name) {
            super(name);
        }
    }
    
    @Test
    public void test1() throws Exception {
        MyService service = new MyService("MyService");
        service.registerServiceListener(s -> {
            System.out.println(s.getName() + " listened " + s.getServiceState());
        });
        service.init(new Configuration());
        service.start();
        service.stop();
        service.close();
        // MyService listened INITED
        // MyService listened STARTED
        // MyService listened STOPPED
    }
}
