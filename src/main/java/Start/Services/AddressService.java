package Start.Services;

import Start.Repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public record AddressService(AddressRepo addressRepo) {
    @Autowired
    public AddressService {
    }
}
