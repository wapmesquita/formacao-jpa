package br.com.dxt.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Path.Node;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidacaoUtils {

    private static <T> Set<ConstraintViolation<T>> validate(T bean, String... properties) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> ret;
        if (properties.length > 0) {
            ret = new HashSet<ConstraintViolation<T>>(properties.length);
            for (String property : properties) {
                Set<ConstraintViolation<T>> cv = validator.validateProperty(bean, property);
                ret.addAll(cv);
            }
        } else {
            ret = validator.validate(bean);
        }
        return ret;
    }

    public static <T> List<ErroValidacao> valida(T bean, String... propriedades) {
        List<ErroValidacao> erros = new ArrayList<ErroValidacao>();
        Set<ConstraintViolation<T>> cvs = validate(bean, propriedades);
        for (ConstraintViolation<T> cv : cvs) {
            StringBuilder builder = new StringBuilder();
            for (Node node : cv.getPropertyPath()) {
                if (builder.length() > 0) {
                    builder.append('.');
                }
                builder.append(node.getName());
            }
            String field = builder.toString();
            ErroValidacao erro = new ErroValidacao();
            erro.setField(field);
            erro.setArgs(new String[] { field });
            erro.setCode(cv.getMessageTemplate().replaceAll("[{|}]", ""));
            erros.add(erro);
        }
        return erros;
    }

}
