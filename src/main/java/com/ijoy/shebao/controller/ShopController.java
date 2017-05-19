package com.ijoy.shebao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ijoy.shebao.model.Shop;

import tk.mybatis.mapper.common.Mapper;

@RestController
public class ShopController {
	/*@RequestMapping(value="/shop/",method=RequestMethod.GET)
	@ResponseBody
	public String listAllShop(){
		System.out.println("进入");
		//List<Shop> list = mapper.select(null);
		 return "nihao"; 
	}*/
	@Autowired
	private Mapper<Shop> mapper;
	@RequestMapping(value="/shop/",method=RequestMethod.GET)
	public ResponseEntity<String> listAllShop(){
		System.out.println("进入");
		//List<Shop> list = mapper.select(null);
		
		 return new ResponseEntity<String>("ni坏", HttpStatus.OK); 
	}
	
	@RequestMapping(value="/shop/{id}",method=RequestMethod.GET)
	public ResponseEntity<Shop> getShop(@PathVariable("id") int id){
			Shop p=new Shop();
			p.setId(new Integer(id));
			p = mapper.selectByPrimaryKey(p);
			if(p==null){
		         return new ResponseEntity<Shop>(HttpStatus.NOT_FOUND); 
			}
		//List<Shop> list = mapper.select(null);
		
		 return new ResponseEntity<Shop>(p, HttpStatus.OK); 
	}
	@RequestMapping(value="/shop/",method=RequestMethod.POST)
	public ResponseEntity<Void> createShop(@RequestBody Shop shop, UriComponentsBuilder ucBuilder){
		System.out.println("进入新建："+shop);
		int insert = mapper.insert(shop);
		if(insert==0){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers=new HttpHeaders();
		headers.setLocation(ucBuilder.path("/shop/{id}").buildAndExpand(insert).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	 @RequestMapping(value = "/shop/{id}", method = RequestMethod.PUT)  
	    public ResponseEntity<Shop> updateShop(@PathVariable("id") long id, @RequestBody Shop shop) {  
	        System.out.println("Updating Shop " + id);  
	           
	        boolean flag = mapper.existsWithPrimaryKey(shop);
	           if(!flag){
	        	   return new ResponseEntity<Shop>(HttpStatus.NOT_FOUND); 
	           }
	           mapper.updateByPrimaryKey(shop);
	        return new ResponseEntity<Shop>(shop, HttpStatus.OK);  
	    }
	 
	 @RequestMapping(value = "/shop/{id}", method = RequestMethod.DELETE)  
	    public ResponseEntity<Shop> deleteShop(@PathVariable("id") int id) {  
	        System.out.println("Fetching & Deleting Shop with id " + id);  
	        Shop p=new Shop();
	        p.setId(new Integer(id));
	        boolean flag = mapper.existsWithPrimaryKey(p);
	        if(!flag){
	        	return new ResponseEntity<Shop>(HttpStatus.NOT_FOUND);  
	        }
	        mapper.deleteByPrimaryKey(p);
	        return new ResponseEntity<Shop>(HttpStatus.NO_CONTENT);  
	    }  
	 
	 @RequestMapping(value = "/shop/", method = RequestMethod.DELETE)  
	    public ResponseEntity<Shop> deleteAllShops() {  
	        System.out.println("Deleting All Shops");  
	   
	        mapper.delete(null); 
	        return new ResponseEntity<Shop>(HttpStatus.NO_CONTENT);  
	    }  
	
	

}
