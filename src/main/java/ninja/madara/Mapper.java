package ninja.madara;

/**
 * Created by madara on 15/03/15.
 */
public interface Mapper<T> {
    public T fetch(T input);
    public void store(T input);
}
