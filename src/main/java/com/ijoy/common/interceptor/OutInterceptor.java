package com.ijoy.common.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class OutInterceptor extends AbstractSoapInterceptor {
	private static String nameURI="shebao"; 
	private String token;
	public OutInterceptor() {
		super(Phase.WRITE);
	}

		
	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public void handleMessage(SoapMessage message) throws Fault {  
		 	SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	        Date date=new Date();  
	        String time =sd.format(date);  
	        String spPassword="wang";  
	        String spName="can";  
	          
	        QName qname=new QName("RequestSOAPHeader");  
	        Document doc=DOMUtils.createDocument();  
	          
	        Element spId=doc.createElement("tns:spId");  
	        spId.setTextContent(spName);  
	        Element spPass=doc.createElement("tns:spPassword");  
	        spPass.setTextContent(spPassword);  
	          
	        Element root=doc.createElementNS(nameURI, "tns:RequestSOAPHeader");  
	        root.appendChild(spId);  
	        root.appendChild(spPass);  
	          
	        SoapHeader head=new SoapHeader(qname,root);  
	        List<Header> headers=message.getHeaders();  
	        headers.add(head);  
	          
    }  

}
