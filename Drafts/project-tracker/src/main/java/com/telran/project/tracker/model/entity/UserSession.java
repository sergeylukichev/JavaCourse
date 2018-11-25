package com.telran.project.tracker.model.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "USER_SESSION")
public class UserSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SESSION_ID", unique = true)
    private String sessionId;

    @Column(name = "IS_VALID")
    private Boolean isValid;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

}
