
const CadastroAnimal = () => {



    return (
        <div className="container">
            <h1>Cadastrar Novo Animal</h1>
            <form id="form-animal">
                <div>
                    <label htmlFor="nome">Nome:</label>
                    <input type="text" id="nome" name="nome" required />
                </div>
                <div>
                    <label htmlFor="categoria">Categoria:</label>
                    <input type="text" id="categoria" name="categoria" required />
                </div>
                <div>
                    <label htmlFor="dieta">Dieta:</label>
                    <input type="text" id="dieta" name="dieta" required />
                </div>
                <div>
                    <label htmlFor="presenca">Presença:</label>
                    <select id="presenca" name="presenca" required>
                        <option value="PRESENTE">Presente</option>
                        <option value="AUSENTE">Ausente</option>
                    </select>
                </div>
                <div>
                    <label for="categoria">Categoria:</label>
                    <input type="text" id="categoria" name="categoria" required>
                </div>
                <div>
                    <label for="dieta">Dieta:</label>
                    <input type="text" id="dieta" name="dieta" required>
                </div>
                <div>
                    <label for="presenca">Presença:</label>
                    <select id="presenca" name="presenca" required>
                        <option value="PRESENTE">Presente</option>
                        <option value="AUSENTE">Ausente</option>
                    </select>
                </div>
                <div>
                    <label for="habitat">Habitat:</label>
                    <input type="number" id="habitat" name="habitat" required>
                </div>
                <button type="submit">Cadastrar</button>
            </form>
            <div id="mensagem"></div>
            <a href="/html/index.html">Voltar para lista</a>
        </div>
    )
}

export default CadastroAnimal