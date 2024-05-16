package ps2.restapidb.security.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ps2.restapidb.security.model.DAOUser;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	
	DAOUser findByUsername(String username);
	
}