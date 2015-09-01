package CSVManager;


import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Ангелин on 29.08.2015.
 */
public class Product implements Comparable<Product>{
    private String name;
    private String tradeMark;
    private String article;
    private int price;
    private static final Logger LOG = Logger.getLogger(Product.class);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(){

    }

    public Product(String name, String tradeMark, String article, int price){
        this.name = name;
        this.tradeMark = tradeMark;
        this.article = article;
        this.price = price;
    }

    public static void sortedDataBy(List<Product> list, CompareType sortBy){
        switch (sortBy){
            case BY_NAME:
                Collections.sort(list, new Comparator<Product>() {
                    @Override
                    public int compare(Product p1, Product p2) {
                        return p1.getName().compareTo(p2.getName());
                    }
                });
                LOG.info("Список продуктов отсортирован ПО ИМЕНИ.");
                break;
            case BY_TRADE_MARK:
                Collections.sort(list, new Comparator<Product>() {
                    @Override
                    public int compare(Product p1, Product p2) {
                        return p1.getTradeMark().compareTo(p2.getTradeMark());
                    }
                });
                LOG.info("Список продуктов отсортирован ПО ТОРГОВОЙ МАРКЕ.");
                break;
            case BY_PRICE:
                Collections.sort(list, new Comparator<Product>() {
                    @Override
                    public int compare(Product p1, Product p2) {
                        return Integer.compare(p1.getPrice(), p2.getPrice());
                    }
                });
                LOG.info("Список продуктов отсортирован ПО ЦЕНЕ.");
                break;
            case DEFAULT:
                Collections.sort(list);
                LOG.info("Список продуктов отсортирован ПО УМОЛЧАНИЮ.");
                break;
        }
    }

    @Override
    public int compareTo(Product obj) {
        return this.article.compareTo(obj.article);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Product)){
            return false;
        }
        Product product = (Product)obj;
        return this.article.equals(((Product) obj).article);
    }

    @Override
    public int hashCode() {
        int result = 64;
        result = 17 * result + article.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", tradeMark='" + tradeMark + '\'' +
                ", article='" + article + '\'' +
                ", price=" + price +
                '}';
    }
}
