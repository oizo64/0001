package Start.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NamedEntityGraph(name = "graph.user.classroom",
        attributeNodes = {@NamedAttributeNode(value = "classRoom", subgraph = "user-classRoom")},
        subgraphs = {
        @NamedSubgraph( name = "user-classRoom",
        attributeNodes = {@NamedAttributeNode("name")})
        }
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "phone_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Phone phone;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private List<ClassRoom> classRoom;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_activity", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "activity_id"))
    private List<Activity> activity;
}
