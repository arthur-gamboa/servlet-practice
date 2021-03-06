package DAOs;
import java.util.ArrayList;
import java.util.List;

class ListProducts implements Products {

    private List<Product> products = new ArrayList();

    public ListProducts() {
        insert (new Product("hammer", 9.98));
        insert (new Product("screwdriver", 9.99));
        insert (new Product("drill", 19.99));
    }

    public void insert(Product product) {
        this.products.add(product);
    }

    public List<Product> all() {
        return this.products;
    }

}
