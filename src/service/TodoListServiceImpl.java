package service;

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService{

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository){
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] models = todoListRepository.getAll();

        System.out.println("TODOLIST");

        for(var i = 0; i < models.length; i++){
            var todo = models[i];
            var no = i + 1;

            if(todo != null) System.out.println(no + ". " + todo.getTodo());
        }

    }

    @Override
    public void data(String todo) {

    }

    @Override
    public void removeTodoList(Integer number) {

    }
}
