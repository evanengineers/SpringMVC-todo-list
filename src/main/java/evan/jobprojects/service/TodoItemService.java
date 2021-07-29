package evan.jobprojects.service;

import evan.jobprojects.model.TodoData;
import evan.jobprojects.model.TodoItem;

public interface TodoItemService {

    void addItem(TodoItem toAdd);

    void removeItem(int id);

    TodoItem getItem(int id);

    void updateItem(TodoItem toUpdate);

    TodoData getData();

}
