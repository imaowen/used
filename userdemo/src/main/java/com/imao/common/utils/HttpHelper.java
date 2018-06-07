package com.imao.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * 模拟请求
 */
public class HttpHelper{
	
	private static String encoding = "UTF-8";
	/**
	 * HTTP GET 
	 * 
	 * @param strURL
	 * @return
	 */
	public static String get(String strURL){
		HttpURLConnection urlConn = null;
		InputStream in = null;
		StringBuffer sb = new StringBuffer();
		try{
			URL url = new URL(strURL);
			urlConn = (HttpURLConnection) url.openConnection();
			urlConn.setDoInput(true);
			urlConn.setDoOutput(true);
			urlConn.setRequestMethod("GET");
			urlConn.setConnectTimeout(15000);
			urlConn.setReadTimeout(30000);
			urlConn.connect();

			in = urlConn.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(in, encoding));
			String line = rd.readLine();
			while (line != null)
			{
				line = line.trim();

				if (!line.equals(""))
					sb.append(line);
				line = rd.readLine();
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (in != null)
				try
				{
					in.close();
				}
				catch (IOException e)
				{
				}

			if (urlConn != null)
			{
				urlConn.disconnect();
			}
		}

		return sb.toString();
	}

	/**
	 * HTTP POST 
	 * 
	 * @param strURL
	 * @return
	 */
	public static String post(String strURL, String strPostData){
		HttpURLConnection urlConn = null;
		InputStream in = null;
		StringBuffer sb = new StringBuffer();
		try{
			URL url = new URL(strURL);

			urlConn = (HttpURLConnection) url.openConnection();
			urlConn.setDoOutput(true);
			urlConn.setRequestMethod("POST");

			OutputStreamWriter out = new OutputStreamWriter(urlConn.getOutputStream(), encoding);
			out.write(strPostData);
			out.flush();
			out.close();

			in = urlConn.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(in, encoding));
			String line = rd.readLine();
			while (line != null)
			{
				line = line.trim();
				if (!line.equals(""))
					sb.append(line);
				line = rd.readLine();
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (in != null)
				try
				{
					in.close();
				}
				catch (IOException e)
				{
				}

			if (urlConn != null)
			{
				urlConn.disconnect();
			}
		}

		return sb.toString();
	}
}
