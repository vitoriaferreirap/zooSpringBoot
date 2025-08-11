import type { Presenca } from '../types/typesAnimais';
   
//interface habitat
export interface Habitat {
    id: number;
    nome: string;
}

//interface para o formulario de Animal
export interface Animal {
    id: number;
    nome: string;
    categoria: string;
    dieta: string;
    presenca: Presenca; //consome meu type
    habitat: Habitat; //consome meu type
}
