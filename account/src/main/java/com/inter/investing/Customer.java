package com.inter.investing;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
        @Id
        @SequenceGenerator(
                name = "customer_id_sequence",
                sequenceName = "customer_id_sequence"
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "customer_id_sequence"
        )
        private Integer id;

        private String name;
        private String cpf;
        private String email;
//        private List<Company> companies;

        @Override
        public String toString() {
                return String.format("Customer{name: %s, email: %s cpf: %s}", name, email, cpf);
        }
}
