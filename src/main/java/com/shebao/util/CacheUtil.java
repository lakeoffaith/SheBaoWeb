package com.shebao.util;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import com.ijoy.service.ILoginInfoService;
import com.ijoy.service.User;
@Component
public class CacheUtil {
	
	
	@Autowired(required=true)
	protected RedisTemplate<Serializable,Serializable> redisTemplate;
	@Autowired
	protected ILoginInfoService loginInfoService;
	public  Boolean  checkUserIdAndToken(final int userId,final String token){
		//
		System.out.println("----");
		System.out.println(redisTemplate);
		Boolean result=redisTemplate.execute(new RedisCallback<Boolean>(){
			
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				// TODO Auto-generated method stub
				RedisSerializer<Serializable> serializer = (RedisSerializer<Serializable>) redisTemplate.getDefaultSerializer();
				byte[] key=serializer.serialize(userId);
				byte[] value=connection.get(key);
				if(value==null){
					//redis 中不存在 就调用webservice 
					System.out.println("redis 中不存在 就调用webservice");
					User user = loginInfoService.checkToken(token);
					if(user.getId().intValue()==userId){
						//保存在redis中
						System.out.println("保存在redis中");
						connection.set(key, serializer.serialize(token));
						return true;
					}
					return false;
					
				}
				System.out.println("redis 存在对应的userId 和其对应的token");
				String existToken= (String)serializer.deserialize(value);
				//redis 存在对应的userId 和其对应的token
				return existToken.equals(token);
			}
			
		});
	
		return result;
	}
}
