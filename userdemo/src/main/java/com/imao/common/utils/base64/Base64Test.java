package com.imao.common.utils.base64;

public class Base64Test {

	public static void main(String[] args) {
		 String key = "szjiayingyijiang";	
		 TEACoding tea = new TEACoding(key.getBytes());
		
		 String str1 = "E57B7A5D7C18F6908E2CE6C3C70DA9E1";	
		 String code1 = tea.encode2HexStr(str1.getBytes());
		 System.out.println(code1);
		 System.out.println(code1.length());
		 System.out.println(new String(tea.decodeFromHexStr("E57B7A5D7C18F6908E2CE6C3C70DA9E1")));
	}
}
