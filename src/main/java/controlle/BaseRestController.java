package controlle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import service.exception.BusinessException;
import service.exception.NoContentException;

@RequestMapping("/api")
public abstract class BaseRestController {

	@ExceptionHandler(NoContentException.class)
	public ResponseEntity<Void> handlerNoContent(NoContentException exeption){
		return ResponseEntity.noContent().build();
	}
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity< ApiErrorDTO> handlerBusinessException( BusinessException exeption){
		 ApiErrorDTO error = new  ApiErrorDTO(exeption.getMessage());
		return ResponseEntity.badRequest().body(error);
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity< ApiErrorDTO> handlerUnexpectedException( Throwable exeption){
		exeption.printStackTrace();
		 ApiErrorDTO error = new  ApiErrorDTO("Ops, ocorreu um erro inesperado ");
		return ResponseEntity.internalServerError().body(error);
	}
}
