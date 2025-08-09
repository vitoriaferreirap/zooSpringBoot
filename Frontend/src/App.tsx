import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import Animais from './assets/components/Animais'
import CadastroAnimal from './assets/components/CadastroAnimal'
import Home from './assets/components/pages/Home'

function App() {

    return (
        //Rotas dos components
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/cadastroAnimal" element={<CadastroAnimal />} />
                <Route path="/animais" element={<Animais />} />
            </Routes>
        </BrowserRouter>
    )
}

export default App
