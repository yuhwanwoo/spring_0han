package hello.springmvc.basic.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Objects;


@AllArgsConstructor
@Builder
@Getter
public class User {
    private String address;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        if (user.getAddress().equals(((User) o).getAddress())) {
            return true;
        }

        return Objects.equals(getAddress(), user.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress());
    }
}
