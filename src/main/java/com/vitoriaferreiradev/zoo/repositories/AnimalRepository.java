package com.vitoriaferreiradev.zoo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitoriaferreiradev.zoo.entities.Animal;

/*
 * Interface que estende JpaRepository fornecendo métodos automáticos para 
 * acesso ao banco de dados.
 * 
 * JpaRepository<Entidade, Tipo da chave primária>
 * 
 * PADRÃO DE PROJETO APLICADO: Repository Pattern
 * Encapsula a lógica de acesso a dados, criando uma camada de abstração 
 * entre a aplicação e o banco de dados através de uma interface.
 */
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    /*
     * Ao extender JPARepository :
     * Spring Data JPA já faz TUDO automaticamente:
     * Registra como bean
     * Cria implementação automática
     * Gerencia exceções
     * Injeta dependências
     * Usar @Repository apenas se não usar Spring Data JPA
     */

}
