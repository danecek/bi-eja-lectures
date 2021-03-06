package jpql;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "CustomerOrder")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int price;

    @ManyToOne
    Customer customer;

    public Order() {
    }

    public Order(int price, Customer customer) {
        this.price = price;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", price=" + price +'}';
    }
    
}
