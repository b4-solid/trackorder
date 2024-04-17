package id.ac.ui.cs.advpro.trackorder;

public class Trackorder implements OrderObserver {
    private String orderId;

    public Trackorder(String orderId, Order order) {
        this.orderId = orderId;
        order.addObserver(this);
    }

    @Override
    public void update(String status) {
        //TODO: Isi
    }
}
