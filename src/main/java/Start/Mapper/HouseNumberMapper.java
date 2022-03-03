package Start.Mapper;

import Start.DTOs.HouseNumberDto;
import Start.Model.HouseNumber;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HouseNumberMapper {

    @Mapping(source = "number", target = "number")
    HouseNumber mapToHouseNumber(HouseNumberDto houseNumberDto);
}
