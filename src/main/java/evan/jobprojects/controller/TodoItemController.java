package evan.jobprojects.controller;

import evan.jobprojects.model.TodoData;
import evan.jobprojects.model.TodoItem;
import evan.jobprojects.service.TodoItemService;
import evan.jobprojects.util.AttributeNames;
import evan.jobprojects.util.Mappings;
import evan.jobprojects.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class TodoItemController {

    // == constants ==
    private final TodoItemService todoItemService;

    // == constructors ==
    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // == model attribute ==
    @ModelAttribute
    public TodoData todoData() {
        return todoItemService.getData();
    }

    // == handler methods ==
    // http://localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }

    @PostMapping(Mappings.Add_Item)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        return "redirect:/" + Mappings.ITEMS;
    }
}
