package SplitWise.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "`groups`") //Enclosed it in backticks(`) to make spring understand that its a keyword in SQL and we are using it for table creation
public class Group extends BaseModel{
    private String name;
    @ManyToMany
    private List<User> participants;
    @ManyToMany
    private List<User> admins;
    private String description;
    @ManyToOne
    private User createdBy;
    @OneToMany
    private List<Expense> expenses;
}
