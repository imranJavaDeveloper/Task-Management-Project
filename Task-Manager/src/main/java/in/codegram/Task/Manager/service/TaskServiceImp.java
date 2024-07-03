package in.codegram.Task.Manager.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import in.codegram.Task.Manager.dto.TaskDto;
import in.codegram.Task.Manager.entity.Task;
import in.codegram.Task.Manager.repositroy.TaskRepository;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class TaskServiceImp implements TaskService {

    private TaskRepository taskRepository;
     private ModelMapper modelMapper;
      @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks =  taskRepository.findAll();
        return tasks.stream().map((task)->modelMapper.map(task,TaskDto.class)).collect(Collectors.toList());
    }


    @Override
    public void createTask(TaskDto taskDto) {
        Task task =  modelMapper.map(taskDto,Task.class);
        taskRepository.save(task);
    }

    @Override
    public TaskDto getTaskById(Long id) {
        Task task = taskRepository.findById(id).get();
        TaskDto taskDto = modelMapper.map(task,TaskDto.class);
        return taskDto;
    }

    @Override
    public void updateTask(TaskDto taskDto) {
        taskRepository.save(modelMapper.map(taskDto,Task.class));
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    
}
