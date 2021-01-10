import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

import './App.css';
import Routes from './Routes';

function App() {//arquivo principal da aplicaçao
  return (
    <>
      <Routes />
      <ToastContainer />
    </>
    
  );
}

export default App;
