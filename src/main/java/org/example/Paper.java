package org.example;

public class Paper {
    private String title;
    private String summary;
    private String url;
    private String date;
    public Paper(String title, String summary, String url, String date)
    {
        this.title = title;
        this.summary = summary;
        this.url = url;
        this.date = date;
    }

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
}
