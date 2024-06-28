package ir.snapppay.bankingservice.config;


import ir.snapppay.bankingservice.constant.CallingResult;
import ir.snapppay.bankingservice.payload.response.BaseRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@Slf4j
public class GeneralExceptionHandler {

    @ResponseBody
    @ExceptionHandler({HttpMessageNotReadableException.class, MethodArgumentNotValidException.class, MissingServletRequestParameterException.class})
    public ResponseEntity<BaseRes> badRequestExceptionHandler(Exception exception) {
        log.error("this bad parameter Exception Raised and Caught By ControllerAdvice: " + exception.getMessage());
        return ResponseEntity.badRequest()
                .body(BaseRes.builder().resultCode(HttpStatus.BAD_REQUEST.value())
                        .description(exception.getMessage()).build());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseRes> generalExceptionHandler(Exception exception) {
        log.error("this unknown internal server Exception Raised and Caught By ControllerAdvice: " + exception.getMessage());
        return ResponseEntity.internalServerError()
                .body(BaseRes.builder().resultCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .description(CallingResult.INTERNAL_ERROR.getDescription()).build());
    }
}
