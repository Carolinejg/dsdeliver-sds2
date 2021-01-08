import './styles.css';
import {ReactComponent as YoutubeIcon} from './youtube.svg';
import {ReactComponent as LinkedinIcon} from './linkedin.svg';
import {ReactComponent as InstagramIcon} from './instagram.svg';

function Footer(){//criando a estrutura do componente 
    return(
        <footer className="main-footer"/*tag do html para rodape*/>
            App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
            <div className="footer-icons">
                <a href="http://www.youtube.com/c/DevSuperior" target="_new">
                    <YoutubeIcon/>
                </a>
                <a href="http://www.linkedin.com/school/devsuperior/" target="_new">
                    <LinkedinIcon/>
                </a>
                <a href="http://www.instagram.com/devsuperior.ig/">
                    <InstagramIcon/>
                </a>

            </div>
        </footer>
    )

}

export default Footer;