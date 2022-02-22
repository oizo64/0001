package Start.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_number_id")
    @JsonBackReference
    private HouseNumber houseNumber;
}
