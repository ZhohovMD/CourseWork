package MyProject.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Accessors(chain = true)
@Entity
@NoArgsConstructor
@Table(name = "operations")
public class Operations {

    @Id
    @Column(name = "id")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Getter
    private Integer id;

    @Column(name = "article_id")
    @Getter
    @Setter
    private Integer article_id;

    @Column(name = "debit")
    @Getter
    @Setter
    private double debit;

    @Column(name = "credit")
    @Getter
    @Setter
    private double credit;

    @Column(name = "create_date")
    @Getter
    @Setter
    private java.sql.Timestamp createDate;

    @Column(name = "balance_id")
    @Getter
    @Setter
    private Integer balance_id;

    @ManyToOne
    @JoinColumn(name = "article_id", insertable = false, updatable = false)
    private Articles artId;

    @ManyToOne
    @JoinColumn(name = "balance_id", insertable = false, updatable = false)
    private Balance balId;

    @Override
    public String toString() {
        return "Operations{" +
                "id = " + id +
                ", article_id = " + article_id +
                ", debit = " + debit +
                ", credit = " + credit +
                ", create date = " + createDate.toString() +
                ", balance_id = " + balance_id +
                "}";
    }
}
