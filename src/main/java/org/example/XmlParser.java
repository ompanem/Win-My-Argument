package org.example;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.StringReader;
import java.util.ArrayList;

public class XmlParser {
    private ArrayList<Paper> papers;

    public XmlParser(){
        papers = new ArrayList<>();
    }
    public void readFile(String text)
    {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        boolean isInEntry = false;

        String title = "";
        String summary = "";
        String uri = "";
        String date = "";
        try{
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new StringReader(text));
            while (reader.hasNext())
            {
                XMLEvent nextEvent = reader.nextEvent();
                if(nextEvent.isStartElement())
                {
                    StartElement startElement = nextEvent.asStartElement();
                    if(startElement.getName().getLocalPart().equals("entry"))
                    {
                        isInEntry = true;
                    }

                    if(isInEntry)
                    {
                        String tag = startElement.getName().getLocalPart();
                        switch (tag)
                        {
                            case "id":
                                uri = reader.getElementText().trim();
                                break;
                            case "title":
                                title = reader.getElementText().trim();
                                break;
                            case "summary":
                                summary = reader.getElementText().trim();
                                break;
                            case "published":
                                date = reader.getElementText().trim();
                                break;
                        }

                    }
                }

                if(nextEvent.isEndElement())
                {

                    EndElement endElement = nextEvent.asEndElement();

                    if(endElement.getName().getLocalPart().equals("entry"))
                    {
                        Paper currentPaper = new Paper();
                        currentPaper.setTitle(title);
                        currentPaper.setSummary(summary);
                        currentPaper.setUrl(uri);
                        currentPaper.setDate(date);
                        papers.add(currentPaper);
                        title = "";
                        summary = "";
                        uri = "";
                        date = "";
                        isInEntry = false;
                    }

                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Paper> getPapers() {
        return papers;
    }
}
