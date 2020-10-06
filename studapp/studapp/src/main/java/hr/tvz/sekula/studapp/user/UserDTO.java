package hr.tvz.sekula.studapp.user;

import java.util.Set;

public class UserDTO {

    private Integer id;

    private String username;

    private String firstName;

    private String lastName;

    private Set<String> authorities;

    public UserDTO(Integer id, String username, String first_name, String last_name, Set<String> authorities) {
        this.id = id;
        this.username = username;
        this.firstName = first_name;
        this.lastName = last_name;
        this.authorities = authorities;


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String first_name) {
        this.firstName = first_name;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String last_name) {
        this.lastName = last_name;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}
