import java.io.File;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {
    private final ObjectMapper mapper;
    private List<Object> list;

    public JsonParser() {
        mapper = new ObjectMapper();
    }

    @SuppressWarnings("unchecked")
    public void parseJson() throws IOException {
        File json = new File("./test.json");
        Map<String, List<Object>> result = mapper.readValue(json, Map.class);
        list = result.get("0");

        for (Object info : list) {
			System.out.println(info);
            LocationInfo2 EST = mapper.convertValue(info, LocationInfo2.class);
        }

    }


	public static void main(String[] agrs) throws IOException {
		JsonParser jp = new JsonParser();

		jp.parseJson();
	}
}
