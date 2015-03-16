package ninja.madara;

import static org.jooq.ninja.madara.Tables.*;

// For convenience, always static import your generated tables and jOOQ functions to decrease verbosity:
import ninja.madara.domainobject.Foo;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.ninja.madara.tables.records.FooRecord;

import java.sql.Connection;
import java.sql.DriverManager;

public class FooMapper implements Mapper<Foo> {

    private String username;
    private String password;
    private String connectionString;

    public FooMapper(String username, String password, String connectionString) {
        this.username = username;
        this.password = password;
        this.connectionString = connectionString;
    }


    @Override
    public Foo fetch(Foo input) {
        Foo result = null;
        try (Connection conn = DriverManager.getConnection(connectionString, username, password)) {
            DSLContext jooq = DSL.using(conn, SQLDialect.POSTGRES);
            FooRecord record = jooq.selectFrom(FOO).where(FOO.ID.eq(input.getId())).fetchOne();

            result = new Foo(record);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void store(Foo input) {
        // Todo
    }
}
