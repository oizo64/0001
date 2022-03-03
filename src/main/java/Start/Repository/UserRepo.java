package Start.Repository;

import Start.Model.User;
import liquibase.pro.packaged.E;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = {"name", "address.street", "classRoom.name"})
    @Override
    List<User> findAll();

    @EntityGraph(attributePaths = "address.houseNumber")
    Optional<User> findById(Long id);

    @EntityGraph(attributePaths = {"classRoom"}, type= EntityGraph.EntityGraphType.LOAD)
//    @EntityGraph(value = "graph.user.classroom", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT u FROM User u WHERE u.id= ?1")
    User findBy(Long id);
}
