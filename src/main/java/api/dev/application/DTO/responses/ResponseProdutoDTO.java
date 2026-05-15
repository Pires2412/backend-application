package api.dev.application.DTO.responses;

public record ResponseProdutoDTO(
         String nameProduct,
         String description,
         Integer quantityInStock,
         double purchasePrice,
         double sellingPrice,
         String supplier,
         String category,
         String subcategory
) {
}
