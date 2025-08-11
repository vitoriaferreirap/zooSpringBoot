import { useEffect, useMemo, useState } from "react";
import type { Animal } from "../interfaces/interfaceAnimais";
const { VITE_API_URL, VITE_API_USER, VITE_API_PASS } = import.meta.env;

const Animais = () => {
    //ID, NOME, CATEGORIA, DIETA, PRESENCA, HABITAT

    //usando useState : estado inicial é um array vazio tipado
    const [animais, setAnimais] = useState<Animal[]>([]);

    //usando useMemo : para memorizar o cabeçalho de autenticação
    const authHeader = useMemo(() => 'Basic ' + btoa(`${VITE_API_USER}:${VITE_API_PASS}`), [[VITE_API_USER, VITE_API_PASS]])

    //usando useEffect(() => {}, []) : para consumir a API quando o componente for montado
    useEffect(() => {//funcao lambda - arrow fuction (forma de escrever)
        const fetchGetAnimais = async () => { //funcao assíncrona

            //bloco impede quebra de codigo se houver erros
            try {
                const resp = await fetch(`${VITE_API_URL}/animais`, {
                    headers: {
                        'Authorization': authHeader, // Adiciona o cabeçalho de autenticação    
                        'Content-Type': 'application/json' // Define o tipo de conteúdo como JSON
                    }
                });
                if (!resp.ok) {
                    throw new Error("Erro ao buscar animais: " + resp.statusText);
                }
                const data = await resp.json(); //converte a resposta em JSON
                setAnimais(data); //atualiza o estado com os dados recebidos
            } catch (error) {
                console.error("Erro ao buscar animais:", error);
            }
        };
        fetchGetAnimais();
    }, [authHeader]);// 

    return (
        <section id="animais">
            <div className="container">
                <h2>Nossos Animais</h2>
                {/* Consumir API */}
                <div className="animals-grid">
                    {/* exibir animais vindo da API */}
                    <ul>
                        {/*acessando array de animais recebidos da API */}
                        {animais.length == 0 && <li>Nenhum animal encontrado.</li>}
                        {animais.map((animal) => ( //para cada animal
                            <li key={animal.id}>
                                <h3>{animal.nome}</h3>
                                <p>Categoria: {animal.categoria}</p>
                                <p>Dieta: {animal.dieta}</p>
                                <p>Presença: {animal.presenca}</p>
                                <p>Habitat: {animal.habitat.id}</p>
                            </li>
                        ))}
                    </ul>

                </div>
            </div>
        </section>
    )
}

export default Animais