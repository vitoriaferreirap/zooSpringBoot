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

    //estado tipado do formulário
    //[acessar, alterar]
    const [form, setForm] = useState<AnimalForm>({
        nome: '',
        categoria: '',
        dieta: '',
        presenca: 'PRESENTE',
        habitatId: 0
    });

    return (
        //formulario para cadastrar um animal
        <form>
            <div className="form-group">
                <label htmlFor="nome">Nome:</label>
                <input
                    type="text"
                    id="nome"
                    value={form.nome}
                />
            </div>
            <div className="form-group">
                <label htmlFor="categoria">Categoria:</label>
                <input
                    type="text"
                    id="categoria"
                    value={form.categoria}
                />
            </div>
            <div className="form-group">
                <label htmlFor="dieta">Dieta:</label>
                <input
                    type="text"
                    id="dieta"
                    value={form.dieta}
                />
            </div>
            <div className="form-group">
                <label htmlFor="presenca">Presença:</label>
                <select
                    id="presenca"
                    value={form.presenca}
                >
                    <option value="PRESENTE">Presente</option>
                    <option value="AUSENTE">Ausente</option>
                </select>
            </div>
            <div className="form-group">
                <label htmlFor="habitatId">Habitat:</label>
                <select
                    id="habitatId"
                    value={form.habitatId}
                >
                    <option value="1">Floresta</option>
                    <option value="2">Savana</option>
                    <option value="3">Deserto</option>
                </select>

            </div>
        </form>
    )
}

export default CadastroAnimal