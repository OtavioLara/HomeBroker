package com.inter.investing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Wallet {
    @Id
    @SequenceGenerator(
            name = "wallet_id_sequence",
            sequenceName = "wallet_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "wallet_id_sequence"
    )
    private Integer id;

    private Integer userId;

    @OneToMany
    private Set<ShareTransaction> shareTransactions;
}
