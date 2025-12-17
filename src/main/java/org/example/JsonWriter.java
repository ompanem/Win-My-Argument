    package org.example;

    import com.fasterxml.jackson.core.JsonFactory;
    import com.fasterxml.jackson.databind.ObjectMapper;
    import com.fasterxml.jackson.databind.SerializationFeature;

    import java.io.File;
    import java.io.IOException;
    import java.util.ArrayList;

    public class JsonWriter {
        private ArrayList<Paper> papers;

        public JsonWriter(ArrayList<Paper> papers)
        {
            this.papers = papers;
        }
        public void writeToJsonFile()
        {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT); //basically makes the json file look nice and not all on one line
            try{
                File file =  new File("papers.jsonl");

                mapper.writeValue(file, papers);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
