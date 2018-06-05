package com.imao.demo.lucene;

import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
/**
 * 进行搜索 
 * @author lmw
 *
 */
public class Searcher {
	public static void main(String[] args) throws Exception{
		String indexDir="c:\\lucene";
		String words="tomorrow";
		search(indexDir, words);
	}
	/**
	 * 搜索指定字符
	 * @param indexDir
	 * @param words
	 * @throws Exception
	 */
	public static void search(String indexDir, String words) throws Exception{
		Directory dir = FSDirectory.open(Paths.get(indexDir));
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher is=new IndexSearcher(reader);
		Analyzer analyzer=new StandardAnalyzer(); // 标准分词器
		QueryParser parser=new QueryParser("contents", analyzer);
		Query query=parser.parse(words);
		long start=System.currentTimeMillis();
		TopDocs hits=is.search(query, 100);
		long end=System.currentTimeMillis();
		System.out.println("匹配 "+words+" ，总共花费"+(end-start)+"毫秒"+"查询到"+hits.totalHits+"个记录");
		for(ScoreDoc scoreDoc:hits.scoreDocs){
			Document doc=is.doc(scoreDoc.doc);
			System.out.println(doc.get("fullPath"));
		}
		reader.close();
		
	}
}
