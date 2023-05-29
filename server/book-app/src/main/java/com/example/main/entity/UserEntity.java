package com.example.main.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users_entity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity  {
  @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private  String firstname;
    private  String lastname;
    private  String email;
    private  String password;
    private  String address;
    @Enumerated(EnumType.STRING)
    private Role role;

}
