/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CriptografiaUtil {

    private static final String CHAVE =
            "12345678901234567890123456789012"; // 32 chars

    public static String criptografar(String texto) {
        try {

            SecretKeySpec secretKey =
                    new SecretKeySpec(CHAVE.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] criptografado =
                    cipher.doFinal(texto.getBytes(StandardCharsets.UTF_8));

            return Base64.getEncoder().encodeToString(criptografado);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String descriptografar(String textoCriptografado) {
        try {

            SecretKeySpec secretKey =
                    new SecretKeySpec(CHAVE.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] original = cipher.doFinal(
                    Base64.getDecoder().decode(textoCriptografado));

            return new String(original, StandardCharsets.UTF_8);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}