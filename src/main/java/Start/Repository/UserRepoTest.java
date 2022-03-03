package Start.Repository;

import Start.DTOs.UserDtoTest;
import Start.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepoTest extends org.springframework.data.repository.Repository<User, Long> {

    //    @EntityGraph(attributePaths = "address.houseNumber")
    @Query(value = "select distinct new Start.DTOs.UserDtoTest(u.name, u.password) from User u where u.id = ?1 ")
    Optional<UserDtoTest> findById(Long id);
}
