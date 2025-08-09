import { Link } from "react-router"
//link para navegacao entre paginas

const Home = () => {
    return (
        <header>
            <div className="container">
                <h1>Bem-vindo ao Zoo</h1>
                <nav>
                    <ul>
                        <li><Link to="#animais">Animais</Link></li>
                        <li><Link to="#sobre">Sobre</Link></li>
                        <li><Link to="#contato">Contato</Link></li>
                        {/* Ajuste para a rota da página de cadastro na sua SPA */}
                        <li><Link to="/cadastro">Cadastrar Animal</Link></li>
                    </ul>
                </nav>
            </div>
        </header>

    )
}

export default Home