package entity;


import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Task must be set")
    @Size(min = 10, message = "Task must me not less than 10 characters")
    private String task;

    @NotEmpty(message = "Due Date must be set")
    @FutureOrPresent(message="Due Date must be present or future")
    @JsonbDateFormat(value ="dd.MM.yyyy")
    private LocalDate dueDate;

    private boolean isCompleted;
    private LocalDate dateCompleted;
    private String dateCreated;

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", dueDate=" + dueDate +
                ", isCompleted=" + isCompleted +
                ", dateCompleted=" + dateCompleted +
                ", dateCreated=" + dateCreated +
                '}';
    }


    @PrePersist
    private void init() {

        setDateCreated(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public LocalDate getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDate dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }


}
