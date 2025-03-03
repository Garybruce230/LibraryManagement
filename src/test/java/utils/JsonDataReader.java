package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonDataReader {
    public static Map<String, Object> readJsonFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File("src/test/resources/DataConfig/testData.txt"), Map.class);
    }
}
