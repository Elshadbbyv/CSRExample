package csr.example.csrexample.model;

import csr.example.csrexample.dao.entity.CardEntity;
import csr.example.csrexample.dao.entity.EmployeeEntity;
import csr.example.csrexample.dao.entity.ImageEntity;
import csr.example.csrexample.dao.entity.PersonEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private String name;


    private String surname;


    private int age;


    private PersonEntity.Gender gender;


    private CardEntity card;


    private List<ImageEntity> images;


    private List<EmployeeEntity> employees;


    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    enum Gender {
        MALE, FEMALE
    }
}
