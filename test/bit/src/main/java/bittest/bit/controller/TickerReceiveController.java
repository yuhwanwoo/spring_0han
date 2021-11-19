package bittest.bit.controller;

import bittest.bit.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

@Controller
@RequiredArgsConstructor
public class TickerReceiveController {

    @Value("${conKey}")
    private String conKey;
    @Value("${secKey}")
    private String secKey;

    @Value("${client_id}")
    private String clientId;
    @Value("${client_sec}")
    private String clientSecret;

    @RequestMapping("/get-ticker")
    @ResponseBody
    public String getTicker() throws IOException {
        URL add = new URL("https://api.bithumb.com/public/ticker/BTC_KRW");
        HttpURLConnection con = (HttpURLConnection) add.openConnection();
        con.setRequestMethod("GET");
        con.setDoOutput(true);
        OutputStream out = con.getOutputStream();
        DataOutputStream dataSend = new DataOutputStream(out);

        dataSend.close();

        int res = con.getResponseCode();
        InputStream receive;

        if(res == 200){
            receive = con.getInputStream();
        }else {
            receive = con.getErrorStream();
        }
        InputStreamReader reader = new InputStreamReader(receive);
        BufferedReader changer = new BufferedReader(reader);
        return changer.readLine();
    }

    @RequestMapping(value = "/order", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public void receive() throws IOException {
        URL add = new URL("https://api.bithumb.com/public/orderbook/BTC_KRW");
        HttpURLConnection con = (HttpURLConnection) add.openConnection();
        con.setRequestMethod("GET");
//        con.setRequestProperty("count", "1");
//        con.setRequestProperty("secretKey", secKey);
        con.setDoOutput(true);
        OutputStream out = con.getOutputStream();
        DataOutputStream dataSend = new DataOutputStream(out);
//        dataSend.writeBytes("&apiKey=" + conKey + "&secretKey=" + secKey);
//        dataSend.writeBytes("&count=1");
        dataSend.close();

        int res = con.getResponseCode();
        InputStream receive;

        if(res == 200){
            System.out.println("suc");
            receive = con.getInputStream();
        }else {
            System.out.println("fail");
            receive = con.getErrorStream();
        }
        InputStreamReader reader = new InputStreamReader(receive);
        BufferedReader changer = new BufferedReader(reader);
        System.out.println(changer.readLine());
    }


    @RequestMapping(value = "/get-papa", method = RequestMethod.GET)
    @ResponseBody
    public void getPapa() throws IOException {

//        String clientId = "${client_id}";//애플리케이션 클라이언트 아이디값";
//        String clientSecret = "${client_sec}";//애플리케이션 클라이언트 시크릿값";
        System.out.println(clientId);
        System.out.println(clientSecret);
        try {
            String text = URLEncoder.encode("안녕하세요. 오늘 기분은 어떻습니까?", "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            // post request
            String postParams = "source=ko&target=en&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            System.out.println(responseCode);
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @RequestMapping(value = "/get-movies", method = RequestMethod.GET)
    @ResponseBody
    public String getMovies() throws IOException {

//        String clientId = "${client_id}";//애플리케이션 클라이언트 아이디값";
//        String clientSecret = "${client_sec}";//애플리케이션 클라이언트 시크릿값";
        System.out.println(clientId);
        System.out.println(clientSecret);
        try {
            String text = URLEncoder.encode("한국", "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/search/movie.json?query=" + text;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            int responseCode = con.getResponseCode();
            System.out.println(responseCode);
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
            return response.toString();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }


    private final PersonService personService;

    @GetMapping("/add-board")
    public String create() {
        personService.addPet(1L, "pup");

        return "redirect:/";
    }

    // https://api.ncloud-docs.com/docs/ai-naver-mapsgeocoding
    @RequestMapping(value = "/get-geo", method = RequestMethod.GET)
    @ResponseBody
    public String getGeo() throws IOException {

//        String clientId = "${client_id}";//애플리케이션 클라이언트 아이디값";
//        String clientSecret = "${client_sec}";//애플리케이션 클라이언트 시크릿값";
        System.out.println(clientId);
        System.out.println(clientSecret);
        try {
            String text = URLEncoder.encode("한국", "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/search/movie.json?query=" + text;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            int responseCode = con.getResponseCode();
            System.out.println(responseCode);
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
            return response.toString();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }
}
