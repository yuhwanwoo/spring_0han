package hello.servlet.AconfirmTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalConfirm {
    public static void main(String[] args) {
        Optional<UserDTO> userDTOOptional = Optional.ofNullable(UserDTO.builder().username("kim").id(1L).build());

        Optional<Long> aLong = userDTOOptional.map(UserDTO::getId);

        Optional<String> s = userDTOOptional.map(UserDTO::test);

        System.out.println("aLong = " + aLong);
        System.out.println("s = " + s);

        System.out.println(new UserDTO());

        List<String> strings =
                Arrays.asList("google", "apple", "google", "apple", "samsung");

        Stream<String> stream1 = strings.stream();
        Stream<String> stream2 = stream1.distinct();
        stream2.forEach(System.out::println);
    }
}
