package com.shebao.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.shebao.service.EhCacheTestService;

@Service
public class EhCacheTestServiceImpl implements EhCacheTestService {

	 @Cacheable(value="cacheTest",key="#param")
	    public String getTimestamp(String param) {
		 	System.out.println("进入");
	        Long timestamp = System.currentTimeMillis();
	        return timestamp.toString();
	    }

}
