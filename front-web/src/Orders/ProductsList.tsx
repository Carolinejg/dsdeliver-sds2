import { checkIsSelected } from "./helpers";
import ProductsCard from "./ProductCard";
import { Product } from "./types";

type Props={
    products:Product[];
    selectedProducts: Product[];
    onSelectProduct: (product: Product)=>void;
}

function ProductsList({products,selectedProducts,onSelectProduct}: Props){//criando a estrutura do componente 
    return(
        <div className="orders-list-container">
            <div className="orders-list-items">
                {products.map(product=>(//iterando sobre a lista de produtos 
                    <ProductsCard 
                    key={product.id} 
                    product={product}
                    onSelectProduct={onSelectProduct}
                    isSelected={checkIsSelected(selectedProducts,product)}
                    />
                ))}
            </div>
            
        </div>
    )

}

export default ProductsList;