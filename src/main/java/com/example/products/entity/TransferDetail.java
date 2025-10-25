package com.example.products.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transfer_detail")
public class TransferDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "transfer_id", nullable = false)
    private Transfer transfer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_variant_id", nullable = false)
    private ProductVariant productVariant;

    @Column(name = "requested_quantity")
    private Integer requestedQuantity;

    @Column(name = "sent_quantity")
    private Integer sentQuantity;

    @Column(name = "received_quantity")
    private Integer receivedQuantity;

    public TransferDetail() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Transfer getTransfer() { return transfer; }
    public void setTransfer(Transfer transfer) { this.transfer = transfer; }

    public ProductVariant getProductVariant() { return productVariant; }
    public void setProductVariant(ProductVariant productVariant) { this.productVariant = productVariant; }

    public Integer getRequestedQuantity() { return requestedQuantity; }
    public void setRequestedQuantity(Integer requestedQuantity) { this.requestedQuantity = requestedQuantity; }

    public Integer getSentQuantity() { return sentQuantity; }
    public void setSentQuantity(Integer sentQuantity) { this.sentQuantity = sentQuantity; }

    public Integer getReceivedQuantity() { return receivedQuantity; }
    public void setReceivedQuantity(Integer receivedQuantity) { this.receivedQuantity = receivedQuantity; }
}