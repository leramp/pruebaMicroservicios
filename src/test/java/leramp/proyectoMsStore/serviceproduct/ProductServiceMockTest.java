package leramp.proyectoMsStore.serviceproduct;

import leramp.proyectoMsStore.serviceproduct.entity.Category;
import leramp.proyectoMsStore.serviceproduct.entity.Product;
import leramp.proyectoMsStore.serviceproduct.repository.ProductRepository;
import leramp.proyectoMsStore.serviceproduct.service.ProductService;
import leramp.proyectoMsStore.serviceproduct.service.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {
//en la otra prueba unitaria accedíamos a la bbdd y cargábamos nuestros datos
    //ahora no vamos a acceder a la bbdd sino que trabajaremos con datos mockeados
    //para esto usamos Mockito, por eso decoramos con @Mock
    @Mock
    private ProductRepository productRepository;

    private ProductService productService;
    //declaramos un método mediante el cual mockeamos todos los datos para nuestra prueba unitaria
    @BeforeEach// aca le indicamos que esto se tiene que ejecutar antes de comenzar el test
    public void setup(){
        MockitoAnnotations.initMocks(this);
        //creamos un ProductServiceImpl y le pasamos el repositorio mockeado
        //para eso le creamos un constructor a ProductServiceImpl
        productService =  new ProductServiceImpl( productRepository);
        Product computer =  Product.builder()
                .id(1L)
                .name("computer")
                .category(Category.builder().id(1L).build())
                .price(Double.parseDouble("12.5"))
                .stock(Double.parseDouble("5"))
                .build();
        //ahora sí creamos el mock
        //cuando se busque un producto con el id 1 vamos a retornar nuestro mock computer
        // que hemos mockeado
        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(computer));
        //cuando un producto sea actualizado, también debemos actualizar también nuestro mock
        Mockito.when(productRepository.save(computer)).thenReturn(computer);

    }
    //ahora creamos un método que valide la búsqueda de nuestro producto computer
    @Test//este método inicia una búsqueda del producto que hemos mockeado y cuando utilicemos el
    //método productService.getProduct lo que nos debe devolver es
    //ese mismo producto
    public void whenValidGetID_ThenReturnProduct(){
        Product found = productService.getProduct(1L);
        Assertions.assertThat(found.getName()).isEqualTo("computer");

    }
    //ahora verificamos que la lógica de stock funcione correctamente
    //validmaos si a nuestro producto mockeado le agregamos 8 unidades, el stock actual será de 13
    //porque hemos mockeado que nuestro producto inicial tenga 5
    @Test
    public void whenValidUpdateStock_ThenReturnNewStock(){
        Product newStock = productService.updateStock(1L,Double.parseDouble("8"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(13);
    }
}
