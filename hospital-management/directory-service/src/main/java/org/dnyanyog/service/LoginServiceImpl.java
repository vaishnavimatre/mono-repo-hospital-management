package org.dnyanyog.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.entity.Directory;
import org.dnyanyog.enumm.ResponseCode;
import org.dnyanyog.repo.DirectoryServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl {

  @Autowired DirectoryServiceRepository userRepo;

  public LoginResponse validateUser(LoginRequest loginRequest) {
    LoginResponse response = new LoginResponse();
    List<Directory> usersList = userRepo.findBymobno(loginRequest.getMobno());

    if (usersList.size() == 1) {
      Directory userData = usersList.get(0);

      String encryptedPassword = userData.getPassword();
      String userKey = userData.getEncryptionKey();

      if (loginRequest.getPassword() != null && userKey != null) {
        String inputEncryptedPassword = encryptAES(loginRequest.getPassword(), userKey);

        if (inputEncryptedPassword.equalsIgnoreCase(encryptedPassword)) {
          response.setStatus(ResponseCode.Login_Success.getStatus());
          response.setMessage(ResponseCode.Login_Success.getMessage());

        } else {
          response.setStatus(ResponseCode.Login_Fail.getStatus());
          response.setMessage(ResponseCode.Login_Fail.getMessage());
        }
      } else {
        response.setStatus(ResponseCode.Login_Fail.getStatus());
        response.setMessage("Password or encryption key is null");
      }
    } else {
      response.setStatus(ResponseCode.Login_Fail.getStatus());
      response.setMessage(ResponseCode.Login_Fail.getMessage());
    }
    return response;
  }

  private String encryptAES(String input, String key) {
    if (input == null || key == null) {
      throw new IllegalArgumentException("Input and key cannot be null");
    }
    try {
      Cipher cipher = Cipher.getInstance("AES");
      SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(key), "AES");
      cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
      byte[] encryptedBytes = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
      return Base64.getEncoder().encodeToString(encryptedBytes);
    } catch (Exception e) {
      throw new RuntimeException("Error encrypting with AES", e);
    }
  }

  private String decryptAES(String input, String key) {
    if (input == null || key == null) {
      throw new IllegalArgumentException("Input and key cannot be null");
    }
    try {
      Cipher cipher = Cipher.getInstance("AES");
      SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(key), "AES");
      cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
      byte[] decodedBytes = Base64.getDecoder().decode(input);
      byte[] decryptedBytes = cipher.doFinal(decodedBytes);
      return new String(decryptedBytes, StandardCharsets.UTF_8);
    } catch (Exception e) {
      throw new RuntimeException("Error decrypting with AES", e);
    }
  }
}