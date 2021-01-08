import './styles.css';
import {ReactComponent as MainImage} from './main.svg'
import Footer from '../Footer';
import { Link } from 'react-router-dom';

function Home(){//criando a estrutura do componente 
    return(
        <>
            <div className="home-container">
                <div className="home-content"/*colocando todo o conteudo da pagina em um container para centralizar*/>
                    <div className="home-actions">
                        <h1 className="home-title">
                            Faça seu pedido <br/> que entregamos 
                            <br/> pra você!!!
                        </h1>
                        <h3 className="home-subtitle">
                            Escolha o seu pedido e em poucos minutos 
                            <br/> levaremoss na sua porta
                        </h3>
                        <Link to="/orders" className="home-btn-order">
                            FAZER PEDIDO
                        </Link>
                    </div>
                    <div className="home-image">
                        <MainImage/>
                    </div>
                </div>

            </div>
            <Footer/>
        </>
    )

}

export default Home;