package com.nsu.movie_ticket_booking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id")
    @JsonIgnore
    private Theater theater;

    @JsonManagedReference
    @OneToMany(mappedBy = "screen" ,cascade = CascadeType.ALL)
    private List<Seat>seats=new ArrayList<>();


}
