package com.star.onlineshopping.controller;

 

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.star.onlineshopping.dto.ResponseDto;
import com.star.onlineshopping.dto.UserDto;
import com.star.onlineshopping.dto.UserReqDto;
import com.star.onlineshopping.dto.UserResDto;
import com.star.onlineshopping.exception.CredentialMissmatchException;
import com.star.onlineshopping.exception.UserExistException;
import com.star.onlineshopping.service.UserService;
import com.star.onlineshopping.utility.ErrorConstant;

 

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerTest {
    @InjectMocks
    UserController userController;
    @Mock
    UserService userService;

    
    @Test
	public void userRegistration() throws UserExistException , CredentialMissmatchException  {
	UserReqDto userReqDto = new UserReqDto();
	userReqDto.setConfirmPassword("nagajyoti@123");
	userReqDto.setPassword("nagajyoti@123");
	userReqDto.setEmail("nagajyoti@gmail.com");
	userReqDto.setName("Nagajyoti");
	userReqDto.setUserType("Priority");
	userReqDto.setPhoneNumber("9980111546");

	UserResDto responseDto = new UserResDto();
	responseDto.setStatusCode(ErrorConstant.USER_REGISTERED_CODE);
	responseDto.setMessage(ErrorConstant.USER_REGISTERED + " " + userReqDto.getEmail() + " " + "Is your User Name");

	Mockito.when(userService.userRegistration(userReqDto)).thenReturn(responseDto);
	ResponseEntity<UserResDto> result = userController.userRegistration(userReqDto);

	assertEquals(HttpStatus.OK, result.getStatusCode());

	}
 

    @Test
    public void userLoginTest() {
        UserDto userDto = new UserDto();
        userDto.setEmail("abc@gmail.com");
        userDto.setPassword("asdf");

 

        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatusCode(ErrorConstant.INVALID_INPUT_CODE);
        responseDto.setStatusMessage(ErrorConstant.INVALID_INPUT);


 

        Mockito.when(userService.userLogin(userDto)).thenReturn(responseDto);
        ResponseEntity<ResponseDto> result = userController.userLogin(userDto);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

 

}