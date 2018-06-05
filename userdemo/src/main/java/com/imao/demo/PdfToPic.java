package com.imao.demo;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.icepdf.core.pobjects.Document;
import org.icepdf.core.util.GraphicsRenderingHints;
/*
 * pdf 转 图片
 */
public class PdfToPic {
	public static void pdf2Pic(String pdfPath, String path) throws Exception{
		Document document = new Document();
		document.setFile(pdfPath);
		float scale = 2.5f;//缩放比例
		float rotation = 0f;//旋转角度
		        
		for (int i = 0; i < document.getNumberOfPages(); i++) {
			BufferedImage image = (BufferedImage)
			document.getPageImage(i, GraphicsRenderingHints.SCREEN, org.icepdf.core.pobjects.Page.BOUNDARY_CROPBOX, rotation, scale);
			RenderedImage rendImage = image;
			try {
				String imgName = i + ".png";
				System.out.println(imgName);
		    	File file = new File(path + imgName);
		    	ImageIO.write(rendImage, "png", file); 
			} catch (IOException e) {
				e.printStackTrace();
			}
			image.flush();
		}
		document.dispose();
	}
	public static void main(String[] args) throws Exception {
		String filePath = "D:/demo/1/极讯通功能简介--营销助手.pdf";
		pdf2Pic(filePath, "D:/demo/1/");
	}
}
