package rest;



import entity.Todo;
import service.TodoService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoRest  {

@Inject
    TodoService todoservice;

@Path("new")
@POST
public Response createTodo(Todo todo){

todoservice.createTodo(todo);
return Response.ok(todo).build();

}


}
