package com.weshare.manage.service.impl;
import com.weshare.manage.entity.Role;
import com.weshare.manage.service.RoleService;
import com.weshare.manage.repository.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public Role add(Role role){
		return roleRepository.save(role);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void delete(Long id){
		roleRepository.deleteById(id);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public Role update(Role role){
		return roleRepository.saveAndFlush(role);
	}
	public Role get(Long id){
		return roleRepository.getOne(id);
	}
	public List<Role> getAll(){
		return roleRepository.findAll();
	}
	public Page<Role> getPage(int page, int rows){
		Pageable pageable = new PageRequest(page-1, rows);
		return roleRepository.findAll(pageable);
	}
}