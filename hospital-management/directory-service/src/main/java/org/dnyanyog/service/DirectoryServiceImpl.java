package org.dnyanyog.service;

import java.nio.charset.StandardCharsets;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.dnyanyog.dto.DirectoryServiceRequest;
import org.dnyanyog.dto.DirectoryServiceResponse;
import org.dnyanyog.entity.Directory;

import org.dnyanyog.enumm.ResponseCode;
import org.dnyanyog.exception.PasswordMismatchException;
import org.dnyanyog.repo.DirectoryServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class DirectoryServiceImpl {

  @Autowired private DirectoryServiceRepository userRepo;
  @Autowired private DirectoryServiceResponse userResponse;

  public DirectoryServiceResponse addUser(@Valid DirectoryServiceRequest request) throws Exception {
    try {

  
      Directory newUser = new Directory();
      String userKey = generateAESKey();
      newUser.setConfirm(encryptAES(request.getConfirm(), userKey));
      newUser.setEmail(request.getEmail());
      newUser.setMobno(request.getMobno());
      newUser.setPassword(encryptAES(request.getPassword(), userKey));
      newUser.setRole(request.getRole());
      newUser.setUsername(request.getUsername());
      newUser.setEncryptionKey(userKey);
    

      newUser = userRepo.save(newUser);

      userResponse.setStatus(ResponseCode.Add_User_Success.getStatus());
      userResponse.setMessage(ResponseCode.Add_User_Success.getMessage());
  
    } catch (Exception e) {
      userResponse.setStatus(ResponseCode.Add_User_Fail.getStatus());
      userResponse.setMessage(ResponseCode.Add_User_Fail.getMessage());
    }

    return userResponse;
  }

  public DirectoryServiceResponse updateUser(long user_id, DirectoryServiceRequest request) {

    Optional<Directory> optionalUser = userRepo.findById(user_id);

    if (optionalUser.isEmpty()) {
      userResponse.setMessage(ResponseCode.Update_User_Fail.getMessage());
      userResponse.setStatus(ResponseCode.Update_User_Fail.getStatus());
    } else {
      Directory user = optionalUser.get();
      String userKey = user.getEncryptionKey();

      if (request.getConfirm() != null && userKey != null) {
        user.setConfirm(encryptAES(request.getConfirm(), userKey));
      }
      if (request.getPassword() != null && userKey != null) {
        user.setPassword(encryptAES(request.getPassword(), userKey));
      }
      user.setEmail(request.getEmail());
      user.setMobno(request.getMobno());
      user.setRole(request.getRole());
      user.setUsername(request.getUsername());

      userRepo.save(user);

     
      userResponse.setMessage(ResponseCode.Update_User_Fail.getMessage());
      userResponse.setStatus(ResponseCode.Update_User_Fail.getStatus());
    }
    return userResponse;
  }

  public DirectoryServiceResponse getSingleUser(long user_id) {
    Optional<Directory> optionalUser = userRepo.findById(user_id);

    DirectoryServiceResponse  userResponse = DirectoryServiceResponse .getInstance();
    if (optionalUser.isEmpty()) {
      userResponse.setMessage(ResponseCode.Check_User_Fail.getMessage());
      userResponse.setStatus(ResponseCode.Check_User_Fail.getStatus());
    } else {
      Directory user = optionalUser.get();
      populateUserResponse(userResponse, user);
      userResponse.setMessage(ResponseCode.Check_User_Success.getMessage());
      userResponse.setStatus(ResponseCode.Check_User_Success.getStatus());
    }
    return userResponse;
  }

  public DirectoryServiceResponse  deleteUser(long user_id) {
    Optional<Directory> optionalUser = userRepo.findById(user_id);
    if (optionalUser.isEmpty()) {
      userResponse.setMessage(ResponseCode.Delete_User_Fail.getMessage());
      userResponse.setStatus(ResponseCode.Delete_User_Fail.getStatus());
    } else {
      Directory user = optionalUser.get();
     // user.setStatus(Directory.Status.DELETED);
      userRepo.save(user);

      userResponse.setMessage(ResponseCode.Delete_User_Success.getMessage());
      userResponse.setStatus(ResponseCode.Delete_User_Success.getStatus());
      populateUserResponse(userResponse, user);
    }
    return userResponse;
  }

  private void populateUserResponse(DirectoryServiceResponse  response, Directory users) {

    response.setEmail(users.getEmail());
    response.setMobno(users.getMobno());
    response.setRole(users.getRole());
    response.setUsername(users.getUsername());
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

  private String generateAESKey() {
    try {
      KeyGenerator keyGen = KeyGenerator.getInstance("AES");
      keyGen.init(256);
      SecretKey secretKey = keyGen.generateKey();
      byte[] encodedKey = secretKey.getEncoded();
      return Base64.getEncoder().encodeToString(encodedKey);
    } catch (Exception e) {
      throw new RuntimeException("Error generating AES key", e);
    }
  }
}