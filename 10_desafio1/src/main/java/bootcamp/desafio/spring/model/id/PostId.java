package bootcamp.desafio.spring.model.id;

import lombok.*;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostId {

    private Long userId;
    private Long idPost;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostId postId = (PostId) o;
        return Objects.equals(userId, postId.userId) && Objects.equals(idPost, postId.idPost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, idPost);
    }
}
