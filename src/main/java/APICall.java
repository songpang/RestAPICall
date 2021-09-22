

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


public class APICall {
    static String API_KEY = "KakaoAK e82d57d930376f99466f9b63782be325";

    //x_auth_token: 95b78c2845b701c2166d73af47d3d621
    private void RestCall(String paramUrl){
        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.readValue(data, LocationDto.class);

        try {
            URL url = new URL(paramUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Authorization", API_KEY);
            conn.setDoOutput(true);

            System.out.println("get " + conn.getOutputStream());
            OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream(), StandardCharsets.UTF_8);
//            osw.write(jsonObject.toString());
//            osw.flush();
//            osw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            if (conn.getResponseCode() != 200) {
                System.out.println("Failed: HTTP error code : " + conn.getResponseCode());
                throw new RuntimeException("Failed: HTTP error code : " + conn.getResponseCode());
            } else {
                System.out.println("발송 성공");
            }

            String line = null;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
            conn.disconnect();
        } catch (IOException e) {
            System.out.println("RestCall Fail : " + e.getMessage());
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        APICall apiCall = new APICall();
        ObjectMapper objectMapper = new ObjectMapper();
        String resultJson = objectMapper.writeValueAsString(new LocationDto("hello", 3));
        System.out.println(resultJson);
//        JSONObject commands = new JSONObject();

        String encodingString = "지구를 지키기 위해서 왔어";
        String encodeResult = URLEncoder.encode(encodingString, StandardCharsets.UTF_8);

        String postParams = "src_lang=kr&target_lang=en&query=" + encodeResult;
        String paramUrl = "https://dapi.kakao.com/v2/translation/translate?" + postParams;

        apiCall.RestCall(paramUrl);

    }
}
