package org.andromda.presentation.bpm4struts;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.Arg;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.Resources;

public class CoppetecStrutsValidator
    implements Serializable
{

        public static boolean cptGenericValidator(
            Object bean,
            ValidatorAction validatorAction,
            Field field,
            ActionMessages errors,
            Validator validator,
            HttpServletRequest request)
        {
            boolean valid = true;
            String genericField = ValidatorUtils.getValueAsString(bean, field
                .getProperty());
            String caracteresInvalidos = "";
          	if (genericField != null) {
          		 for (int i=0; i < caracteresInvalidos.length();i++) {
                     if (genericField.indexOf(caracteresInvalidos.charAt(i)) > -1) {
                    	 Arg arg = new Arg();
                    	 arg.setPosition(1);
                    	 arg.setKey(caracteresInvalidos);
                    	 arg.setResource(false);
                    	 field.addArg(arg);
                    	 valid = false;
                     }
          		 }
           	}
            if (!valid)
            {
            	final HttpSession session = request.getSession();
                session.setAttribute(Globals.MESSAGE_KEY, errors);
            	
                errors.add("org.andromda.bpm4struts.errormessages", Resources.getActionMessage(
                    request,
                    validatorAction,
                    field));
            }
            return valid;
        }

}