package com.negocioBimba.negocioBimba.model;

import com.negocioBimba.negocioBimba.model.embeddedIds.OrderProductId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "orders_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct {

    @EmbeddedId
    private OrderProductId id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @MapsId("customerOrderId")
    private CustomerOrder customerOrder;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @MapsId("productId")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        OrderProduct that = (OrderProduct) o;
        return Objects.equals(this.customerOrder, that.customerOrder) && Objects.equals(this.product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerOrder, product);
    }
}
