package br.com.projetoanimalsave.Projections;

public interface UserDetailsProjection {

    String getUsername();

    String getPassword();

    Long getRoleId();

    String getAuthority();

}
