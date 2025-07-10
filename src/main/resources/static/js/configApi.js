const API_URL = '/animais';
const AUTH_HEADER = 'Basic ' + btoa('admin:admin123');

//funcao para buscar animais da API
async function carregarAnimaisDaApi() {
    const grid = document.querySelector('.animals-grid');// Seleciona o grid onde os animais serão exibidos
    grid.innerHTML = " ";

    try {
        // O método fetch retorna um objeto de resposta HTTP (não o JSON direto)
        // O cabeçalho de autenticação é adicionado para acessar a API protegida
        const response = await fetch(API_URL, {
            headers: {
                'Authorization': AUTH_HEADER, // Adiciona o cabeçalho de autenticação    
                'Content-Type': 'application/json' // Define o tipo de conteúdo como JSON
            }
        });

        if (!response.ok) {
            throw new Error('Erro ao buscar animais: ' + response.statusText);
        }
        const animais = await response.json(); // Converte a resposta para JSON
        if (animais.length === 0) {
            grid.innerHTML = '<p>Nenhum animal encontrado.</p>';
            return;
        }
        // Cria os cards de animais dinamicamente
        animais.forEach(animal => {
            const card = document.createElement('div');
            card.className = 'animal-card';
            card.innerHTML = `
                <h3>${animal.nome}</h3>
                <p><strong>Categoria:</strong> ${animal.categoria}</p>
                <p><strong>Dieta:</strong> ${animal.dieta}</p>
                <p><strong>Presença:</strong> 
                <span class="${animal.presenca === 'PRESENTE' ? 'status-presente' : 'status-ausente'}">
                ${animal.presenca}
                </span>
                </p>
                <p><strong>Habitat:</strong> ${animal.habitat && animal.habitat.nome ? animal.habitat.nome : 'Não informado'}</p>
                `;
            grid.appendChild(card);
        });
    
    }catch (error) {
        console.error('Erro ao buscar animais:', error);
        grid.innerHTML = '<p>Erro ao carregar animais. Tente novamente mais tarde.</p>';
        return;
    }
}