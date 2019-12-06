package ua.biedin.blog.service.interfaces;

import ua.biedin.blog.controller.response.LoginResponse;


public interface LoginService {

    LoginResponse login(String login, String password);

}
