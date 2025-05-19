package pl.edytaborowska.githubwithspring;

public class UnsupportedMediaTypeException extends RuntimeException{
    public UnsupportedMediaTypeException(String message){
        super(message);
    }
}
