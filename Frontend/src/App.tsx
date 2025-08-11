import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import Animais from './assets/components/Animais'
import FormsAnimais from './assets/components/FormsAnimais'
import Home from './assets/components/pages/Home'
import './css/Cards.css'

function App() {

    return (
        //Rotas dos components
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/FormsAnimais" element={<FormsAnimais />} />
                <Route path="/animais" element={<Animais />} />
            </Routes>
        </BrowserRouter>
    )
}

export default App
