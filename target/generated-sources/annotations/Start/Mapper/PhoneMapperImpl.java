package Start.Mapper;

import Start.DTOs.PhoneDto;
import Start.Model.Phone;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-27T22:14:48+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class PhoneMapperImpl implements PhoneMapper {

    @Override
    public Phone mapToPhone(PhoneDto phoneDto) {
        if ( phoneDto == null ) {
            return null;
        }

        Phone phone = new Phone();

        phone.setNumber( phoneDto.getNumber() );

        return phone;
    }

    @Override
    public PhoneDto mapToPhoneDto(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDto phoneDto = new PhoneDto();

        phoneDto.setNumber( phone.getNumber() );

        return phoneDto;
    }
}
