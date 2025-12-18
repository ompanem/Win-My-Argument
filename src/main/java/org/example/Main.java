package org.example;


import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String uri = "https://export.arxiv.org/api/query?search_query=all:electron&start=0&max_results=10";
        HttpActions httpActions = new HttpActions(uri);
        XmlParser parser = new XmlParser();
        parser.readFile(httpActions.getXml());
        ArrayList<Paper> papers = parser.getPapers();
        Scanner sc = new Scanner(System.in);

        JsonWriter writer = new JsonWriter(papers);
        writer.writeToJsonFile();
        PaperLoader loader = new PaperLoader("papers.jsonl");
        papers = loader.getPapersFromJSON();
        KeywordSearch searcher = new KeywordSearch();
        while (true)
        {
            System.out.println("Enter a prompt: ");
            String prompt = sc.nextLine();
            ArrayList<Paper> nBestPapers = searcher.search(papers, prompt, 5);
            for(Paper paper: nBestPapers)
            {
                System.out.println(paper);
                System.out.println(paper.getScore());

            }
            break;

        }


    }




}