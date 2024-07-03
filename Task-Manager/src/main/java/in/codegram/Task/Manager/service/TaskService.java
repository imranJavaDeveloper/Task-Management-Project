package in.codegram.Task.Manager.service;


import java.util.List;
import in.codegram.Task.Manager.dto.TaskDto;

public interface TaskService {
    
    List<TaskDto> getAllTasks();
    void createTask(TaskDto taskDto);
    TaskDto getTaskById(Long id);
    void updateTask(TaskDto taskDto);
    void deleteTask(Long id);
}
