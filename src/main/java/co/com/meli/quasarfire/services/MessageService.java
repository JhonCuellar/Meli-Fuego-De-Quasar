package co.com.meli.quasarfire.services;

import co.com.meli.quasarfire.exception.ServiceException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de procesar los mensajee de los satélites para retornar
 * un mensaje unificado
 */
@Service
public class MessageService {

    /**
     * Procesa los mensajes recibidos de cada satélite
     * @param messages Mensajes recibidos
     * @return Mensaje unificado
     * @throws ServiceException
     */
    public String getMessage(List<List<String>> messages) throws ServiceException {
        if (messages.size() != 3)
            throw new ServiceException("Se deben ingresar los mensajes por cada satelite");

        if (!isSizeMessage(messages))
            throw new ServiceException("El tamaño de los mensajes no es el mismo");

        return compileMessage(messages);
    }

    private boolean isSizeMessage(List<List<String>> messages) {
        int size = messages.get(0).size();
        if (size == 0)
            return false;
        for (List<String> message : messages) {
            if (message.size() != size)
                return false;
        }
        return true;
    }

    private String compileMessage(List<List<String>> messages) {
        List<String> compiledMessage = new ArrayList<>();
        for (List<String> message : messages) {
            for (int i = 0; i < message.size(); i++) {
                if (compiledMessage.size() <= i)
                    compiledMessage.add("");
                if (!"".equals(message.get(i).trim())) {
                    compiledMessage.set(i, message.get(i));
                }
            }
        }

        return String.join(" ", compiledMessage);
    }
}
