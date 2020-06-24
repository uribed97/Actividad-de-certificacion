package co.edu.ff.orders.productos.domain;

import com.google.common.base.Preconditions;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductOperationRequest {
    Name name;
    Description description;
    BasePrice basePrice;
    TaxRate taxRate;
    ProductStatus productStatus;
    InventoryQuantity inventoryQuantity ;

    public ProductOperationRequest(Name name, Description description, BasePrice basePrice, TaxRate taxRate, ProductStatus productStatus, InventoryQuantity inventoryQuantity) {
        this.name = Preconditions.checkNotNull(name);
        this.description = Preconditions.checkNotNull(description);
        this.basePrice = Preconditions.checkNotNull(basePrice);
        this.taxRate = Preconditions.checkNotNull(taxRate);
        this.productStatus = Preconditions.checkNotNull(productStatus);
        this.inventoryQuantity = Preconditions.checkNotNull(inventoryQuantity);
    }
}