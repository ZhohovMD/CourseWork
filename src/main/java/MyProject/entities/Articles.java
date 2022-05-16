package MyProject.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.List;

@Accessors(chain = true)
@Entity
@NoArgsConstructor
@Table(name = "articles")
public class Articles {

    @Id
    @Column(name = "id")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Getter
    private Integer artId;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @OneToMany(mappedBy = "artId", cascade = CascadeType.REMOVE)
    private List<Operations> operations;

    @Override
    public String toString() {
        return "Articles{" +
                "id = " + artId +
                ", name = '" + name + '\'' +
                "}";
    }
}
