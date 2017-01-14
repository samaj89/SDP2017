/**
 * Created by samaj on 12/01/17.
 */
public class Storage<T> {
    T x;

    public void setValue(T value) {
        x = value;
    }

    public T getValue() {
        return x;
    }

}
