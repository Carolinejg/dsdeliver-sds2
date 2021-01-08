import './App.css';
import Navbar from './Navbar';
import Home from './Home';

function App() {//arquivo principal da aplicaçao
  return (
    </*criando um react fragments, 
    bloco de código não reprensentado no html*/> 
     <Navbar/>
     <Home />
    </>
  );
}

export default App;
