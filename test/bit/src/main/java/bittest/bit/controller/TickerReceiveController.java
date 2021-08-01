package bittest.bit.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Controller
public class TickerReceiveController {

    @Value("${conKey}")
    private String conKey;
    @Value("${secKey}")
    private String secKey;

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
}
