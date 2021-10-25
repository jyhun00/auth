package com.growingmom.project.auth.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authority")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Authority {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "authority_name", length = 50, unique = true)
   private String authorityName;

   @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "authority")
   private List<User> users;

}
