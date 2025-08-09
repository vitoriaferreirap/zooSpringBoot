import { useState } from "react";
const CadastroAnimal = () => {
    //tipagem, controler, cliks.

    //tipos
    type Presenca = 'PRESENTE' | 'AUSENTE';

    //interface habitat
    interface Habitat {
        id: number;
        nome: string;
    }

    //interface para o formulario de Animal
    interface AnimalForm {
        nome: string;
        categoria: string;
        dieta: string;
        presenca: Presenca;
        habitatId: number;
    }

    //estado controlado do formulário
    //[acessar, alterar]
    const [form, setForm] = useState<AnimalForm>({
        nome: '',
        categoria: '',
        dieta: '',
        presenca: 'PRESENTE',
        habitatId: 0
    });

    return (
        <>

        </>
    )
}

export default CadastroAnimal