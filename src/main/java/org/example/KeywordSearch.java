package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class KeywordSearch {


    public ArrayList<Paper> search(ArrayList<Paper> papers, String prompt, int n)
    {
        ArrayList<Paper> nBestPapers = new ArrayList<>();
        String[] words = prompt.split("\\W+");
        int [] scores = new int[papers.size()];
        for(int i =0; i<words.length; i++)
        {
            words[i] = words[i].toLowerCase();
        }

        for(Paper paper: papers)
        {
            int score = 0;
            String title = paper.getTitle().toLowerCase().trim();
            String summary = paper.getSummary().toLowerCase().trim();

            for(int i =0; i< words.length; i++)
            {
                if(title.contains(words[i]))
                {
                    score+=2;
                }

                if(summary.contains(words[i]))
                {
                    score+=1;
                }

                paper.setScore(score);
            }
        }

        ArrayList<Paper> sortedByScorePapers = papers.stream()
                .sorted((paper1, paper2) -> Integer.compare(paper2.getScore(), paper1.getScore()))
                .filter(paper -> paper.getScore()>0)
                .collect(Collectors.toCollection(ArrayList::new));


        for(int i =0; i<n; i++)
        {
            if(i+1 > sortedByScorePapers.size())
            {
                break;
            }
            nBestPapers.add(sortedByScorePapers.get(i));
        }


        return nBestPapers;

    }
}
