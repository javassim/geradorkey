/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String NOME_BANCO =
            "javasys.db";

    public static Connection conectar() throws Exception {

        // PEGA A PASTA DO PROJETO/JAR
        File pastaProjeto = new File(
                Conexao.class
                .getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .toURI()
        ).getParentFile().getParentFile();

        // CAMINHO DA PASTA DB
        String caminhoBanco =
                pastaProjeto.getAbsolutePath()
                + File.separator
                + "sys"
                + File.separator
                + NOME_BANCO;

        // URL SQLITE
        String url =
                "jdbc:sqlite:" + caminhoBanco;

        // CONEXÃO
        return DriverManager.getConnection(url);
    }
}