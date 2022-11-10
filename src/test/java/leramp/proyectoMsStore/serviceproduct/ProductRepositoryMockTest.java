package leramp.proyectoMsStore.serviceproduct;

import leramp.proyectoMsStore.serviceproduct.entity.Category;
import leramp.proyectoMsStore.serviceproduct.entity.Product;
import leramp.proyectoMsStore.serviceproduct.repository.ProductRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByCategory_thenReturnListProduct(){
        //primero creamos el producto que vamos a insertar en la bbdd
        //y que luego vamos a hacer una búsqueda de esa categoría del producto que estamos
        //insertando, entonces para poder insertar hacemos algo adicional. Vamos a la clase Product
        //y agregamos los constructores y el builder
        Product product01 = Product.builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1240.99"))
                .status("Created")
                .createAt(new Date()).build();
        productRepository.save(product01);

        List<Product> founds= productRepository.findByCategory(product01.getCategory());
    //ahora realizamos las aserciones
        Assertions.assertThat(founds.size()).isEqualTo(3);

    }
}
