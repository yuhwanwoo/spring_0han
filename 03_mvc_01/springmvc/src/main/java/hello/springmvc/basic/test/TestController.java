package hello.springmvc.basic.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class TestController {

    @GetMapping("/cancel")
    public OrderCancel getOrderCancel() {
        OrderCancel orderCancel = OrderCancel.builder()
                .cancelTime(LocalDateTime.now())
                .build();

        return orderCancel;
    }
}
