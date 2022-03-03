package Start.Repository;

import Start.DTOs.ClassRoomDto;
import Start.DTOs.UserDtoTest;
import Start.Model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassRoomRepo extends JpaRepository<ClassRoom, Long> {



}
