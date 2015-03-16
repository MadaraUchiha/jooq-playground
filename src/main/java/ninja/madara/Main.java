package ninja.madara;

import ninja.madara.domainobject.Foo;

import java.util.logging.LogManager;

public class Main {

    // Called with input from user in args
    public static void main(String[] args) {

        // KILL THE ANNOYING BANNER!
        LogManager.getLogManager().reset();

        // Imagine it's DI
        FooService fooService = new FooService(new FooMapper("postgres", "password", "jdbc:postgresql:postgres"));
        Foo foo = fooService.getFooById(Integer.parseInt(args[0], 10));

        System.out.println(foo.getName());
    }
}

