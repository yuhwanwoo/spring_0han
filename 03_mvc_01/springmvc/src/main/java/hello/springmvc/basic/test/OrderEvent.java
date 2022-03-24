package hello.springmvc.basic.test;

import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
public abstract class OrderEvent {
    private Long id;
    private String userName;
    private LocalDateTime orderedTime;
}
