import { useEffect, useState } from 'react';
import { fetchProducts } from '../api';
import ProductsList from './ProductsList';
import StepsHeader from './StepsHeader';
import './styles.css';
import { Product } from './types';

function Orders(){//criando a estrutura do componente 
    const [products, setProducts]= useState<Product[]>([]);//use =effect acessar o ciclo do vida do componente
    //carrega os componentes d banco na tela
    //não depende de nada e vai rodar quando inicializar
    console.log(products);
    useEffect(() => {
        //fazer requisiçâo no back ende para recarregar os produtos
        //estado para armazenar a lista de produtos
        fetchProducts()
        .then(response=>setProducts(response.data))//os dados do axios ficam dentro do data
        .catch(error=>console.log(error));
        
    }, []);
    return(
        <div className="orders-container">
            <StepsHeader/>
            <ProductsList products={products}/>
        </div>
    )

}

export default Orders;