package oneToMany_bilateral;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import oneToMany.House;

@Entity
@Getter
@Setter
public class Room02 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;

    @ManyToOne()
    @JoinColumn(name = "house_id")
    private House02 house;

    public Room02(String color) {
        this.color = color;
    }

    public Room02() {
    }

    @Override
    public String toString() {
        return "Room02{" +
                "id=" + id +
                ", color='" + color + '\'' +
               // ", house=" + house +
                '}';
    }
}
