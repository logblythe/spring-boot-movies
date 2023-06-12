package dev.sikshya.movies.exception;

public class CollectionException extends Exception{

    public CollectionException(String message){
        super(message);
    }

    public static String NotFoundException(String id){
        return "Collection with "+id+" not found";
    }

    public static String AlreadyExistsException(){
        return "Collection already exists";
    }
}
