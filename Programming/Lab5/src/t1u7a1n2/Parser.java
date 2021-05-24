package t1u7a1n2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import t1u7a1n2.flat.Flat;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

/**
 * Class that works with json and output
 */
public class Parser {
	public static ObjectMapper objMapper = new ObjectMapper();
	
	public Parser() {
	}
	
	/**
	 * @param json json string
	 * @return CollectionManager instance with fields serialized from json
	 * @throws JsonProcessingException if something got wrong with json
	 */
	public CollectionManager fromJsonToCollectionManager(String json) throws JsonProcessingException, InvalidArgumentsException {
		objMapper.registerModule(new JavaTimeModule());
        objMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        CollectionManager result = objMapper.readValue(json, CollectionManager.class);
        if(result.getList() != null){
            return result;
        }else{
            System.out.println("The file contents isn't valid. The collection will be empty.");
            return new CollectionManager();
        }
	}
	
	/**
	 * @param path path of the file from which json would be read
	 * @return json string from given file
	 * @throws IOException if there is no such file
	 */
	public String fromFileToString(String path) throws IOException {
		StringBuilder resultString = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        String line = br.readLine();
        while (line != null) {
            resultString.append(line);
            line = br.readLine();
        }
        br.close();
        return resultString.toString();
	}
	
    /**
     * Method to write json string to file
     * @param filename the path to which file value have be writen
     * @param str the json string
     * @throws IOException if there is no such file
     */
    public void writeStringToFile(String filename, String str) throws IOException{
            BufferedWriter writer = new BufferedWriter(new PrintWriter(new FileOutputStream(filename)));
            writer.write("");
            writer.write(str);
            writer.close();
    }
    
    /**
     * Method that parses CollectionManager Object to json string
     * @param collectionManager Object to parse
     * @return json string
     * @throws JsonProcessingException if there were some problems with JACKSON library
     */
    public String fromCollectionManagerToJson(CollectionManager collectionManager) throws JsonProcessingException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        objMapper.registerModule(new JavaTimeModule());
        objMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objMapper.setDateFormat(df);
        return objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(collectionManager);
    }
    
    /**
     * Method to parse CollectionManager elements Objects to json string
     * @param collectionManager Object whose elements we need to parse
     * @return json string
     * @throws JsonProcessingException if there were some problems with JACKSON library
     */
    public String fromCollectionManagerToJsonElements(CollectionManager collectionManager) throws JsonProcessingException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        objMapper.registerModule(new JavaTimeModule());
        objMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objMapper.setDateFormat(df);
        StringBuilder resultString = new StringBuilder();
        LinkedList<Flat> list = collectionManager.getList();
        for (int i = 0; i < list.size(); i++) {
            resultString.append("\nElement ").append(i + 1).append(":\n").append(objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list.get(i)));
        }
        return resultString.toString();
    }
    
    /**
     * Method to parse given Flat element to json string
     * @param element Flat object
     * @return json string
     * @throws JsonProcessingException if there were some problems with JACKSON library
     */
    public String fromElementToString(Flat element) throws JsonProcessingException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        objMapper.registerModule(new JavaTimeModule());
        objMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objMapper.setDateFormat(df);
        return objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(element);
    }
}
