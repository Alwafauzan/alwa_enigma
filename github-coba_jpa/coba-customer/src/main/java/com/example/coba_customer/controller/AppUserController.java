// package com.example.coba_customer.controller;

// import org.modelmapper.ModelMapper;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseStatus;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.coba_customer.dto.AppUserData;
// import com.example.coba_customer.model.AppUser;
// import com.example.coba_customer.model.ResponseData;
// import com.example.coba_customer.service.AppUserService;

// @RestController
// @RequestMapping("/api/appuser")
// // @RequiredArgsConstructor
// public class AppUserController {

// @Autowired
// private AppUserService appUserService;

// @Autowired
// private ModelMapper modelMapper;

// @PostMapping("/register")
// @ResponseStatus(HttpStatus.CREATED)
// public ResponseEntity<ResponseData<AppUser>> register(@RequestBody
// AppUserData userData) {
// // ResponseData<AppUser> response = new ResponseData<>();

// // AppUser appUser = modelMapper.map(userData, AppUser.class);

// // response.setPayload(appUserService.registerAppUser(appUser));

// // Membuat objek ResponseData
// ResponseData<AppUser> response = new ResponseData<>();

// // Mapping userData ke AppUser
// AppUser appUser = modelMapper.map(userData, AppUser.class);

// // Registrasi user
// AppUser registeredUser = appUserService.registerAppUser(appUser);

// // Set response payload dan status
// response.setStatus(true);
// response.setMessage("Registrasi berhasil");
// response.setPayload(registeredUser);

// // Mengembalikan ResponseEntity dengan status HTTP yang benar
// return ResponseEntity.ok(response);
// }
// }
