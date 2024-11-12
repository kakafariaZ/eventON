package models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class UsuarioLoader {

    private static final String CAMINHO_ARQUIVO_JSON = "usuarios.json";  // Caminho do arquivo JSON

    // Método para carregar usuários a partir do arquivo JSON
    public static List<Usuario> carregarUsuarios() {
        try (FileReader reader = new FileReader(CAMINHO_ARQUIVO_JSON)) {
            Gson gson = new Gson();
            Type usuarioListType = new TypeToken<List<Usuario>>() {}.getType();
            return gson.fromJson(reader, usuarioListType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;  // Retorna null caso haja algum erro ao carregar o arquivo
        }
    }

    // Método para validar o login
    public static Usuario validarLogin(String login, String senha) {
        List<Usuario> usuarios = carregarUsuarios();  // Carrega todos os usuários do JSON
        if (usuarios != null) {
            for (Usuario usuario : usuarios) {
                if (usuario.login(login, senha)) {  // Verifica se as credenciais estão corretas
                    return usuario;  // Retorna o usuário se as credenciais forem corretas
                }
            }
        }
        return null;  // Retorna null caso as credenciais sejam incorretas
    }
}
