package in.codegram.Task.Manager.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    

     private Long id;
    private String name;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private String priority;
    private String status;

}
