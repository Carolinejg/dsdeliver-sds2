
function StepsHeader(){//criando a estrutura do componente 
    return(
        <header /*tag para cabeçalho*/ className="orders=steps-container">
            <div className="orders-steps-content">
                <h1 className="steps-title">
                    SIGA AS <br/> ETAPAS
                </h1>
                <ul /*bloco de uma lista*/ className="steps-items">
                    <li>
                        <span className="steps-number">1</span>
                        Selecione os produtos e localização
                    </li>
                    <li>
                        <span className="steps-number">2</span>
                        Depois clique em <strong>"ENVIAR PEDIDO</strong>
                    </li>


                </ul>
                

            </div> 

        </header>
    )

}

export default StepsHeader;