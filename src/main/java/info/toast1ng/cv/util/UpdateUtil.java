package info.toast1ng.cv.util;

import org.springframework.util.ReflectionUtils;

import java.util.concurrent.atomic.AtomicReference;

public final class UpdateUtil {
    public static <T> void update(T origin, T input) throws Exception {
        if (origin.getClass() != input.getClass()) {
            throw new Exception("Not Same Class");
        }

        final AtomicReference<Boolean> updated = new AtomicReference<>(false);

        ReflectionUtils.doWithFields(origin.getClass(),
                field -> {
                    field.setAccessible(true);

                    try {
                        Object originValue = field.get(origin);
                        Object inputValue = field.get(input);

                        if (field.getAnnotation(IgnoreUpdate.class) != null && inputValue == null) {
                            return;
                        }

                        field.set(origin, inputValue);
                        updated.set(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                });

    }
}
