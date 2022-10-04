public class ProductRepository {
    private Product[] items = new Product[0];


    public ProductRepository() {

    }

    public void add(Product item) {
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Product[] getItems() {
        return items;
    }

    public void removeById(int id) {
        int occurrencies = 0;
        for (Product item : items) {
            if (item.getId() == id) {
                occurrencies++;
            }
        }
        Product[] tmp = new Product[items.length - occurrencies];
        int copyToIndex = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }
}