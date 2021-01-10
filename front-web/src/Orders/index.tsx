import { useEffect, useState } from 'react';
import { fetchProducts, saveOrder } from '../api';
import Footer from '../Footer';
import { checkIsSelected } from './helpers';
import OrderLocation from './OrderLocation';
import OrderSummary from './OrderSummary';
import ProductsList from './ProductsList';
import StepsHeader from './StepsHeader';
import './styles.css';
import { toast} from 'react-toastify';
import { OrderLocationData, Product } from './types';




function Orders(){//criando a estrutura do componente 
    const [products, setProducts]= useState<Product[]>([]);//use =effect acessar o ciclo do vida do componente
    //carrega os componentes d banco na tela //não depende de nada e vai rodar quando inicializar
    const [selectedProducts, setSelectedProducts]= useState<Product[]>([]);
    const[orderLocation, setOrderLocation]=useState<OrderLocationData>();
    const totalPrice=selectedProducts.reduce((sum,item) => {
      return sum + item.price;
    },0);

    useEffect(() => {
        //fazer requisiçâo no back ende para recarregar os produtos
        //estado para armazenar a lista de produtos
        fetchProducts()
        .then(response=>setProducts(response.data))//os dados do axios ficam dentro do data
        .catch(() => {
          toast.warning('Erro ao listar pedido');
        })
        
    }, []);
    
    const handleSelectProduct = (product: Product) => {
      const isAlreadySelected = checkIsSelected(selectedProducts, product);
    
      if (isAlreadySelected) {
        const selected = selectedProducts.filter(item => item.id !== product.id);
        setSelectedProducts(selected);
      } else {
        setSelectedProducts(previous => [...previous, product]);
      }
    }

    const handleSubmit = () => {
      const productsIds = selectedProducts.map(({ id }) => ({ id }));
      const payload = {
        ...orderLocation!,
        products: productsIds
      }
    
      saveOrder(payload)
      .then((response) => {
        toast.error(`Pedido enviado com sucesso! Nº ${response.data.id}`);
        setSelectedProducts([]);
      })
        .catch(() => {
          toast.warning('Erro ao enviar pedido');
        })
    }

    return(
      <>
        <div className="orders-container">
            <StepsHeader/>
            <ProductsList 
              products={products}
              onSelectProduct={handleSelectProduct}
              selectedProducts={selectedProducts}
            />
            <OrderLocation 
              onChangeLocation={location=>setOrderLocation(location)}/>
            <OrderSummary 
              amount={selectedProducts.length} 
              totalPrice={totalPrice}
              onSubmit={handleSubmit}
              />
        </div>
        <Footer />
      </>
    )

}

export default Orders;