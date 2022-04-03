package hello.springmvc.basic.test;

import lombok.Builder;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Setter
public class UserDto {

    private String address;
    private String name;

    public static UserDto from(User user) {
        return UserDto.builder()
                .address(user.getAddress())
                .name(user.getName())
                .build();
    }
}
