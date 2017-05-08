package com.shebao.minSys.util.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class ImageUtil {

	public static void down(String downImgUrl, String path) {
		InputStream  is=null;
		OutputStream os=null;
			try {
				URL url=new URL(downImgUrl);
				URLConnection openConnection = url.openConnection();
				openConnection.setConnectTimeout(5000);
				 is= openConnection.getInputStream();
				byte[] bs=new byte[1024];
				int len;
				File sf=new File(path);
				if(!sf.getParentFile().exists()){
					sf.getParentFile().mkdirs();
				}
				os=new FileOutputStream(sf);
				while((len=is.read(bs))!=-1){
					os.write(bs);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(os!=null)
					try {
						os.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if(is!=null)
					try {
						is.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
	}
	
}
