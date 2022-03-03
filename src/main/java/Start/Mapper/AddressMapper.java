package Start.Mapper;

import Start.DTOs.AddressDto;
import Start.Model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "street", target = "street")
    @Mapping(source = "houseNumberDto", target = "houseNumber")
    Address mapToAddress(AddressDto addressDto);
}
