package calculator.recorder;

import java.util.Collection;
import java.util.stream.Stream;

public interface Recordable<T> {
    Collection<T> getRecordCollection();
    void record(T recordData);
    void remove();
    Stream<T> stream();
    T getLatestResult();
}
