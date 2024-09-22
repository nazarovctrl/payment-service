package uz.ccrew.paymentservice.exp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.ccrew.paymentservice.response.Response;
import uz.ccrew.paymentservice.response.ResponseMaker;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status, WebRequest request) {
        Response<?> r = new Response<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(fieldError -> r.addError(fieldError.getDefaultMessage()));

        return ResponseEntity.badRequest().body(r);
    }

    @ExceptionHandler({BasicException.class})
    private ResponseEntity<Response<?>> basicHandler(BasicException e) {
        return ResponseMaker.error(e.getStatus(), e.getMessage());
    }

    @ExceptionHandler({BadCredentialsException.class, AccessDeniedException.class})
    private ResponseEntity<Response<?>> forbiddenHandler(RuntimeException e) {
        return ResponseMaker.error(HttpStatus.FORBIDDEN, e.getMessage());
    }


    @ExceptionHandler({Exception.class})
    private ResponseEntity<Response<?>> handle(Exception e) {
        e.printStackTrace();
        return ResponseMaker.error(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}