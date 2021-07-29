package evan.jobprojects.service;

import evan.jobprojects.model.TodoData;
import evan.jobprojects.model.TodoItem;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class ToDoItemServiceImpl implements TodoItemService {

    // == Constants ==
    @Getter
    private final TodoData data = new TodoData();

    // == public methods ==
    @Override
    public void addItem(TodoItem toAdd) {
        data.addItem(toAdd);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem toUpdate) {
        data.updateItem(toUpdate);
    }
}
