package com.shebao.minSys.util.api;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.shebao.model.Info;
import com.shebao.model.Store;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DataUtil {

	public static  List list(String string) throws Exception{
		String content = httpGet(string);
		ObjectMapper mapper = new ObjectMapper(); // 只需要一个mapper就可以实现
		  Result result = mapper.readValue(content, Result.class);
		  return result.getTngou();
		 
	}

	private static String httpGet(String url) throws Exception {
		 OkHttpClient httpClient = new OkHttpClient();
	        Request request = new Request.Builder()
	                .url(url)
	                .build();
	        Response response = httpClient.newCall(request).execute();
	        return response.body().string(); // 返回的是string 类型，json的mapper可以直接处理
	}
	  

	public static class Result{
		private Boolean status;
		private int total;
		private List<Info> tngou;
		public Boolean getStatus() {
			return status;
		}
		public void setStatus(Boolean status) {
			this.status = status;
		}
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
		public List<Info> getTngou() {
			return tngou;
		}
		public void setTngou(List<Info> tngou) {
			this.tngou = tngou;
		}
		
		
	}
}
