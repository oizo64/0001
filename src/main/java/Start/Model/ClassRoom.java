package Start.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table
@Data
public class ClassRoom {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @JsonBackReference
    private User user;

}
