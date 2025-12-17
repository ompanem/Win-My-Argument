package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PaperLoader {
    private String path;

    public PaperLoader(String path)
    {
        this.path = path;
    }

    public ArrayList<Paper> getPapersFromJSON()
    {
        ArrayList<Paper> papers = new ArrayList<>();
        try{
            File file = new File(path);
            ObjectMapper mapper = new ObjectMapper();
            papers = mapper.readValue(file, new TypeReference<ArrayList<Paper>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return papers;
    }
}
