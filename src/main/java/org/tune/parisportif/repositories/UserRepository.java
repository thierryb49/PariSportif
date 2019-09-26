package org.tune.parisportif.repositories;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.tune.parisportif.entities.User;

@CrossOrigin("*")
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
	public Optional<User> findByUsername(String username);
	///public Optional<User> findById(long userId);
	public Optional<User> findByMail(String mail);
	public Optional<User> findByUsernameAndPassword(String username, String password);	
	public Optional<User> findByUsernameAndPasswordAndMail(String username, String password, String mail);
	
	@Query(value = "select u, sum(p.points) as total_points " + 
	"from User u, Pronostic p " + 
	"where u.id = p.userId " + 
	"group by u.id order by total_points desc")
	public Collection<User> classement();
	/*
	@Query("select p from Product p where p.name like :x")
	public List<Product> chercher(@Param("x") String mc);
	*/
	/*@Query(value = "select p, sum(po.quantity) as total_quantity " + 
	        "from Product p, ProductOrder po " +
	        "where p.id = po.pk.product " +
	        "group by p.id, p.name " +
	        "order by total_quantity desc")
	List<Product> findTopFiveBestSeller();*/
	 
}
