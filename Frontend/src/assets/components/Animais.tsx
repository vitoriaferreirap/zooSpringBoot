
const Animais = () => {
    return (
        <section id="animais">
            <div class="container">
                <h2>Nossos Animais</h2>
                <div class="animals-grid">
                    <!-- Consumindo API -->
                    <button onclick="carregarAnimaisDaApi()">Carregar Animais</button>
                </div>
            </div>
        </section>
    )
}

export default Animais