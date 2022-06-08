package com.inter.investing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShareTransaction{
    @Id
    @SequenceGenerator(
            name = "share_transaction_id_sequence",
            sequenceName = "share_transaction_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "share_transaction_id_sequence"
    )
    private Integer id;
    @OneToOne
    @JoinColumn(name = "share_id")
    private Share share;
    private Integer amount;
    private Boolean isBuying;
}
