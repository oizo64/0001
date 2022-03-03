package Start.Mapper;

import Start.DTOs.PhoneDto;
import Start.Model.Phone;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PhoneMapper {

    @Mapping(source = "number", target = "number")
    Phone mapToPhone(PhoneDto phoneDto);

    @InheritInverseConfiguration(name = "mapToPhone")
    PhoneDto mapToPhoneDto(Phone phone);
}
