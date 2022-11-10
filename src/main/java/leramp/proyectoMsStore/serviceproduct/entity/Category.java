package leramp.proyectoMsStore.serviceproduct.entity;



import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="tbl_categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Data//data hace lo que hace @Getter y @Setter y además hashcode toString y Equals
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}