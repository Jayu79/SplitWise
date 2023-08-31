package SplitWise.repositories;

import SplitWise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);  //This will save the user if it is a new user or will update the user if the user already exists



}
