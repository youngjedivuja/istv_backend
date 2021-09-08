package rs.istv.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Data
@RequiredArgsConstructor(access = PRIVATE)
public class ResponseValue<T> {
    private final T value;

    public static <T> ResponseValue<T> of(T value) {
        return new ResponseValue<>(value);
    }
}
