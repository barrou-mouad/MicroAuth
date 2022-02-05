package fst.lsi.authentification;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fst.lsi.entities.UserModel;

@Service
public class UserService implements UserDetailsService{

	
	@Autowired
	private userRepository UserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel foundeduser = UserRepository.findByUsername(username);
		if(foundeduser==null) {
			return null;
		}
		 
		String username2 = foundeduser.getUsername();
		String password2 = foundeduser.getPassword();
		
		return new User(username2, password2, new ArrayList<>());
	}

}
