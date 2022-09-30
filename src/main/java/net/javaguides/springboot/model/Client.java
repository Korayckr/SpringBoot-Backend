package net.javaguides.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "location_title")
    private String locationTitle;

    @Column(name = "status")
    private boolean status;

    @JsonFormat(pattern ="dd-MM-yyyy")
    private String createDate;

    @Column(name = "create_user")
    private String createUser;

}
