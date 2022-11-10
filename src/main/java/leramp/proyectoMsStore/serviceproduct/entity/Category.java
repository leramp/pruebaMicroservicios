package leramp.proyectoMsStore.serviceproduct.entity;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="tbl_categories")
@Data

//@Data//data hace lo que hace @Getter y @Setter y además hashcode toString y Equals
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}