import ProductsCard from "./ProductCard";
import { Product } from "./types";

type Props={
    products:Product[];
}

function ProductsList({products}: Props){//criando a estrutura do componente 
    return(
        <div className="orders-list-container">
            <div className="orders-list-items">
                {products.map(product=>(//iterando sobre a lista de produtos 
                    <ProductsCard key={product.id} product={product}/>
                ))}
            </div>
            
        </div>
    )

}

export default ProductsList;