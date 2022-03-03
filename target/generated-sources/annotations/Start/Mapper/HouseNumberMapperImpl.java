package Start.Mapper;

import Start.DTOs.HouseNumberDto;
import Start.Model.HouseNumber;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-27T22:14:48+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class HouseNumberMapperImpl implements HouseNumberMapper {

    @Override
    public HouseNumber mapToHouseNumber(HouseNumberDto houseNumberDto) {
        if ( houseNumberDto == null ) {
            return null;
        }

        HouseNumber houseNumber = new HouseNumber();

        houseNumber.setNumber( houseNumberDto.getNumber() );

        return houseNumber;
    }
}
