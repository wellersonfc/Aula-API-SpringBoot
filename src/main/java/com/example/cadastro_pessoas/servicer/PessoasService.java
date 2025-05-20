// Pacote onde a classe está localizada
package com.example.cadastro_pessoas.servicer;

// Importações necessárias para manipulação de listas e objetos opcionais
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;  // Injeção de dependência
import org.springframework.stereotype.Service;               // Define a classe como um Service do Spring

import com.example.cadastro_pessoas.model.PessoasModel;
import com.example.cadastro_pessoas.repository.PessoasRepository;
@Service
public class PessoasService {

    @Autowired
    private PessoasRepository repository;

    /**
     @return 
     */
    public List<PessoasModel> listarTodos() {
        // Chama o método findAll() do repository para buscar todas as pessoas
        return repository.findAll();
    }
    /**
     * @param id Identificador da pessoa.
     * @return Um Optional contendo a pessoa encontrada, ou vazio se não encontrar.
     */

    
    public Optional<PessoasModel> buscarPorId(Long id) {
        // Chama o método findById() do repository para buscar a pessoa pelo ID
        return repository.findById(id);
    }

    /**
     * Método responsável por salvar ou atualizar uma pessoa no banco de dados.
     * @param pessoasModal Objeto da entidade PessoasModel contendo os dados.
     * @return A entidade salva ou atualizada.
     */
    public PessoasModel salvar(PessoasModel pessoasModal) {
        // Chama o método save() do repository para salvar os dados no banco
        return repository.save(pessoasModal);
    }

    /**
     * Método responsável por deletar uma pessoa do banco de dados.
     * @param id Identificador da pessoa a ser deletada.
     */
    public void deletar(Long id) {
        // Chama o método deleteById() do repository para remover o registro
        repository.deleteById(id);
    }
}
