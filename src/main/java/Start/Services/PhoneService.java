package Start.Services;

import Start.Repository.PhoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public record PhoneService(PhoneRepo phoneRepo) {
    @Autowired
    public PhoneService {
    }
}
