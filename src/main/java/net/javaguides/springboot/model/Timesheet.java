package net.javaguides.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "timesheet")
    public class Timesheet {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "user_id")
        private String userId;

        @Column(name = "customer_id")
        private String customerId;

        @JsonFormat(pattern ="dd-MM-yyyy")
        private Date  timesheetDate;

        @Column(name = "duration")
        private Number duration;

        @Column(name = "location")
        private String location;

        @Column(name = "task_id")
        private Long taskId;

        @Column(name = "description")
        private String description;

        @DateTimeFormat(pattern = "dd-MM-yyyy")
        private LocalDate createDate;
}
