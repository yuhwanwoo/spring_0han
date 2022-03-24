package hello.springmvc.basic.test;

import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
public class OrderCancel extends OrderEvent{
    private LocalDateTime cancelTime;
}
