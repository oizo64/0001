package Start.Mapper;

import Start.DTOs.ClassRoomDto;
import Start.Model.ClassRoom;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-27T22:14:48+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class ClassRoomMapperImpl implements ClassRoomMapper {

    @Override
    public ClassRoom mapToClassRoom(ClassRoomDto classRoomDto) {
        if ( classRoomDto == null ) {
            return null;
        }

        ClassRoom classRoom = new ClassRoom();

        classRoom.setName( classRoomDto.getName() );

        return classRoom;
    }

    @Override
    public List<ClassRoom> mapToClassRoomList(List<ClassRoomDto> classRoomDtoList) {
        if ( classRoomDtoList == null ) {
            return null;
        }

        List<ClassRoom> list = new ArrayList<ClassRoom>( classRoomDtoList.size() );
        for ( ClassRoomDto classRoomDto : classRoomDtoList ) {
            list.add( mapToClassRoom( classRoomDto ) );
        }

        return list;
    }

    @Override
    public List<ClassRoomDto> mapToDto(List<ClassRoom> classRoomDtoList) {
        if ( classRoomDtoList == null ) {
            return null;
        }

        List<ClassRoomDto> list = new ArrayList<ClassRoomDto>( classRoomDtoList.size() );
        for ( ClassRoom classRoom : classRoomDtoList ) {
            list.add( classRoomToClassRoomDto( classRoom ) );
        }

        return list;
    }

    protected ClassRoomDto classRoomToClassRoomDto(ClassRoom classRoom) {
        if ( classRoom == null ) {
            return null;
        }

        ClassRoomDto classRoomDto = new ClassRoomDto();

        classRoomDto.setName( classRoom.getName() );

        return classRoomDto;
    }
}
