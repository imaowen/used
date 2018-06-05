package com.imao.demo.lucene;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * 创建索引
 * @author lmw
 *
 */
public class Writer {

	private static IndexWriter writer; // 写索引实例
	
	public static void main(String[] args) {
		try {
			String indexDir = "c:\\lucene";
			String dataDir = "c:\\data";
			long start=System.currentTimeMillis();
			writer = getWriter(indexDir);
			int count = index(dataDir);
			
			long end=System.currentTimeMillis();
			System.out.println("索引："+count+" 个文件 花费了"+(end-start)+" 毫秒");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取索引实例
	 * @param indexDir 索引存放路径
	 * @return
	 * @throws Exception
	 */
	public static IndexWriter getWriter(String indexDir) throws Exception{
		Directory dir = FSDirectory.open(Paths.get(indexDir));
		Analyzer analyzer = new StandardAnalyzer(); // 标准分词器
		IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
		writer = new IndexWriter(dir, iwc);
		return writer;
	}
	/**
	 * 索引指定目录的所有文件
	 * @param dataDir
	 * @return
	 * @throws Exception
	 */
	public static int index(String dataDir) throws Exception{
		File[] file = new File(dataDir).listFiles();
		for (File f : file) {
			indexFile(f);
		}
		return writer.numDocs();
	}
	/**
	 * 索引指定文件
	 * @param f
	 * @throws Exception
	 */
	public static void indexFile(File f) throws Exception{
		System.out.println("索引文件："+f.getCanonicalPath());
		Document doc = new Document();
		doc.add(new StringField("fileNmae", f.getName(), Field.Store.YES));
		doc.add(new StringField("fullPath", f.getCanonicalPath(), Field.Store.YES));
		doc.add(new TextField("contents", new FileReader(f)));
		writer.addDocument(doc);
	}
	
}
