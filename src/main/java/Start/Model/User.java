package Start.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@NamedEntityGraph(
        name = "graph.user.classroom",
        attributeNodes =
                {
                        @NamedAttributeNode(value = "classRoom", subgraph = "classRoom-subgraph"),
                        @NamedAttributeNode(value = "name")
                },
        subgraphs = {
                @NamedSubgraph(name = "classRoom-subgraph",
                        attributeNodes = @NamedAttributeNode("name")
                )
        }
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    private String name;
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Address address;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phone_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Phone phone;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ClassRoom> classRoom;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_activity", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "activity_id"))
    private List<Activity> activity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(password, that.password) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, name);
    }

    public void setClassRoomWithId(List<ClassRoom> classRoomList, User user) {
        classRoomList
                .forEach(classRoom1 -> classRoom1.setUser(user));
        this.classRoom = classRoomList;
    }
}
