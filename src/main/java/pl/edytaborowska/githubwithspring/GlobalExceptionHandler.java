package pl.edytaborowska.githubwithspring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<GitHubErrorResponse> handleUserNotFound(UserNotFoundException ex) {
        GitHubErrorResponse response = new GitHubErrorResponse("404", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<GitHubErrorResponse> handleUnsupportedMediaType(HttpMediaTypeNotAcceptableException ex) {
        GitHubErrorResponse response = new GitHubErrorResponse("406", "Only application/json supported");
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }
}
