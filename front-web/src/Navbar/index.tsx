import './styles.css';
import {ReactComponent as Logo} from './logo.svg';
import { Link } from 'react-router-dom';

function Navbar(){//criando a estrutura do componente 
    return(
        <nav className="main-navbar"/*className coloca classe no elemento*/> 
            <Logo/>
            <Link to="/" className="logo-text"/*criando link*/>DS Delivery</Link>
        </nav>
    )

}

export default Navbar;