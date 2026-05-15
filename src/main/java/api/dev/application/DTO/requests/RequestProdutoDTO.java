package api.dev.application.DTO.requests;

public record RequestProdutoDTO(
        Long id,
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
