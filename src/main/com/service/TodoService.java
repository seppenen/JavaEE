package service;
import entity.Todo;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;

@Transactional
public class TodoService {

    @PersistenceContext
    EntityManager entityManager;


    public Todo createTodo(Todo todo) {
        //Persist into db

        entityManager.persist(todo);
        System.out.println(todo.toString());
        return todo;

    }

    public Todo updateTodo(Todo todo) {
        entityManager.merge(todo);
        return todo;
    }


    public Todo findToDoById(Long id) {
        return entityManager.find(Todo.class, id);
    }

    public List<Todo> getTodos() {
        return entityManager.createQuery("SELECT t from Todo t", Todo.class).getResultList();
    }
}