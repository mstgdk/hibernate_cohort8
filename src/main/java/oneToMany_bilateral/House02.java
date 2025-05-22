package oneToMany_bilateral;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import oneToMany.Room;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class House02 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer alan;

    @OneToMany(mappedBy = "house",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room02> rooms = new ArrayList<>();

    public House02(Integer alan) {
        this.alan = alan;
    }

    public House02() {
    }

    @Override
    public String toString() {
        return "House02{" +
                "id=" + id +
                ", alan=" + alan +
                ", rooms=" + rooms +
                '}';
    }
}
