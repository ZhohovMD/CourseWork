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
@Table(name = "balance")
public class Balance {

    @Id
    @Column(name = "id")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Getter
    private Integer balId;

    @Column(name = "create_date")
    @Getter
    @Setter
    private java.sql.Timestamp createDate;

    @Column(name = "debit")
    @Getter
    @Setter
    private double debit;

    @Column(name = "credit")
    @Getter
    @Setter
    private double credit;

    @Column(name = "amount")
    @Getter
    @Setter
    private double amount;

    @OneToMany(mappedBy = "balId", cascade = CascadeType.REMOVE)
    private List<Operations> operations;

    @Override
    public String toString() {
        return "Balance{" +
                "id = " + balId +
                ", create date = " + createDate.toString() +
                ", debit = " + debit +
                ", credit = " + credit +
                ", amount = " + amount +
                "}";
    }
}
