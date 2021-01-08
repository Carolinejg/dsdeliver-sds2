import './styles.css';
import {ReactComponent as Logo} from './logo.svg';

function Navbar(){//criando a estrutura do componente 
    return(
        <nav className="main-navbar"/*className coloca classe no elemento*/> 
            <Logo/>
            <a href="home" className="logo-text"/*criando link*/>DS Delivery</a>
        </nav>
    )

}

export default Navbar;