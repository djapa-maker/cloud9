package tn.esprit.spring.entities;

import lombok.Getter;
import lombok.var;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    User,
    Student,
    Teacher,
    Admin;

}
