package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * @author MacBook
 * Klasse zur Passwort Validierung
 *
 */
@FacesValidator("PasswordValidation")
public class PasswordValidator implements Validator{

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%/+&!()?-]).{6,20})";

	private Pattern pattern;
	private Matcher matcher;
	
	/**
	 * Kontruktor
	 */
	public PasswordValidator(){
		  pattern = Pattern.compile(PASSWORD_PATTERN);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
			
			FacesMessage msg = new FacesMessage("Falsches Passwortformat");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}
	}
	
	/**
	 * Boolean zur Validierung
	 * @param passwort
	 * @return
	 */
	public boolean validate(String passwort){
		matcher = pattern.matcher(passwort);
		if(!matcher.matches()){
			return false;
		}
		return true;
	}
}