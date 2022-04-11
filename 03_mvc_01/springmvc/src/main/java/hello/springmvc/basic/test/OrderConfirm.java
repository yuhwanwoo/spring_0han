package hello.springmvc.basic.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
public class OrderConfirm extends OrderEvent{
    private LocalDateTime confirmTime;
}
