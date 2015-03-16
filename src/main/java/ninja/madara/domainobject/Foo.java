package ninja.madara.domainobject;

import org.jooq.ninja.madara.tables.records.FooRecord;

/**
 * Created by madara on 15/03/15.
 */
public class Foo {

    private int id;
    private String name;

    public Foo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Foo(FooRecord record) {
        this.id = record.getId();
        this.name = record.getName();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
