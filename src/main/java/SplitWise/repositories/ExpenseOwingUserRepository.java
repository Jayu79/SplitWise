package SplitWise.repositories;

import SplitWise.models.Expense;
import SplitWise.models.ExpenseOwingUser;
import SplitWise.models.ExpensePayingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseOwingUserRepository extends JpaRepository<ExpenseOwingUser,Long> {
    List<ExpenseOwingUser> findAllByExpense(Expense expense);

}
