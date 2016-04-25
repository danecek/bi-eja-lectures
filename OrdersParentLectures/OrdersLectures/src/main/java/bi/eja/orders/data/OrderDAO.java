package bi.eja.orders.data;

import bi.eja.orders.model.Order;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
@Stateless
public class OrderDAO implements OrderDAOInterface {

    @PersistenceContext
    EntityManager em;

    public void create(Order o) {
        em.persist(o);
    }

    public void delete(Integer orderId) {
        Order o = em.find(Order.class, orderId);
        em.remove(o);
    }

    public List<Order> getOrders() {
        return em.createNamedQuery("getOrders", Order.class).getResultList();
    }

    public List<Order> ordersByCustomer(String customerUsername) {
        return em.createNamedQuery("ordersByCustomer", Order.class).
                setParameter(1, customerUsername).getResultList();
    }

    public void update(Order order) {
        em.merge(order);
    }

}
