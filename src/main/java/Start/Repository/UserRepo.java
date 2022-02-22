package Start.Repository;

import Start.Model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = {"name", "address.street", "classRoom.name"})
    @Override
    List<User> findAll();

}
