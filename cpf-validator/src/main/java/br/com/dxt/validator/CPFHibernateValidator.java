package br.com.dxt.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPFHibernateValidator implements ConstraintValidator<CPF, String> {

    public void initialize(CPF annotation) {
        return;
    }

    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        if (cpf == null) {
            return false;
        }

        return ValidadorCpf.validaCpf(cpf);
    }

}
