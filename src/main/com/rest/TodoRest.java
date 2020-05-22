
package rest;


import entity.Todo;
import service.TodoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;



@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoRest {

    @Inject
    TodoService todoService;


    @Path("status")
    @POST
    public Response markAsComplete(@QueryParam("id") Long id) {
        Todo todo = todoService.findToDoById(id);
        todo.setIsCompleted(true);
        todoService.updateTodo(todo);
        return Response.ok(todo).build();

    }

    @Path("new")
    @POST
    public Response createTodo(Todo todo) {

        todoService.createTodo(todo);
        return Response.ok(todo).build();
    }


    @Path("update")
    @PUT
    public Response updateTodo(Todo todo) {

        todoService.updateTodo(todo);
        return Response.ok(todo).build();
    }


    @Path("{id}")
    @GET
    public Todo getTodo(@PathParam("id") Long id) {

        return todoService.findToDoById(id);
    }


    @Path("listall")
    @GET
    public List<Todo> getAllTodos() {

        return todoService.getAllTodos();
    }

    @Path("list")
    @GET
    public List<Todo> getTodos() {

        return todoService.getTodos();
    }

}
