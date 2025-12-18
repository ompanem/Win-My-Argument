package org.example;

public class Paper {
    private String title = "";
    private String summary = "";
    private String url = "";
    private String date = "";
    private int score;

    public String getTitle()
    {
        return title;
    }

    public String getSummary()
    {
        return summary;
    }

    public String getUrl()
    {
        return url;
    }

    public String getDate()
    {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public int getScore()
    {
        return score;
    }
    public String toString()
    {
        String retStr = String.format("Title: %s%nSummary: %s%nUri: %s%nDate: %s%n", title, summary, url, date);
        return retStr;
    }
}
