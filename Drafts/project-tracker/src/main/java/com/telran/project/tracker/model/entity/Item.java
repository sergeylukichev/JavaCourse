package com.telran.project.tracker.model.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "ITEM")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "ITEM_TYPE_ID")
    @Convert(converter = ItemTypeConverter.class)
    private ItemType itemType;

    @Column(name = "ITEM_STATUS_ID")
    @Convert(converter = ItemStatusConverter.class)
    private ItemStatus itemStatus;

    @JoinColumn(name = "USER_ID")
    @ManyToOne
    private User user;

    @CreationTimestamp
    private Date createdDate;


}
