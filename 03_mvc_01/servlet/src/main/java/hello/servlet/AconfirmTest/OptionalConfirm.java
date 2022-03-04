package hello.servlet.AconfirmTest;

import java.util.Optional;

public class OptionalConfirm {
    public static void main(String[] args) {
        Optional<UserDTO> userDTOOptional = Optional.ofNullable(UserDTO.builder().username("kim").build());

        

    }
}
