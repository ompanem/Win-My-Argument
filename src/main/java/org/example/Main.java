package org.example;


import java.io.IOException;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String uri = "https://export.arxiv.org/api/query?search_query=all:electron&start=0&max_results=10";
        HttpActions httpActions = new HttpActions(uri);
        XmlParser parser = new XmlParser();
        parser.readFile(httpActions.getXml());
        ArrayList<Paper> papers = parser.getPapers();


        JsonWriter writer = new JsonWriter(papers);
        writer.writeToJsonFile();
        PaperLoader loader = new PaperLoader("papers.jsonl");
        papers = loader.getPapersFromJSON();
        for(Paper paper: papers)
        {
            System.out.println(paper);
        }


    }


}