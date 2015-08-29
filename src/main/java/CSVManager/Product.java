package CSVManager;

import java.util.Date;

/**
 * Created by Ангелин on 22.08.2015.
 */
public class Product implements Comparable<Product>{
    private String name;
    private String tradeMark;
    private String article;
    private int price;

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
}
