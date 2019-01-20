package sale.impl;

public class Order {
    private String transactionRef;
    private String productCode;
    private Integer payment = new Integer(0);
    private OrderState currentState;

    public String getTransactionRef() {
        return transactionRef;
    }

    public void setTransactionRef(String transactionRef) {
        this.transactionRef = transactionRef;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {

        this.payment = this.payment + payment;
    }

    public OrderState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(OrderState currentState) {
        this.currentState = currentState;
    }

    private enum OrderState {
        PREPROCESSING, PROCESSING, CANCELLED, COMPLETED
    }


}
