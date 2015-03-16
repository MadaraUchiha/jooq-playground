package ninja.madara;

import ninja.madara.domainobject.Foo;

/**
 * Created by madara on 15/03/15.
 */
public class FooService {

    private final FooMapper fooMapper;

    private Map<int, Foo> fooMap;

    public FooService(FooMapper fooMapper) {
        this.fooMapper = fooMapper;
    }

    Foo getFooById(int id) {
        final Foo input = new Foo(id, null);
        final Foo result = fooMapper.fetch(input);
        if (result.getName().equals("Ugly")) {
            throw new UglyException();
        }
        return result;
    }
}
