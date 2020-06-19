package vehicles;

import java.math.BigDecimal;
import java.util.Date;

public class Insurance {
    private BigDecimal oneOffPrice;
    private BigDecimal monthlyrice;
    private boolean isPaid;
    private boolean isRecurrence;


    public Date getNextPaymentDate(String insuranceId){
        return new Date();
    }

    public BigDecimal getOneOffPrice() {
        return oneOffPrice;
    }

    public void setOneOffPrice(BigDecimal oneOffPrice) {
        this.oneOffPrice = oneOffPrice;
    }

    public boolean isRecurrence() {
        return isRecurrence;
    }

    public void setRecurrence(boolean recurrence) {
        isRecurrence = recurrence;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
