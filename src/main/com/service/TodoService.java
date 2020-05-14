package service;


import entity.Todo;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import javax.ws.rs.core.Application;
import java.util.List;

@Transactional
public class TodoService {

    EntityManager entityManager;
    public Todo createTodo(Todo todo){
        entityManager.persist(todo);
        return todo;
    }


    public Todo updateTodo(Todo todo){
        entityManager.merge(todo);
        return todo;
    }

    public Todo findTodoById(Long id){

        return entityManager.find(Todo.class, id);
    }

    public List <Todo> getTodos(){

        return entityManager.createQuery("SELECT T from Todo T",Todo.class).getResultList();
    }

}
