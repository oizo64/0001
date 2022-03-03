package Start.DTOs;

import lombok.Data;

import java.util.Objects;

@Data
public class UserDtoTest {
    private String password;
    private String name;

    public UserDtoTest(String password, String name) {
        this.password = password;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDtoTest that = (UserDtoTest) o;
        return Objects.equals(password, that.password) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, name);
    }
}
