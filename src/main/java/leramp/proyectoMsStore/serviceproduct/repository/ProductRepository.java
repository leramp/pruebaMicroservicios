package leramp.proyectoMsStore.serviceproduct.repository;

import leramp.proyectoMsStore.serviceproduct.entity.Category;
import leramp.proyectoMsStore.serviceproduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //repository reemplaza a la clase DAO
    public List<Product> findByCategory(Category category);
    //esta query method es findBy + el nombre del atributo en mayúscula
}