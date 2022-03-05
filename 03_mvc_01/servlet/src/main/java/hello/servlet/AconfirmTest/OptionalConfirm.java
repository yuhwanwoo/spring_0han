package hello.servlet.AconfirmTest;

import java.util.Optional;

public class OptionalConfirm {
    public static void main(String[] args) {
        Optional<UserDTO> userDTOOptional = Optional.ofNullable(UserDTO.builder().username("kim").id(1L).build());

        Optional<Long> aLong = userDTOOptional.map(UserDTO::getId);

        Optional<String> s = userDTOOptional.map(UserDTO::test);

        System.out.println("aLong = " + aLong);
        System.out.println("s = " + s);
    }
}
