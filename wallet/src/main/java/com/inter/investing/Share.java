package com.inter.investing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Share {
    @Id
    @SequenceGenerator(
            name = "share_id_sequence",
            sequenceName = "share_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "share_id_sequence"
    )
    private Integer id;

    private Double price;
    private String currency;
    private LocalDateTime date;

    @ManyToOne
    private Company company;
}
