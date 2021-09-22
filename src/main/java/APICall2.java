import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


public class APICall2 {
    private void RestCall(String paramUrl, String json) {
        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.readValue(data, LocationDto.class);

        try {
            URL url = new URL(paramUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("X-Auth-Token", "c0fa1b22f9175af32578ab7cf213548c");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream(), StandardCharsets.UTF_8);
            osw.write(json);
            osw.flush();
            osw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            if (conn.getResponseCode() != 200) {
                System.out.println("Failed: HTTP error code : " + conn.getResponseCode());
                throw new RuntimeException("Failed: HTTP error code : " + conn.getResponseCode());
            } else {
                System.out.println("발송 성공");
            }

            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            conn.disconnect();
        } catch (IOException e) {
            System.out.println("RestCall Fail : " + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        APICall2 apiCall = new APICall2();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("problem", 1);

        LocationDto locationDto = new LocationDto("Heloo", 2);
        objectMapper.writeValue(new File("./test.json"), jsonMap);
        String jsonResult = objectMapper.writeValueAsString(jsonMap);
//        String jsonResult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonMap);
//        System.out.println(jsonResult);
        System.out.println(jsonResult);

//        String paramUrl = "https://kox947ka1a.execute-api.ap-northeast-2.amazonaws.com/prod/users/start";
//
//        apiCall.RestCall(paramUrl, jsonResult);

        //https://kox947ka1a.execute-api.ap-northeast-2.amazonaws.com/prod/users/

    }
}
