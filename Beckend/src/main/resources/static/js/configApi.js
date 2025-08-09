const API_URL = 'http://localhost:8080/animais';
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

//carrega dados do forms para enviar para API
document.addEventListener('DOMContentLoaded', function() {
  
    const form = document.getElementById('form-animal');
    form.addEventListener('submit', async (event) => {
        event.preventDefault(); // Impede o envio padrão do formulário

        // Coleta os valores dos campos do formulário
        const nome = document.getElementById('nome').value;
        const categoria = document.getElementById('categoria').value;
        const dieta = document.getElementById('dieta').value;
        const presenca = document.getElementById('presenca').value;
        const id = parseInt(document.getElementById('habitat').value);

        // Cria o objeto animal com os dados do formulário
        const animal = {
            nome: nome,
            categoria: categoria,
            dieta: dieta,
            presenca: presenca,
            habitat: {
                id: id
            }
        };

        // Chama a função para adicionar o animal na API
        await adicionarAnimalNaApi(animal);
    }); 
});

// Função só para enviar animal
async function adicionarAnimalNaApi(animal) {
    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: {
                'Authorization': AUTH_HEADER,
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(animal)
        });

        if (!response.ok) {
            throw new Error('Erro ao cadastrar animal: ' + response.statusText);
        }

        document.getElementById('mensagem').innerHTML = '<span style="color:green;">Animal cadastrado com sucesso!</span>';
        document.getElementById('form-animal').reset();
    } catch (error) {
        document.getElementById('mensagem').innerHTML = '<span style="color:red;">' + error.message + '</span>';
    }
}

