package com.negocioBimba.negocioBimba.model.embeddedIds;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductId implements Serializable {

    @Column(name = "order_id")
    private Integer customerOrderId;

    @Column(name = "product_id")
    private Integer productId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        OrderProductId that = (OrderProductId) o;
        return Objects.equals(this.customerOrderId, that.customerOrderId) && Objects.equals(this.productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerOrderId, productId);
    }
}
