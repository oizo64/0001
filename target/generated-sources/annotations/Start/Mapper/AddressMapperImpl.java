package Start.Mapper;

import Start.DTOs.AddressDto;
import Start.DTOs.HouseNumberDto;
import Start.Model.Address;
import Start.Model.HouseNumber;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-27T22:14:48+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address mapToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setStreet( addressDto.getStreet() );
        address.setHouseNumber( houseNumberDtoToHouseNumber( addressDto.getHouseNumberDto() ) );

        return address;
    }

    protected HouseNumber houseNumberDtoToHouseNumber(HouseNumberDto houseNumberDto) {
        if ( houseNumberDto == null ) {
            return null;
        }

        HouseNumber houseNumber = new HouseNumber();

        houseNumber.setNumber( houseNumberDto.getNumber() );

        return houseNumber;
    }
}
