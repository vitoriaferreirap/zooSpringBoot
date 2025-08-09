import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import CadastroAnimal from './assets/components/CadastroAnimal'
import Home from './assets/components/pages/Home'

function App() {

    return (
        //criando navegação e rotas entre paginas 
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/cadastroAnimal" element={<CadastroAnimal />} />
            </Routes>
        </BrowserRouter>
    )
}

export default App
