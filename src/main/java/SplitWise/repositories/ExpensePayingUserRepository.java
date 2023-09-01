package SplitWise.repositories;

import SplitWise.models.Expense;
import SplitWise.models.ExpensePayingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExpensePayingUserRepository extends JpaRepository<ExpensePayingUser,Long> {

    List<ExpensePayingUser> findAllByExpense(Expense expense);
}
