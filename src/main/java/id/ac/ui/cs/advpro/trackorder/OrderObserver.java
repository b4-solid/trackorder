package id.ac.ui.cs.advpro.trackorder;
public interface OrderObserver {
    void update(Order order);
    void addOrder(Order order);
    void removeOrder(Order order);
}