package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients_cats", schema = "public", catalog = "aston_hm3")
public class ClientsCats {
    @Basic
    @Id
    @Column(name = "client_id", nullable = false)
    private Integer clientId;
    @Basic
    @Id
    @Column(name = "cat_id", nullable = false)
    private Integer catId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientsCats that = (ClientsCats) o;
        return Objects.equals(clientId, that.clientId) && Objects.equals(catId, that.catId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, catId);
    }
}
