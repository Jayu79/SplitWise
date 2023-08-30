package SplitWise.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class ExpensePayingUser extends BaseModel {

    @ManyToOne
    private Expense expense;
    @ManyToOne
    private User user;
    private double amount;

}
