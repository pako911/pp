package com.mycompany.pp_lab5;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.xml.stream.XMLStreamException;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.store.SimpleFSDirectory;

/**
 *
 * @author Paweł Korczak
 */
public class Main {

    public static void main(String[] args) throws IOException, ParseException{
       
//        Directory index = new RAMDirectory();
//        IndexWriterConfig config = new IndexWriterConfig(analyzer);
//        IndexWriter w = new IndexWriter(index, config);
//        addDoc(w, "Lucene in Action", "193398817");
//        addDoc(w, "Lucene for Dummies", "55320055Z");
//        addDoc(w, "Managing Gigabytes", "55063554A");
//        addDoc(w, "The Art of Computer Science", "9900333X");
//        w.close();
        
        
        StandardAnalyzer analyzer = new StandardAnalyzer();
        Directory dir = new SimpleFSDirectory(Paths.get("data"));
        IndexWriterConfig iwConfig = new IndexWriterConfig(analyzer);
        IndexWriter writer = new IndexWriter(dir, iwConfig);
        
        try (ItemProvider provider = new ItemProvider("items.xml")) {
            while (provider.hasNext()) {
                Item item = provider.next();
                Document document = new Document();
                
                document.add(new TextField("name", item.getName(), Field.Store.YES));
                document.add(new TextField("description", item.getDescription(), Field.Store.YES));
                document.add(new StringField("id", Integer.toString(item.getId()), Field.Store.YES));
                document.add(new StringField("price", Float.toString(item.getPrice()), Field.Store.YES));
                
                if(item.getCategory() != null)
                    document.add(new TextField("category", item.getCategory(), Field.Store.YES));
                  
                if(!DirectoryReader.indexExists(dir))
                    writer.addDocument(document);
            }
        } catch (XMLStreamException | IOException ex) {     
            ex.printStackTrace();
        } 
        writer.close();
        
        System.out.print("Podaj fraze którą chcesz wyszukać: ");
        Scanner userInput = new Scanner(System.in);
        String querystr = userInput.nextLine();
        Query q = new QueryParser("name", analyzer).parse(querystr);
        
        int hitsPerPage = 10;
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs docs = searcher.search(q, hitsPerPage);
        ScoreDoc[] hits = docs.scoreDocs;

        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i+1) + ". " + d.get("id") + "\t" + d.get("name"));
        }
    }
    
    private static void addDoc(IndexWriter w, String title, String isbn) 
    throws IOException{
            Document doc = new Document();
            doc.add(new TextField("title", title, Field.Store.YES));
            doc.add(new StringField("isbn", isbn, Field.Store.YES));
            w.addDocument(doc);
    }

    
}
