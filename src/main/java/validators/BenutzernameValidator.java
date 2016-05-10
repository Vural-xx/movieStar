package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;



@FacesValidator("BenutzernameValidator")
public class BenutzernameValidator implements Validator{

	private static final String PASSWORT_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{5,10}";

	private Pattern pattern;
	private Matcher matcher;
	
	public BenutzernameValidator(){
		  pattern = Pattern.compile(PASSWORT_PATTERN);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
			
			FacesMessage msg = new FacesMessage("Falsches E-Mail Format");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}

	}
}