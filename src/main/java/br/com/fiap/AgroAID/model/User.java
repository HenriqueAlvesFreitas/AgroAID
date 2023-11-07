package br.com.fiap.AgroAID.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.oauth2.core.user.OAuth2User;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    String password;
    String telefone;
    String avatarUrl;

   public static User convert(OAuth2User oAuth2User){
        return new User().builder()
                    .id(Long.valueOf(oAuth2User.getName()))
                    .name(oAuth2User.getAttribute("name"))
                    .avatarUrl(oAuth2User.getAttribute("avatar_url"))
                    .build();
                    
    }
}
