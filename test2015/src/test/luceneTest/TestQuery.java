package test.luceneTest;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;

public class TestQuery {
	public static void main(String[] args) throws IOException, ParseException {
		Hits hits = null;
		String queryString = "长清名泉游";
		Query query = null;
		IndexSearcher searcher = new IndexSearcher("d://index2");

		Analyzer analyzer = new StandardAnalyzer();
		try {
			QueryParser qp = new QueryParser("body", analyzer);
			query = qp.parse(queryString);
		} catch (ParseException e) {
		}
		if (searcher != null) {
			hits = searcher.search(query);
			if (hits.length() > 0) {
				System.out.println(" 找到: " + hits.length() + "  个结果! ");
				for(int i=0;i<hits.length();i++){
					System.out.println(hits.doc(i));
					
				}
			}else{
				System.out.println("无！");
			}
		}
	}

}