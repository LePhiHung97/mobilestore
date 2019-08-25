package com.phihung.security;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.phihung.entity.ChucVu;
import com.phihung.entity.NguoiDung;
import com.phihung.service.INguoiDungService;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private INguoiDungService nguoiDungService;

	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		NguoiDung nguoiDung = nguoiDungService.timTheoTenDangNhap(username);
		if (nguoiDung == null) {

			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(nguoiDung.getTendangnhap(), nguoiDung.getMatkhau(), true, true,
				true, true, getGrantedAuthorities(nguoiDung));
	}
	private List<GrantedAuthority> getGrantedAuthorities(NguoiDung nguoiDung){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        ChucVu chucVu  = nguoiDung.getChucvu();
        authorities.add(new SimpleGrantedAuthority(chucVu.getTenchucvu()));
        return authorities;
    }

}
