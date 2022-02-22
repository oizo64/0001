package Start.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

import java.util.List;

@Entity
@Table
@Data
public class Activity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "activity", cascade = CascadeType.PERSIST)
    @JsonBackReference
    private List<User> users;

}
