package Start.Repository;

import Start.Model.HouseNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseNumberRepo extends JpaRepository<HouseNumber, Long> {
}
