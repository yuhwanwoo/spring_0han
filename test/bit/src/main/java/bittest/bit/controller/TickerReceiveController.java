package bittest.bit.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Controller
public class TickerReceiveController {

    @Value("${api-key}")
    private String key;

    @RequestMapping("/get-ticker")
    @ResponseBody
    public void receive() throws IOException {
        URL add = new URL("https://api.bithumb.com/info/balance");
        HttpURLConnection con = (HttpURLConnection) add.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty();
    }
}
