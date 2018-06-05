package com.imao.demo.ip;

import java.net.InetAddress;

public class TestChangeIp {
	public static void main(String[] args) throws Exception {
		ChangeIP.cutAdsl("宽带连接");
		
		ChangeIP.connAdsl("宽带连接","name","pass");
		
		InetAddress changeAddress = InetAddress.getLocalHost(); 
		String changeIP = changeAddress.getHostAddress(); 
		System.out.println("变化的IP是："+changeIP);
	}
}
