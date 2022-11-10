package leramp.proyectoMsStore.serviceproduct;
//
//import leramp.proyectoMsStore.serviceproduct.entity.Category;
//import leramp.proyectoMsStore.serviceproduct.entity.Product;
//import leramp.proyectoMsStore.serviceproduct.repository.ProductRepository;
//import org.junit.jupiter.api.Assertions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
//
//import java.util.Date;
//import java.util.List;
//
//@DataJdbcTest
public class ProductRepositoryMockTest {
//    @Autowired
//    private ProductRepository productRepository;
//
//    public void whenFindByCategory_thenReturnListProduct(){
//        //primero creamos elproducto que vamos a insertar en la bbdd
//        //y que luego vamos a hacer una búsqueda de esa categoría del producto que estamos
//        //insertando, entonces para poder insertar hacemos algo adicional. Vamos  a la clase Product
//        //y agregamos los constructores y el builder
//        Product product01 = Product.builder()
//                .name("Computer")
//                .category(Category.builder().id(1L).build())
//                .description("")
//                .stock(Double.parseDouble("10"))
//                .price(Double.parseDouble("1240.99"))
//                .status("Created")
//                .createAt(new Date()).build();//finalmente para generar la instancia ponemos build()
//        productRepository.save(product01);
//
//        List<Product> found=productRepository.findByCategory(product01.getCategory());
//    //ahora realizamos las aserciones
//      Assertions.assertThat(found.size()).isEqualTo(3);
//
//    }
}
