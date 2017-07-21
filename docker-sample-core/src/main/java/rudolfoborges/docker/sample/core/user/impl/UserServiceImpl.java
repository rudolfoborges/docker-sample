package rudolfoborges.docker.sample.core.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import rudolfoborges.docker.sample.core.user.User;
import rudolfoborges.docker.sample.core.user.UserBuilder;
import rudolfoborges.docker.sample.core.user.UserService;
import rudolfoborges.docker.sample.persistence.user.UserEntity;
import rudolfoborges.docker.sample.persistence.user.UserRepository;

/**
 * Created by rudolfoborges on 21/07/17.
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> fetchAll() {
		final List<UserEntity> userEntities = userRepository.findAll();

		return userEntities
				.stream()
				.map(userEntity -> new UserBuilder()
				.withName(userEntity.getName())
				.withEmail(userEntity.getEmail())
				.build())
				.collect(Collectors.toList());
	}

}
