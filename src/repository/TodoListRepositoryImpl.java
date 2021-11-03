package repository;

import entity.TodoList;

public class TodoListRepositoryImpl implements TodoListRepository{

    public TodoList[] data = new TodoList[10];

    @Override
    public TodoList[] getAll() {
        return data;
    }

    public boolean isFull(){
        var isFull = true;

        for(var i = 0; i < data.length; i++){
            if(data[i] == null){
                isFull = false;
                break;
            }
        }

        return isFull;
    }

    public void resizeIfFull(){

        if(isFull()){
            var temp = data;

            data = new TodoList[data.length * 2];

            for(var i = 0; i < temp.length; i++){
                data[i] = temp[i];
            }
        }
    }

    @Override
    public void add(TodoList todo) {
        resizeIfFull();


        for(var i = 0; i < data.length; i++){
            if(data[i] == null){
                data[i] = todo;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer number) {
        var idx = number - 1;

        if(idx >= data.length ) return false;
        if(data[idx] == null) return false;

        for (var i = idx; i < data.length; i++){
            data[i] = (i != (data.length - 1)) ? data[i + 1] : null ;
        }

        return true;
    }

}
