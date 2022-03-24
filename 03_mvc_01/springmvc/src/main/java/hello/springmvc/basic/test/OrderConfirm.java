package hello.springmvc.basic.test;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class OrderConfirm extends OrderEvent{
    private LocalDateTime confirmTime;
}
