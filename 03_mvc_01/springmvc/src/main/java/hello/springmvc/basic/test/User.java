package hello.springmvc.basic.test;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {
    private String address;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
