package Start.Mapper;

import Start.DTOs.ClassRoomDto;
import Start.Model.ClassRoom;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassRoomMapper {

    @Mapping(source = "name", target = "name")
    ClassRoom mapToClassRoom(ClassRoomDto classRoomDto);

    List<ClassRoom> mapToClassRoomList(List<ClassRoomDto> classRoomDtoList);

    List<ClassRoomDto> mapToDto(List<ClassRoom> classRoomDtoList);

}
