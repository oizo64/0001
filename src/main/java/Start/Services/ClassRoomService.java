package Start.Services;

import Start.DTOs.ClassRoomDto;
import Start.Mapper.ClassRoomMapper;
import Start.Mapper.ObjectMapper;
import Start.Repository.ClassRoomRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record ClassRoomService(ClassRoomRepo classRoomRepo, ClassRoomMapper classRoomMapper,
                               ObjectMapper objectMapper) {

    public List<ClassRoomDto> getAllClassRoom() {
        return classRoomMapper.mapToDto(classRoomRepo.findAll());
    }
}
