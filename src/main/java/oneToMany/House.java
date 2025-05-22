package oneToMany;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "house01")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer alan;

    @OneToMany (fetch = FetchType.EAGER)
    @JoinColumn(name = "house_id")
    private List<Room> rooms = new ArrayList<>();

    public House(Integer alan) {
        this.alan = alan;
    }

    public House() {
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", alan=" + alan +
                ", rooms=" + rooms +
                '}';
    }
}
