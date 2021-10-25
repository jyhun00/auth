package com.growingmom.project.auth.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(value={AuditingEntityListener.class})
@ToString
public class User extends BaseEntity {

   @Id
   @Column(name = "user_no")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long userNo;

   @Column(name = "email", length = 50, unique = true)
   private String email;

   @Column(name = "password", length = 100)
   private String password;

   @Column(name = "name", length = 50)
   private String name;


   @Column(name = "nickname", length = 50)
   private String nickname;


   @Column(name = "activated")
   private Boolean activated;

   @Column
   private Integer age;

   @ManyToOne
   @JoinColumn(name="authority_id")
   private Authority authority;
}
