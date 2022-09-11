package com.trn.core.api.controllers;


import com.trn.core.api.payloads.ApiResponse;
import com.trn.core.api.payloads.UserDto;
import com.trn.core.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //POST-create user
    @PostMapping("/")
    public ResponseEntity<UserDto> createdUser(@RequestBody UserDto userDto){
        UserDto createdUserDto =  this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    //PUT- update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer uId )
    {
        UserDto updatedUser = this.userService.updateUser(userDto,uId);
        return ResponseEntity.ok(updatedUser);

    }

    //DELETE- delete user

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uId)
    {
     this.userService.deleteUser(uId);
     return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK)
    }

    //GET - get user

}
