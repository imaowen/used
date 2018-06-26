package com.imao.demo.httpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.imao.common.utils.StringUtils;

public class HttpGetTest {
	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpGet httpGet=new HttpGet("http://www.java1234.com/"); 
		CloseableHttpResponse response=httpClient.execute(httpGet);
		HttpEntity entity=response.getEntity();
		String result = EntityUtils.toString(entity, StringUtils.CHARSET_UTF8);
		System.out.println(result);
		
		response.close(); 
		httpClient.close();
	}
}
