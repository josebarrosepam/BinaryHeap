import java.util.Date;

public class Order implements Comparable<Order> {
    
    private Long price;
    private Date timestamp;

    public Order(Long price, Date timestamp) {
        this.price = price;
        this.timestamp = timestamp;
    }

    public Long getPrice() {
        return price;
    }
    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public int compareTo(Order objA) {        
        if (objA.getPrice() < this.price) {
            return -1;
        } else if (objA.getPrice() > this.price) {
            return 1;        
        } else {
            return objA.getTimestamp().compareTo(this.timestamp);
        }
    }
    
}
