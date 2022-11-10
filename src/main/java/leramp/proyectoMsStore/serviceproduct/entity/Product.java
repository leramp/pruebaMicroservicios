package leramp.proyectoMsStore.serviceproduct.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tbl_product")
@Getter
@Setter
@ToString
//@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double stock;
    private Double price;
    private String status;
    @Column(name="create_at")
    @Temporal(TemporalType.TIMESTAMP)//con esto le digo que quiero mapear la fecha y la hora
    private Date createAt;
    @ManyToOne(fetch=FetchType.LAZY)//EAGER carga por defecto de manera proactiva todos los valores
    // de las categorías y Lazy los carga solo en el momento que se requieran
    @JoinColumn(name="category_id")//acá va el nombre de la columna con la cual se va a mapear en la tabla Category
    private Category category;
}
