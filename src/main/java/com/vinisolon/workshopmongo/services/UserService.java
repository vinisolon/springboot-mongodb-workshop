package com.vinisolon.workshopmongo.services;

import com.vinisolon.workshopmongo.domain.User;
import com.vinisolon.workshopmongo.dto.UserDTO;
import com.vinisolon.workshopmongo.repository.UserRepository;
import com.vinisolon.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("User not found."));
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public void delete(String id) {
        repository.delete(findById(id));
    }

    public User update(User userNewData) {
        User existentUser = findById(userNewData.getId());
        updateData(existentUser, userNewData);
        return repository.save(existentUser);
    }

    private void updateData(User existentUser, User userNewData) {
        existentUser.setName(userNewData.getName());
        existentUser.setName(userNewData.getName());
        existentUser.setEmail(userNewData.getEmail());
    }

    /*
    Esse método pode ser implementado tanto na classe DTO quanto na de serviço.
    Foi escolhido a classe de serviço pois, dependendo da situação, para instanciar um User, será necessário
    acessar a base de dados.
     */
    public User fromDTO(UserDTO userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }

}
