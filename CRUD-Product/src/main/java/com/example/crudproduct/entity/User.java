package com.example.crudproduct.entity;


import com.example.crudproduct.anotation.Column;
import com.example.crudproduct.anotation.Entity;
import com.example.crudproduct.anotation.Id;
import com.example.crudproduct.contant.SqlDataType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity(tablename = "User")
public class User {
    @Id(name = "id")
    private int id;
    @Column(name = "name", dataType = SqlDataType.TEXT)
    private String username;
    @Column(name = "password", dataType = SqlDataType.TEXT)
    private String password;
}